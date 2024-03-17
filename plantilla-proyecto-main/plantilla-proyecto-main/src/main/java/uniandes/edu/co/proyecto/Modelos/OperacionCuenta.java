package uniandes.edu.co.proyecto.Modelos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="OperacionesCuenta")
public class OperacionCuenta extends Operacion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Integer numeroOrigen;
    private Integer numeroDestino;
    private Integer monto;
    
    public OperacionCuenta(Integer id, Date hora, String tipoOperacion, Integer id_op ,Integer numeroOrigen, Integer numeroDestino, Integer monto) {
        super(id, hora, tipoOperacion);
        this.id = id_op;
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.monto = monto;
    }

    public OperacionCuenta()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(Integer numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public Integer getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(Integer numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

}
