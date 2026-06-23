package com.agrirakshak.backend.scheme.repository;

import com.agrirakshak.backend.scheme.entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {

    List<Scheme> findByStateIgnoreCase(String state);

}