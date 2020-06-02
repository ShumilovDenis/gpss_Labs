package shop.Workshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Integer> {
    @Modifying
    @Query(value = "UPDATE Workshop set active = 0 where idWorkshop = :id")
    int delete(@Param("id") int id);
    @Query(value = "SELECT * FROM Workshop where active = 1 order by id_workshop asc", nativeQuery = true)
    List<Workshop> findAll();
}