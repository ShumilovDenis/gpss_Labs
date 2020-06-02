package shop.Workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopService {
    private final WorkshopRepository repository;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository repository) {
        this.repository = repository;
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public Workshop findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Workshop workshop) {
        repository.save(workshop);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
}
