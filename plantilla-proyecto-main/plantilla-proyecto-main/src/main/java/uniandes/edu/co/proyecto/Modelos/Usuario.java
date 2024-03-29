package uniandes.edu.co.proyecto.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;

@Entity
@Table(name="USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; 

    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "CONTRASENA")
    private String contrasena;
    
    @Column(name = "TIPODOCUMENTO")
    private String tipoDocumento;
    
    @Column(name = "NUMERODOCUMENTO")
    private String numeroDocumento;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "CIUDAD")
    private String ciudad;
    
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    
    @Column(name = "CODIGOPOSTAL")
    private String codigoPostal;


    public Usuario(String login, String contrasena,  String tipoDocumento, String numeroDocumento, String nombre, String nacionalidad,  String direccion, String email, String telefono, String ciudad, String departamento, String codigoPostal)
    {
        this.login = login;
        this.contrasena = contrasena;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
    }

    public Usuario()
    {;}

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

}
