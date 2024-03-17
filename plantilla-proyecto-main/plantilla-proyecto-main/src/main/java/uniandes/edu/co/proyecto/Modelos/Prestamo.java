package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Prestamo")

public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(name = "estado")
    private String estado;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "monto")
    private int monto;
    
    @Column(name = "interes")
    private float interes;
    
    @Column(name = "numCuotas")
    private int numCuotas;
    
    @Column(name = "numMes")
    private int numMes;
    
    @Column(name = "valorCuota")
    private int valorCuota;


    public Prestamo(Integer id, String estado, String tipo, Integer monto, Float interes, Integer numCuotas, Integer numMes, Integer valorCuota) {
        this.id = id;
        this.estado = estado;
        this.tipo = tipo;
        this.monto = monto;
        this.interes = interes;
        this.numCuotas = numCuotas;
        this.numMes = numMes;
        this.valorCuota = valorCuota;
    }

    public Prestamo()
    {;}


    public Integer getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getMonto() {
        return monto;
    }

    public Float getInteres() {
        return interes;
    }

    public Integer getNumCuotas() {
        return numCuotas;
    }

    public Integer getNumMes() {
        return numMes;
    }

    public Integer getValorCuota() {
        return valorCuota;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    public void setNumCuotas(Integer numCuotas) {
        this.numCuotas = numCuotas;
    }

    public void setNumMes(Integer numMes) {
        this.numMes = numMes;
    }

    public void setValorCuota(Integer valorCuota) {
        this.valorCuota = valorCuota;
    }

}
