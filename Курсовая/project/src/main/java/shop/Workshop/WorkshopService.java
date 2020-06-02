package shop.Workshop;


import java.util.List;

public interface WorkshopService {
    List getAll();
    Workshop findById(int id);
    void save(Workshop workshop);
    int delete(int id);
}