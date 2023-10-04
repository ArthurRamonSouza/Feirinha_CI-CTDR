package com.Souza.Ramon.Arthur.Feirinha_CICTDR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}
