package com.Backend1Ex.ResolucionC32.Repository;

import com.Backend1Ex.ResolucionC32.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}

