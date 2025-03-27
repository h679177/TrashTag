package com.example.TrashTag;

import com.example.TrashTag.Model.Returpunkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturpunktRepo extends JpaRepository<Returpunkt, Integer> {

    @Query(value = "SELECT * " +
            "FROM vareinformasjon.returpunkt " +
            "ORDER BY koordinater <-> point(:latitude, :longitude) " +
            "LIMIT 10", nativeQuery = true)
    List<Returpunkt> finnNermestePunkt(double latitude, double longitude);

}
