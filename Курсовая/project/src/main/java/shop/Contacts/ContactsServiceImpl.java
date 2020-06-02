package shop.Contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactsServiceImpl implements ContactsService {
    private final ContactsRepository repository;

    @Autowired
    public ContactsServiceImpl(ContactsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public Contacts findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Contacts product) {
        repository.save(product);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
}
