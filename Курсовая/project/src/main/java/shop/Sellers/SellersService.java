package shop.Sellers;

import java.util.List;

public interface SellersService {
    List getAll();
    public Sellers findById(int id);
    public void save(Sellers sellers);
    public int delete(int id);
}
