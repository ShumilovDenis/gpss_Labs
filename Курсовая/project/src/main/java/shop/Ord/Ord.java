package shop.Ord;

import org.springframework.format.annotation.DateTimeFormat;
import shop.Product.Product;
import shop.Sellers.Sellers;
import shop.Workshop.Workshop;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ord")
public class Ord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrd;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_workshop")
    private Workshop workshop;
    @ManyToOne
    @JoinColumn(name = "id_sellers")
    private Sellers sellers;

    private int active;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Ord(){
        this.active = 1;
    }

    public int getActive() {
        return active;
    }

    public Date getDate() {
        return date;
    }

    public Product getProduct() {return product;}

    public Workshop getWorkshop() {return workshop;}

    public Sellers getSellers() {return sellers;}

    public int getIdOrd() {return idOrd;}
//    @Override
//    public String toString(){
//        return String.format("%s" ,product + "||" + workshop);
//    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public void setSellers(Sellers sellers) {
        this.sellers = sellers;
    }

    public void setIdOrd(int idOrd) {
        this.idOrd = idOrd;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
