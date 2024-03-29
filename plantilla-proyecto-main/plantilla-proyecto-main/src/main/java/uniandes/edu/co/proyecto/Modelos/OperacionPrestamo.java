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
@Table(name="OperacionPrestamo")
@PrimaryKeyJoinColumn(name = "id")

public class OperacionPrestamo extends Operacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

     @Column(name = "NUMPRESTAMO")
    private int numPrestamo;
    
    @Column(name = "MONTOPAGO")
    private int montoPago;

    public OperacionPrestamo(Integer id, Date hora, String tipoOperacion, Integer id_op ,Integer numPrestamo, Integer montoPago) {
        super(id, hora, tipoOperacion);
        this.id = id_op;
        this.numPrestamo = numPrestamo;
        this.montoPago = montoPago;
    }

    public OperacionPrestamo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumPrestamo() {
        return numPrestamo;
    }

    public void setNumPrestamo(Integer numPrestamo) {
        this.numPrestamo = numPrestamo;
    }

    public Integer getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Integer montoPago) {
        this.montoPago = montoPago;
    }
    
}
