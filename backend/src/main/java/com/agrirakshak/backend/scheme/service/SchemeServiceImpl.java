package com.agrirakshak.backend.scheme.service;

import com.agrirakshak.backend.scheme.entity.Scheme;
import com.agrirakshak.backend.scheme.repository.SchemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchemeServiceImpl implements SchemeService {

    private final SchemeRepository repository;

    @Override
    public Scheme addScheme(Scheme scheme) {
        return repository.save(scheme);
    }

    @Override
    public List<Scheme> getAllSchemes() {
        return repository.findAll();
    }

    @Override
    public List<Scheme> getByState(String state) {
        return repository.findByStateIgnoreCase(state);
    }
}