package shop.Product;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String prodName;
    private int prodCode;
    private int active;

    protected Product() {
    }

    public Product(String prodName, int prodCode) {
        this.prodName = prodName;
        this.prodCode = prodCode;
        this.active = 1;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getProdName() {
        return prodName;
    }

    public int getProdCode() {
        return prodCode;
    }

    public int getActive() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("Наименование товара: " + prodName + "\n" +
                "Код товара: " + prodCode);
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdCode(int prodCode) {
        this.prodCode = prodCode;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}

