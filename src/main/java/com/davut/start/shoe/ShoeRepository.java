package com.davut.start.shoe;


 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


 import java.util.Optional;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe,Long> {
    @Query("SELECT s FROM Shoe s WHERE s.model=?1")
    Optional<Shoe>findShoeByModel(String model);
    //Optional<Shoe> findById(Long shouID);
    //public List<Shoe> findByShoeId(String shoeID);
}
