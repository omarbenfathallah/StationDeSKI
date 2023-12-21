package com.example.ski.Repository;

import com.example.ski.Entity.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PisteRepository extends JpaRepository<Piste,Long> {
    @Modifying
    @Query("select p from Piste p where p.numPiste=:num")
    Piste retrievePiste (@Param("num") Long numPiste);
}
