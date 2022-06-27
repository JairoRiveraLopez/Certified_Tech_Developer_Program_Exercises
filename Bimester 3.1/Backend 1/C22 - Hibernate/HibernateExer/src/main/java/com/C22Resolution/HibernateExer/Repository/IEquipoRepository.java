package com.C22Resolution.HibernateExer.Repository;

import com.C22Resolution.HibernateExer.Entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipoRepository extends JpaRepository<Equipo,Long> {
}
