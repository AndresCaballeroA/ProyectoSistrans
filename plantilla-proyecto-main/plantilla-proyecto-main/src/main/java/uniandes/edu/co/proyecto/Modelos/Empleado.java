package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @JoinColumn(name="rolEmpleado", referencedColumnName="id")
    private Rol rolEmpleado;

    public Empleado(String login, String contrasena,  String tipoDocumento, String numeroDocumento, String nombre, String nacionalidad,  String direccion, String email, String telefono, String ciudad, String departamento, String codigoPostal, Integer id_empleado, Rol rolEmpleado){
        super(login, contrasena, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal);
        this.id = id_empleado;
        this.rolEmpleado = rolEmpleado;
    
    }

    public Empleado()
    {;}

}
