package com.HQLExer.HQLResolution.Repository;

import com.HQLExer.HQLResolution.Entities.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface VeterinariaRepository extends JpaRepository<Veterinaria, Integer> {

}
