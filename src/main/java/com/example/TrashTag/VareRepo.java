package com.example.TrashTag;

import com.example.TrashTag.Model.Vare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VareRepo extends JpaRepository<Vare, String> {

}
