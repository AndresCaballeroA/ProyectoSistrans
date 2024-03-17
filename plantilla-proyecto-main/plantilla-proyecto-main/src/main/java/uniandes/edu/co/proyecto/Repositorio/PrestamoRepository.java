package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Prestamo;

import java.util.Collection;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    @Query(value = "SELECT * FROM PRESTAMO", nativeQuery = true)
    Collection<Prestamo> findAllPrestamos();

    @Query(value = "SELECT * FROM PRESTAMO WHERE id = :id", nativeQuery = true)
    Prestamo findPrestamoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO (id, estado, tipo, monto, interes, numCuotas, numMes, valorCuota) VALUES (:id, :estado, :tipo, :monto, :interes, :numCuotas, :numMes, :valorCuota)", nativeQuery = true)
    void insertPrestamo(@Param("id") Integer id, @Param("estado") String estado, @Param("tipo") String tipo, @Param("monto") Integer monto, @Param("interes") Float interes, @Param("numCuotas") Integer numCuotas, @Param("numMes") Integer numMes, @Param("valorCuota") Integer valorCuota);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET estado = :estado, tipo = :tipo, monto = :monto, interes = :interes, numCuotas = :numCuotas, numMes = :numMes, valorCuota = :valorCuota WHERE id = :id", nativeQuery = true)
    void updatePrestamo(@Param("id") Integer id, @Param("estado") String estado, @Param("tipo") String tipo, @Param("monto") Integer monto, @Param("interes") Float interes, @Param("numCuotas") Integer numCuotas, @Param("numMes") Integer numMes, @Param("valorCuota") Integer valorCuota);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMO WHERE id = :id", nativeQuery = true)
    void deletePrestamo(@Param("id") Integer id);
}
