package com.C22Resolution.HibernateExer.Services;

import com.C22Resolution.HibernateExer.Entities.Equipo;
import java.util.*;

public interface IEquipoService {
    Equipo guardarEquipo(Equipo equipo);
    List<Equipo> obtenerEquipos();
    Boolean eliminarEquipo(Long id);
}
