package ovchipkaart;


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

    @ManyToMany
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = @JoinColumn(name = "product_nummer"),
            inverseJoinColumns = @JoinColumn(name = "kaart_nummer"))
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
        return "OVChipkaart{" +
                "kaart_nummer=" + id +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reiziger=" + reiziger +
                '}';
    }
}
