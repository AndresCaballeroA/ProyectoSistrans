package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente extends Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    public Cliente(String login, String contrasena,  String tipoDocumento, String numeroDocumento, String nombre, String nacionalidad,  String direccion, String email, String telefono, String ciudad, String departamento, String codigoPostal, Integer id_cliente){
        super(login, contrasena, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal);
        this.id = id_cliente;
    }

    public Cliente()
    {;}

}
