package com.C22Resolution.HibernateExer.Repository;

import com.C22Resolution.HibernateExer.Entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJugadorRepository extends JpaRepository<Jugador,Long> {
}
