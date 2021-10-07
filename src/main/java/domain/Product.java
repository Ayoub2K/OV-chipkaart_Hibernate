package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;

@Entity
public class Product {
    @Id
    @Column(name = "product_nummer")
    public int id;

    public String naam;
    public String beschrijving;
    public double prijs;

    @Transient
    public ArrayList<OvChipkaart> OvChipkaarten;
    @Transient
    public ArrayList<Integer> kaart_nummers;

    public Product(String naam, String beschrijving, double prijs) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.OvChipkaarten = new ArrayList<>();
        this.kaart_nummers = new ArrayList<>();
    }

    public Product(int product_nummer, String naam, String beschrijving, double prijs) {
        this(naam, beschrijving, prijs);
        this.id = product_nummer;
    }

    public Product() {

    }

    public void addOvChipkaarten(int kaart_nummer) {
        kaart_nummers.add(kaart_nummer);
    }

    public ArrayList<OvChipkaart> getOvChipkaarten() {
        return OvChipkaarten;
    }

    public int getProduct_nummer() {
        return id;
    }

    public void removeOvChipkaarten(OvChipkaart ovChipkaart) {
        OvChipkaarten.remove(ovChipkaart);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_nummer=" + id +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
