package shop.Sellers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SellersRepository extends JpaRepository<Sellers, Integer> {
    @Modifying
    @Query(value = "UPDATE Sellers set active = 0 where idSellers = :id")
    int delete(@Param("id") int id);
    @Query(value = "SELECT * FROM Sellers where active = 1 order by id_sellers asc", nativeQuery = true)
    List<Sellers> findAll();
}
