package shop.Ord;

import java.util.List;

public interface OrdService {
    List getAll();
    public Ord findById(int id);
    public void save(Ord sellers);
    public int delete(int id);
}
