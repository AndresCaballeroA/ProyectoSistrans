package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cuenta")
public class Cuenta {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "saldo")
    private int saldo;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "estado")
    private String estado;

    public Cuenta(Integer id, Integer saldo, String tipo, String estado) {
        this.id = id;
        this.saldo = saldo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Cuenta()
    {;}

    public Integer getId() {
        return id;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
