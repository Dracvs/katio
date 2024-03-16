package edu.eafit.katio.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nombre;
    private Integer AutorId;
    private String ISBN;
    private Date FechaPublicacion;
    private String Edicion;
    
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public Integer getAutorId() {
        return AutorId;
    }
    public void setAutorId(Integer autorId) {
        AutorId = autorId;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public Date getFechaPublicacion() {
        return FechaPublicacion;
    }
    public void setFechaPublicacion(Date fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }
    public String getEdicion() {
        return Edicion;
    }
    public void setEdicion(String edicion) {
        Edicion = edicion;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

}
