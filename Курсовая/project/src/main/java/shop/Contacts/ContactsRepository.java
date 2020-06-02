package shop.Contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {
    @Modifying
    @Query(value = "UPDATE Contacts set active = 0 where idContacts = :id")
    int delete(@Param("id") int id);
    @Query(value = "SELECT * FROM Contacts where active = 1 order by id_contacts asc", nativeQuery = true)
    List<Contacts> findAll();
}