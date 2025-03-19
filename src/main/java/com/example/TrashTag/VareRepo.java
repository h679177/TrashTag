package com.example.TrashTag;

import com.example.TrashTag.Model.Vare;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class})
public interface VareRepo extends JpaRepository<Vare, String> {

}
