package edu.eafit.katio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String Lastname;
    private String Email;
    private String Phone;
    private String Identification;
    private String Passhash; // Password. PassHash
    //Luchomon@pokemon.com || blake3(MeGustaPOkemon);
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getPasshash() {
        return Passhash;
    }
    public void setPasshash(String passhash) {
        Passhash = passhash;
    }
    public String getIdentification() {
        return Identification;
    }
    public void setIdentification(String identification) {
        Identification = identification;
    }
    
    
    
}