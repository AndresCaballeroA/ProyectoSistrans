package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.PuntoDeAtencion;

import java.util.Collection;

public interface PuntoDeAtencionRepository extends JpaRepository<PuntoDeAtencion, Integer> {

    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION", nativeQuery = true)
    Collection<PuntoDeAtencion> findAllPuntosDeAtencion();

    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION WHERE id = :id", nativeQuery = true)
    PuntoDeAtencion findPuntoDeAtencionById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTO_DE_ATENCION (id, tipo) VALUES (:id, :tipo)", nativeQuery = true)
    void insertPuntoDeAtencion(@Param("id") Integer id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PUNTO_DE_ATENCION SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void updatePuntoDeAtencion(@Param("id") Integer id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTO_DE_ATENCION WHERE id = :id", nativeQuery = true)
    void deletePuntoDeAtencion(@Param("id") Integer id);
}
