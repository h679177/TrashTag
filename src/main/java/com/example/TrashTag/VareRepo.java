package com.example.TrashTag;

import com.example.TrashTag.Model.Vare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VareRepo extends JpaRepository<Vare, String> {

    @Query("SELECT v FROM Vare v WHERE v.eanNummer = :eanNummer")
    Vare findByEanNummer(@Param("eanNummer") String eanNummer);
}