package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelos.Cliente;
import uniandes.edu.co.proyecto.Modelos.Empleado;

import java.util.Collection;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "SELECT * FROM Empleado", nativeQuery = true)
    List<Empleado> findAllEmpleados();

    @Query(value = "SELECT * FROM Empleado WHERE id = :id", nativeQuery = true)
    Empleado findEmpleadoById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Empleado (id, rolEmpleado) VALUES (:id, :rolEmpleado)", nativeQuery = true)
    void insertEmpleado(Integer id, Integer rolEmpleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Empleado SET rolEmpleado = :rolEmpleado WHERE id = :id", nativeQuery = true)
    void updateEmpleado(Integer id, Integer rolEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Empleado WHERE id = :id", nativeQuery = true)
    void deleteEmpleado(Integer id);

    @Query(value = "SELECT * FROM CLIENTE "
    + "INNER JOIN CUENTA ON CLIENTE.id = CUENTA.cliente_id "
    + "INNER JOIN OFICINA ON CUENTA.oficina_id = OFICINA.id "
    + "INNER JOIN PRESTAMO ON CLIENTE.id = PRESTAMO.cliente_id "
    + "WHERE EMPLEADO.id = :empleadoid AND :rol = 'gerente_general'")
    Collection<Cliente> darInformacionClientesGerenteGeneral(@Param("empleadoId") String empleadoId, @Param("rol") String rol);

    @Query(value = "SELECT * FROM CLIENTE "
             + "INNER JOIN CUENTA ON CLIENTE.id = CUENTA.cliente_id "
             + "INNER JOIN OFICINA ON CUENTA.oficina_id = OFICINA.id "
             + "INNER JOIN PRESTAMO ON CLIENTE.id = PRESTAMO.cliente_id "
             + "WHERE OFICINA.id = (SELECT oficina_id FROM EMPLEADO WHERE id = :empleadoId) AND :rol = 'gerente_oficina'")
    Collection<Cliente> darInformacionClientesGerenteOficina(@Param("empleadoId") String empleadoId, @Param("rol") String rol);

}
