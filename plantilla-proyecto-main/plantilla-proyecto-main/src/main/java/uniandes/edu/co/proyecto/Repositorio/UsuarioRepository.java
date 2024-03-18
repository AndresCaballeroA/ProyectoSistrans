package uniandes.edu.co.proyecto.Repositorio;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelos.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    // Collection<Usuario> findAllUsuarios();

    @Query("SELECT u FROM Usuario u")
    List<Usuario> findAllUsuarios();

    @Query(value = "SELECT * FROM USUARIO WHERE id = :id", nativeQuery = true)
    Usuario findUsuarioById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (id, login, contrasena, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal) VALUES (:id, :login, :contrasena, :tipoDocumento, :numeroDocumento, :nombre, :nacionalidad, :direccion, :email, :telefono, :ciudad, :departamento, :codigoPostal)", nativeQuery = true)
    void insertUsuario(@Param("id") Integer id, @Param("login") String login, @Param("contrasena") String contrasena, @Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") String telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIO SET login = :login, contrasena = :contrasena, tipoDocumento = :tipoDocumento, numeroDocumento = :numeroDocumento, nombre = :nombre, nacionalidad = :nacionalidad, direccion = :direccion, email = :email, telefono = :telefono, ciudad = :ciudad, departamento = :departamento, codigoPostal = :codigoPostal WHERE id = :id", nativeQuery = true)
    void updateUsuario(@Param("id") Integer id, @Param("login") String login, @Param("contrasena") String contrasena, @Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") String telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIO WHERE id = :id", nativeQuery = true)
    void deleteUsuario(@Param("id") Integer id);

}
