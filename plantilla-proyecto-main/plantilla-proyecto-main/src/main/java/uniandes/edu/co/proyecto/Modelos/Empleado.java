package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
@PrimaryKeyJoinColumn(name = "id")

public class Empleado extends Usuario {

    @Column(name = "rolEmpleado")
    private String rol;

    public Empleado(String login, String contrasena,  String tipoDocumento, String numeroDocumento, String nombre, String nacionalidad,  String direccion, String email, String telefono, String ciudad, String departamento, String codigoPostal, Integer id_empleado, String rolString){
        super(login, contrasena, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal);
        this.rol = "empleado";
    
    }

    public Empleado()
    {;}

}
