package reiziger;

import adres.Adres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    public int id;

    public String voorletters;
    public String tussenvoegsel;
    public String achternaam;
    public Date geboortedatum;

    @OneToOne
    @JoinColumn(name = "reiziger_id")
    public Adres adres;

    public Reiziger(){

    }

    public Reiziger(String voorletters, String tussenvoegsel, String achternaam, java.sql.Date geboortedatum) {
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, java.sql.Date geboortedatum) {
        this(voorletters, tussenvoegsel, achternaam, geboortedatum);
        this.id = reiziger_id;
    }

    public int getReiziger_id() {
        return id;
    }

    @Override
    public String toString() {
        return "Reiziger{" +
                "id=" + id +
                ", voorletters='" + voorletters + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
