package shop.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
}
