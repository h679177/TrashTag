package com.example.TrashTag;

import com.example.TrashTag.Model.Returpunkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturpunktRepo extends JpaRepository<Returpunkt, Integer> {

}
