package ec.foxkey.crud.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Person {

    @Id
    @Column(updatable = false, nullable = false)
    private String id;
    @Column(nullable = false, length = 50)
    private String nombres;
    @Column(nullable = false, length = 50)
    private String apellidos;
    @Column(nullable = false)
    private int edad;
    @Column(nullable = false, length = 50)
    private String pais;
    @Column(nullable = false, length = 50)
    private String departamento;
    @Column(nullable = false, length = 50)
    private String municipio;
    @Column(nullable = false, length = 100)
    private String direccion;
    @Column(nullable = false, length = 100)
    private String email;
    @Column
    private Timestamp modified_in;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getModified_in() {
        return modified_in;
    }

    public void setModified_in(Timestamp modified_in) {
        this.modified_in = modified_in;
    }

}
