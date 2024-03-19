package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Cuenta;

import java.sql.Date;
import java.util.Collection;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM CUENTA", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM CUENTA WHERE id = :id", nativeQuery = true)
    Cuenta darCuentaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTA (id, saldo, tipo, estado, fechaCreacion) VALUES (:id, :saldo, :tipo, :estado, fechaCreacion)", nativeQuery = true)
    void insertarCuenta(@Param("id") Integer id, @Param("saldo") Integer saldo, @Param("tipo") String tipo, @Param("estado") String estado, @Param("fechaCreacion") Date fechaCreacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET saldo = :saldo, tipo = :tipo, estado = :estado, fechaCreacion = :fechaCreacion WHERE id = :id", nativeQuery = true)
    void actualizarCuenta(@Param("id") Integer id, @Param("saldo") Integer saldo, @Param("tipo") String tipo, @Param("estado") String estado, @Param("fechaCreacion") Date fechaCreacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTA WHERE id = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") Integer id);

    @Query(value = "SELECT DISTINCT C.* FROM CUENTA C INNER JOIN OPERACIONCUENTA OC ON C.ID = OC.ID_CUENTA WHERE C.TIPO = :tipo AND C.fechaCreacion = :fechaCreacion AND OC.fechaYHora = :ultimoMove C.SALDO BETWEEN :minSaldo AND :maxSaldo", nativeQuery = true)
    Collection<Cuenta> darCuentasPorCriterio(@Param("tipo") String tipo, @Param("minSaldo") int minSaldo, @Param("maxSaldo") int maxSaldo, @Param("fechaCreacion") java.util.Date fechaCreacion, @Param("ultimo_mov") java.util.Date ultimoMove);
}

