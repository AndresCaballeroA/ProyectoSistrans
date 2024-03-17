package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Oficina;

import java.util.Collection;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

    @Query(value = "SELECT * FROM OFICINA", nativeQuery = true)
    Collection<Oficina> findAllOficinas();

    @Query(value = "SELECT * FROM OFICINA WHERE id = :id", nativeQuery = true)
    Oficina findOficinaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINA (id, nombre, direccion, numPuntosPosibles) VALUES (:id, :nombre, :direccion, :numPuntosPosibles)", nativeQuery = true)
    void insertOficina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numPuntosPosibles") String numPuntosPosibles);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINA SET nombre = :nombre, direccion = :direccion, numPuntosPosibles = :numPuntosPosibles WHERE id = :id", nativeQuery = true)
    void updateOficina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numPuntosPosibles") String numPuntosPosibles);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINA WHERE id = :id", nativeQuery = true)
    void deleteOficina(@Param("id") Integer id);
}
