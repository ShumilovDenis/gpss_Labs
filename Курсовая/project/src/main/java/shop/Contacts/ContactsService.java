package shop.Contacts;


import java.util.List;

public interface ContactsService {
    List getAll();
    Contacts findById(int id);
    void save(Contacts product);
    int delete(int id);
}