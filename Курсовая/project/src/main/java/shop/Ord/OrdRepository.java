package shop.Ord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdRepository extends JpaRepository<Ord, Integer> {
    @Modifying
    @Query(value = "UPDATE Ord set active = 0 where idOrd = :id")
    int delete(@Param("id") int id);
    @Query(value = "SELECT * FROM Ord where active = 1 order by id_ord asc", nativeQuery = true)
    List<Ord> findAll();
}
