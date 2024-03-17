package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;  

import uniandes.edu.co.proyecto.Modelos.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM USUARIO WHERE id= :id", nativeQuery = true)
    Banner darUsuario(@Param("id") int id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (id, login, contraseña, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal) VALUES(parranderos_sequence.nextval, :login, :contraseña, :tipoDocumento, :numeroDocumento, :nombre, :nacionalidad, :direccion, :email, :telefono, :ciudad, :departamento, :codigoPostal )", nativeQuery = true )
    void insertarUsuario(@Param("login") String login, @Param("contraseña") String contraseña, @Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") String telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIO SET login = :login, contraseña = :contraseña, tipoDocumento = :tipoDocumento, numeroDocumento = :numeroDocumento, nombre = :nombre, nacionalidad = :nacionalidad, direccion = :direccion, email = :email, telefono = :telefono, ciudad = :ciudad, departamento = :departamento, codigoPostal = :codigoPostal WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id, @Param("login") String login, @Param("contraseña") String contraseña, @Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") String telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIO WHEN id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("login") String login);
}
