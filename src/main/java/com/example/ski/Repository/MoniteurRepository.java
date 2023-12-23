package com.example.ski.Repository;

import com.example.ski.Entity.Moniteur;
import com.example.ski.Entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur ,Long> {
    @Query("SELECT DISTINCT i.numSemaine " +
            "FROM Moniteur m " +
            "JOIN m.cours c " +
            "JOIN c.inscriptions i " +
            "WHERE m.numMoniteur = :numMoniteur " +
            "AND c.support = :support")
    List<Integer> numWeeksCourseOfInstructorBySupport(
            @Param("numMoniteur") Long numMoniteur,
            @Param("support") Support support
    );

}
