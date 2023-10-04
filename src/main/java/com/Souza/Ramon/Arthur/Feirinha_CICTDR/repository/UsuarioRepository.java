package com.Souza.Ramon.Arthur.Feirinha_CICTDR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	@Query("SELECT a FROM Anuncio a WHERE a.anunciante.matricula = ?1")
	List<Anuncio> findAllAnunciosByMatricula(String anunciante_matricula);

	@Modifying
    @Query("DELETE FROM Anuncio a WHERE a.anunciante.matricula = ?1")
    void deleteAnunciosByMatricula(String matricula);

}
