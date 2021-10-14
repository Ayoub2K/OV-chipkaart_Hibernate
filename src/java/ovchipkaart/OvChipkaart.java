package ovchipkaart;


import org.hibernate.annotations.Cascade;
import product.Product;
import reiziger.Reiziger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ov_chipkaart")
public class OvChipkaart {
    @Id
    @Column(name = "kaart_nummer")
    public int id;

    public Date geldig_tot;
    public int klasse;
    public int saldo;

    @OneToOne
    @JoinColumn(name = "reiziger_id", foreignKey = @ForeignKey(name = "kaart_nummer"))
    public Reiziger reiziger;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ov_chipkaart_product",
                joinColumns = @JoinColumn(name = "kaart_nummer"),
                inverseJoinColumns = @JoinColumn(name = "product_nummer"))
    public List<Product> producten;

    public OvChipkaart(){}

    public OvChipkaart(int kaart_nummer, Date geldig_tot, int klasse, int saldo, Reiziger reiziger) {
        this.id = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
        this.producten = new ArrayList<>();
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void removeProduct(Product product) {
        producten.remove(product);
    }

    public int getKaart_nummer() {
        return id;
    }

    @Override
    public String toString() {
        return "OvChipkaart{" +
                "id=" + id +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reiziger=" + reiziger +
                ", producten=" + producten +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    public void addProduct(Product p){
        producten.add(p);
    }
}
