package shop.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Post product) {
        repository.save(product);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
}
