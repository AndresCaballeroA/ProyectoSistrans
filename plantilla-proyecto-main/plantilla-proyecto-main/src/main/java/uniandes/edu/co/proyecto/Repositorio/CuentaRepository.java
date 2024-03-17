package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Cuenta;

import java.util.Collection;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM CUENTA", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM CUENTA WHERE id = :id", nativeQuery = true)
    Cuenta darCuentaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTA (id, saldo, tipo, estado) VALUES (:id, :saldo, :tipo, :estado)", nativeQuery = true)
    void insertarCuenta(@Param("id") Integer id, @Param("saldo") Integer saldo, @Param("tipo") String tipo, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET saldo = :saldo, tipo = :tipo, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarCuenta(@Param("id") Integer id, @Param("saldo") Integer saldo, @Param("tipo") String tipo, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTA WHERE id = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") Integer id);
}

