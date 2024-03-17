package uniandes.edu.co.proyecto.Modelos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="OperacionesCuenta")
@PrimaryKeyJoinColumn(name = "id")
public class OperacionCuenta extends Operacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
     @Column(name = "numeroOrigen")
    private int numeroOrigen;
    
    @Column(name = "numeroDestino")
    private int numeroDestino;
    
    @Column(name = "monto")
    private int monto;
    
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
