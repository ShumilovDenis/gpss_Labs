package shop.Sellers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SellersServiceImpl implements SellersService{
    private SellersRepository repository;

    @Autowired
    public SellersServiceImpl(SellersRepository repository){
        this.repository = repository;
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public void save(Sellers sellers) {
        repository.save(sellers);
    }

    @Override
    public Sellers findById(int id) {
        return repository.findById(id).get();
    }

}
