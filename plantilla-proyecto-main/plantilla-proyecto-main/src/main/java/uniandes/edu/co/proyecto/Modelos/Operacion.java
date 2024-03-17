package uniandes.edu.co.proyecto.Modelos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Operacion")
public class Operacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Date hora;
    private String tipoOperacion;
    
    public Operacion(Integer id, Date hora, String tipoOperacion){
        this.id = id;
        this.hora = hora;
        this.tipoOperacion = tipoOperacion;
    }

    public Operacion()
    {;}

    public Integer getId() {
        return id;
    }

    public Date getHora() {
        return hora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

}
