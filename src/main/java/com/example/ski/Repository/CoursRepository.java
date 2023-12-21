package com.example.ski.Repository;

import com.example.ski.Entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long> {
    @Modifying
    @Query("delete from  Cours c where c.numCours=:numCours")
    Cours deleteCours(@Param("num") Long numCours);

    void deleteByNumCours(Long numCours);


}

