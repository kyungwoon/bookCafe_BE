package com.miniproject2.bookcafe.repository;

import com.miniproject2.bookcafe.domain.Moim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoimRepository extends JpaRepository<Moim, Long> {
    List<Moim> findAllByOrderByCreatedAtDesc();
}
