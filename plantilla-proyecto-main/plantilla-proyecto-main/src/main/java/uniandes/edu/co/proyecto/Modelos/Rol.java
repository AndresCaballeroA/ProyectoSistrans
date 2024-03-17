package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rol")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String tipo;

    public Rol(Integer id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public Rol()
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
