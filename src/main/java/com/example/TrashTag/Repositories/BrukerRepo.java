package com.example.TrashTag.Repositories;

import com.example.TrashTag.Model.Bruker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrukerRepo extends JpaRepository<Bruker, String> {

}
