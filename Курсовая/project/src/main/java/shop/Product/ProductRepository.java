package shop.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "UPDATE Product set active = 0 where idProduct = :id")
    int delete(@Param("id") int id);
    @Query(value = "SELECT * FROM Product where active = 1 order by id_product asc", nativeQuery = true)
    List<Product> findAll();
}