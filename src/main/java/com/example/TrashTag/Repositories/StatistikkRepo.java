package com.example.TrashTag.Repositories;

import com.example.TrashTag.Model.Brukerstatistikk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatistikkRepo extends JpaRepository<Brukerstatistikk, Integer> {

}
