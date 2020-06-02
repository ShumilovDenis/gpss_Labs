package shop.Product;


import java.util.List;

public interface ProductService {
    List getAll();
    Product findById(int id);
    void save(Product product);
    int delete(int id);
}