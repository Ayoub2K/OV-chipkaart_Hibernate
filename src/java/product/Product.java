package product;

import ovchipkaart.OvChipkaart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @Column(name = "product_nummer")
    public int id;

    public String naam;
    public String beschrijving;
    public double prijs;

    @ManyToMany(mappedBy = "producten")
    public List<OvChipkaart> OvChipkaarten;
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

    public List<OvChipkaart> getOvChipkaarten() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setOvChipkaarten(List<OvChipkaart> ovChipkaarten) {
        OvChipkaarten = ovChipkaarten;
    }

    public ArrayList<Integer> getKaart_nummers() {
        return kaart_nummers;
    }

    public void setKaart_nummers(ArrayList<Integer> kaart_nummers) {
        this.kaart_nummers = kaart_nummers;
    }
}
