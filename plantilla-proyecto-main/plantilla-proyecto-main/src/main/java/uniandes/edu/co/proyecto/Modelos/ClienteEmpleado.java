package uniandes.edu.co.proyecto.Modelos;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ClienteEmpleado")
@Embeddable
public class ClienteEmpleado extends Usuario implements Serializable{

    @ManyToOne
    @JoinColumn(name="id_empleado", referencedColumnName="id")
    private Empleado id_empleado;

    @ManyToOne
    @JoinColumn(name="id_cliente", referencedColumnName="id")
    private Cliente id_cliente;

    public ClienteEmpleado(String login, String contrasena,  String tipoDocumento, String numeroDocumento, String nombre, String nacionalidad,  String direccion, String email, String telefono, String ciudad, String departamento, String codigoPostal, Empleado id_empleado, Cliente id_cliente){
        super(login, contrasena, tipoDocumento, numeroDocumento, nombre, nacionalidad, direccion, email, telefono, ciudad, departamento, codigoPostal);
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
    }

    public ClienteEmpleado()
    {;}

}
