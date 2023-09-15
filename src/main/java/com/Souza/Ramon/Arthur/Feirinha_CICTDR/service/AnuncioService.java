package com.Souza.Ramon.Arthur.Feirinha_CICTDR.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.repository.AnuncioRepository;

@Service
public class AnuncioService {
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	public Optional<Anuncio> getAnuncio(Long anuncio_id) {
		return anuncioRepository.findById(anuncio_id);
	}
	
	@Query()
	public List<Anuncio> getAnuncios(String anunciante_matricula) {
		return anuncioRepository.findByAnuncianteMatricula(anunciante_matricula);
	}

	public Anuncio save(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}
	
	public void delete(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}

}
