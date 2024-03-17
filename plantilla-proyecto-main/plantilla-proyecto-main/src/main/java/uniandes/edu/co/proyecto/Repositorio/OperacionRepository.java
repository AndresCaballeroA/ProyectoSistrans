package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Operacion;

import java.util.Collection;

public interface OperacionRepository extends JpaRepository<Operacion, Integer> {

    @Query(value = "SELECT * FROM OPERACION", nativeQuery = true)
    Collection<Operacion> findAllOperaciones();

    @Query(value = "SELECT * FROM OPERACION WHERE id = :id", nativeQuery = true)
    Operacion findOperacionById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION (id, fechaYHora, tipoOperacion) VALUES (:id, :fechaYHora, :tipoOperacion)", nativeQuery = true)
    void insertOperacion(@Param("id") Integer id, @Param("fechaYHora") java.util.Date fechaYHora, @Param("tipoOperacion") String tipoOperacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION SET fechaYHora = :fechaYHora, tipoOperacion = :tipoOperacion WHERE id = :id", nativeQuery = true)
    void updateOperacion(@Param("id") Integer id, @Param("fechaYHora") java.util.Date fechaYHora, @Param("tipoOperacion") String tipoOperacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION WHERE id = :id", nativeQuery = true)
    void deleteOperacion(@Param("id") Integer id);
}
