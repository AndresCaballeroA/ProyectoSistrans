package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Cliente;

import java.util.Collection;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM CLIENTE WHERE id = :id", nativeQuery = true)
    Cliente darClientePorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CLIENTE (id) VALUES (:id)", nativeQuery = true)
    void insertarCliente(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CLIENTE SET id = :id WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLIENTE WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);

    @Query(value = "SELECT * FROM CLIENTE "
             + "INNER JOIN CUENTA ON CLIENTE.id = CUENTA.id "
             + "INNER JOIN OFICINA ON CUENTA.id = OFICINA.id "
             + "INNER JOIN PRESTAMO ON CLIENTE.id = PRESTAMO.id "
             + "WHERE CLIENTE.id = :clienteId")
    Cliente darInformacionCliente(@Param("clienteId") String clienteId);
}
