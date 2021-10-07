package domain;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToOne(mappedBy = "reiziger")
    public Adres adres;

    public Reiziger(){

    }

    public Reiziger(String voorletters, String tussenvoegsel, String achternaam, java.sql.Date geboortedatum, Adres adres) {
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
    }

    public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, java.sql.Date geboortedatum, Adres adres) {
        this(voorletters, tussenvoegsel, achternaam, geboortedatum, adres);
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
                ", adres=" + adres +
                '}';
    }
}
