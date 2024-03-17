package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.OperacionPrestamo;

import java.util.Collection;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, Integer> {

    @Query(value = "SELECT * FROM OPERACION_PRESTAMO", nativeQuery = true)
    Collection<OperacionPrestamo> findAllOperacionPrestamos();

    @Query(value = "SELECT * FROM OPERACION_PRESTAMO WHERE id = :id", nativeQuery = true)
    OperacionPrestamo findOperacionPrestamoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION_PRESTAMO (id, numPrestamo, montoPago) VALUES (:id, :numPrestamo, :montoPago)", nativeQuery = true)
    void insertOperacionPrestamo(@Param("id") Integer id, @Param("numPrestamo") Integer numPrestamo, @Param("montoPago") Integer montoPago);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_PRESTAMO SET numPrestamo = :numPrestamo, montoPago = :montoPago WHERE id = :id", nativeQuery = true)
    void updateOperacionPrestamo(@Param("id") Integer id, @Param("numPrestamo") Integer numPrestamo, @Param("montoPago") Integer montoPago);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_PRESTAMO WHERE id = :id", nativeQuery = true)
    void deleteOperacionPrestamo(@Param("id") Integer id);
}
