package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.ClienteEmpleado;
import uniandes.edu.co.proyecto.Modelos.ClienteEmpleadoId;

import java.util.Collection;

public interface ClienteEmpleadoRepository extends JpaRepository<ClienteEmpleado, ClienteEmpleadoId> {

    @Query(value = "SELECT * FROM CLIENTE_EMPLEADO", nativeQuery = true)
    Collection<ClienteEmpleado> findAllClienteEmpleados();

    @Query(value = "SELECT * FROM CLIENTE_EMPLEADO WHERE id_empleado = :idEmpleado AND id_cliente = :idCliente", nativeQuery = true)
    ClienteEmpleado findClienteEmpleadoByIds(@Param("idEmpleado") int idEmpleado, @Param("idCliente") int idCliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CLIENTE_EMPLEADO (id_empleado, id_cliente) VALUES (:idEmpleado, :idCliente)", nativeQuery = true)
    void insertClienteEmpleado(@Param("idEmpleado") Integer idEmpleado, @Param("idCliente") Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CLIENTE_EMPLEADO SET id_empleado = :idEmpleado, id_cliente = :idCliente WHERE id_empleado = :idEmpleado AND id_cliente = :idCliente", nativeQuery = true)
    void updateClienteEmpleado(@Param("idEmpleado") Integer idEmpleado, @Param("idCliente") Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLIENTE_EMPLEADO WHERE id_empleado = :idEmpleado AND id_cliente = :idCliente", nativeQuery = true)
    void deleteClienteEmpleado(@Param("idEmpleado") Integer idEmpleado, @Param("idCliente") Integer idCliente);
}