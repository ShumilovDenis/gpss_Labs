package shop.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Query(value = "UPDATE Post set active = 0 where idPost = :id")
    int delete(@Param("id") int id);
    @Query(value = "SELECT * FROM Post where active = 1 order by id_post asc", nativeQuery = true)
    List<Post> findAll();
}