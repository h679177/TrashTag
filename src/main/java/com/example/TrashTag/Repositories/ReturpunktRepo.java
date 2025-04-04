package com.example.TrashTag.Repositories;

import com.example.TrashTag.Model.Avfallstype;
import com.example.TrashTag.Model.Returpunkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ReturpunktRepo extends JpaRepository<Returpunkt, Integer> {

    @Query(value = "SELECT r.* " +
            "FROM vareinformasjon.returpunkt r " +
            "INNER JOIN vareinformasjon.sorteringssteder s ON r.returid = s.returid " +
            "WHERE s.avfallstype IN :avfallstyper " +
            "ORDER BY koordinater <-> point(:latitude, :longitude) " +
            "LIMIT 10", nativeQuery = true)
    Set<Returpunkt> finnNermestePunkt(double latitude, double longitude, @Param("avfallstyper") List<String> avfallstyper);

    @Query("SELECT a FROM Avfallstype a")
    List<Avfallstype> hentAlleTyper();

    @Query("SELECT r FROM Returpunkt r JOIN r.avfallstype a WHERE a.avfallstype IN :avfallstyper AND r.postnummer = :postnr")
    Set<Returpunkt> sokEtterPostNr(@Param("avfallstyper") List<String> avfallstyper, @Param("postnr") int postnr);


}
