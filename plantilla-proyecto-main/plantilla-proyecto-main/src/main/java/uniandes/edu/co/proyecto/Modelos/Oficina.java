package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Oficina")
public class Oficina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
     @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "NUMPUNTOSPOSIBLES")
    private String numPuntosPosibles;


    public Oficina(Integer id, String nombre, String direccion, String numPuntosPosibles) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numPuntosPosibles = numPuntosPosibles;
    }

    public Oficina()
    {;}

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumPuntosPosibles() {
        return numPuntosPosibles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumPuntosPosibles(String numPuntosPosibles) {
        this.numPuntosPosibles = numPuntosPosibles;
    }

}
