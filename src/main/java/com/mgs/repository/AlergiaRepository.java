package com.mgs.repository;

import com.mgs.model.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlergiaRepository extends JpaRepository<Alergia, Long> {
}
