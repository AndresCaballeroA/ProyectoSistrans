package uniandes.edu.co.proyecto.Modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ClienteEmpleado")
@IdClass(ClienteEmpleadoId.class)
public class ClienteEmpleado implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    private Empleado empleado;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;
    
    public ClienteEmpleado()
    {;}

}
