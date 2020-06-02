package shop.Post;


import java.util.List;

public interface PostService {
    List getAll();
    Post findById(int id);
    void save(Post product);
    int delete(int id);
}