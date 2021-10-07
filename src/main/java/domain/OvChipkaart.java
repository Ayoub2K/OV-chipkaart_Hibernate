package domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class OvChipkaart {
    @Id
    @Column(name = "kaart_nummer")
    public int id;

    public int reiziger_id;
    public Date geldig_tot;
    public int klasse;
    public int saldo;
    @Transient
    public Reiziger reiziger;
    @Transient
    public ArrayList<Product> producten;

    public OvChipkaart(){}

    public OvChipkaart(int kaart_nummer, Date geldig_tot, int klasse, int saldo, Reiziger reiziger) {
        this.id = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
        this.producten = new ArrayList<>();
    }

    public OvChipkaart(int kaart_nummer, Date geldig_tot, int klasse, int saldo, int reiziger_id) {
        this.id = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger_id = reiziger_id;
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }

    public void addProduct(Product product) {
        producten.add(product);
    }

    public void removeProduct(Product product) {
        producten.remove(product);
    }

    public int getKaart_nummer() {
        return id;
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaart_nummer=" + id +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reiziger=" + reiziger +
                '}';
    }
}
