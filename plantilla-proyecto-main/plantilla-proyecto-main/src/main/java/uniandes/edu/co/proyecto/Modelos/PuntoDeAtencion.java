package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="PuntoDeAtencion")
public class PuntoDeAtencion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    
    @Column(name = "tipo")
    private String tipo;

    public PuntoDeAtencion(Integer id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }


    public PuntoDeAtencion()
    {;}

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
