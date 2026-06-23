package com.agrirakshak.backend.scheme.service;

import com.agrirakshak.backend.scheme.entity.Scheme;

import java.util.List;

public interface SchemeService {

    Scheme addScheme(Scheme scheme);

    List<Scheme> getAllSchemes();

    List<Scheme> getByState(String state);
}