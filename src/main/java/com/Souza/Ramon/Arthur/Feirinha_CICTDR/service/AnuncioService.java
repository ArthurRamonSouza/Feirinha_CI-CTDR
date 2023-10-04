package com.Souza.Ramon.Arthur.Feirinha_CICTDR.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.repository.AnuncioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AnuncioService {
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	public Optional<Anuncio> getAnuncio(Long anuncio_id) {
		return anuncioRepository.findById(anuncio_id);
	}

	public Anuncio save(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}
	
	public void deleteById(Long anuncioId) {
		anuncioRepository.deleteById(anuncioId);
	}

}
