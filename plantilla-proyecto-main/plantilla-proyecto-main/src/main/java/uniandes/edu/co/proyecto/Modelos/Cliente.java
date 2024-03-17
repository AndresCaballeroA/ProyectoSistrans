package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario{
    

    public Cliente(String login, String contrasena,  String tipoDocumento, String numeroDocumento, String nombre, String nacionalidad,  String direccion, String email, String telefono, String ciudad, String departamento, String codigoPostal, Integer id_cliente){
        super(login, contrasena, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal);
    }

    public Cliente()
    {;}

}
