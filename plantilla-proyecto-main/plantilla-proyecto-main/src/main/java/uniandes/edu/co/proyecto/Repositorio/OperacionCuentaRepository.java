package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.OperacionCuenta;

import java.util.Collection;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta, Integer> {

    @Query(value = "SELECT * FROM OPERACION_CUENTA", nativeQuery = true)
    Collection<OperacionCuenta> findAllOperacionCuentas();

    @Query(value = "SELECT * FROM OPERACION_CUENTA WHERE id = :id", nativeQuery = true)
    OperacionCuenta findOperacionCuentaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION_CUENTA (id, numeroOrigen, numeroDestino, monto) VALUES (:id, :numeroOrigen, :numeroDestino, :monto)", nativeQuery = true)
    void insertOperacionCuenta(@Param("id") Integer id, @Param("numeroOrigen") Integer numeroOrigen, @Param("numeroDestino") Integer numeroDestino, @Param("monto") Integer monto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_CUENTA SET numeroOrigen = :numeroOrigen, numeroDestino = :numeroDestino, monto = :monto WHERE id = :id", nativeQuery = true)
    void updateOperacionCuenta(@Param("id") Integer id, @Param("numeroOrigen") Integer numeroOrigen, @Param("numeroDestino") Integer numeroDestino, @Param("monto") Integer monto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_CUENTA WHERE id = :id", nativeQuery = true)
    void deleteOperacionCuenta(@Param("id") Integer id);
}
