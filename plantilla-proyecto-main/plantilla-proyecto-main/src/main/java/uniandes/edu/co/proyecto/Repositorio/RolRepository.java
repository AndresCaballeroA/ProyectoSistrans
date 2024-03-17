package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Rol;

import java.util.Collection;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query(value = "SELECT * FROM ROL", nativeQuery = true)
    Collection<Rol> findAllRoles();

    @Query(value = "SELECT * FROM ROL WHERE id = :id", nativeQuery = true)
    Rol findRolById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ROL (id, tipo) VALUES (:id, :tipo)", nativeQuery = true)
    void insertRol(@Param("id") Integer id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ROL SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void updateRol(@Param("id") Integer id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ROL WHERE id = :id", nativeQuery = true)
    void deleteRol(@Param("id") Integer id);
}
