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
}
