package domain;

import javax.persistence.*;

@Entity
public class Adres {
    @Id
    @Column(name = "adres_id")
    public int id;

    public String postcode;
    public String huisnummer;
    public String straat;
    public String woonplaats;

    @OneToOne(mappedBy = "adres")
    @JoinColumn(name = "reiziger_id", foreignKey = @ForeignKey(name = "adres_id"))
    public Reiziger reiziger;

    public Adres() {
    }

    public Adres(String postcode, String huisnummer, String straat, String woonplaats, Reiziger reiziger) {
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;
        this.reiziger = reiziger;
    }

    public Adres(int adres_id, String postcode, String huisnummer, String straat, String woonplaats, Reiziger reiziger) {
        this(postcode, huisnummer, straat, woonplaats, reiziger);
        this.id = adres_id;
    }

    public int getAdres_id() {
        return id;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "adres_id=" + id +
                ", postcode='" + postcode + '\'' +
                ", huisnummer='" + huisnummer + '\'' +
                ", straat='" + straat + '\'' +
                ", woonplaats='" + woonplaats + '\'' +
                ", reiziger=" + reiziger +
                '}';
    }
}
