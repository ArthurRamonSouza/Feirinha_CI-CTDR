package com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.CategoriaAnuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioDTO {

	@NotBlank
	private Double preco;
	@NotBlank
	@NotNull
	private int quantidade;
	@NotBlank
	@NotNull
	private String titulo;
	private String descricao;
	private String urlImagem;
	private String localizacao;
	@NotBlank
	private String dataAnuncio;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private String categoria;
	private String matriculaAnunciante;
	private Usuario anunciante;

	public Anuncio toAnuncio() {
		this.anunciante = new Usuario(this.matriculaAnunciante);
		Anuncio anuncio = new Anuncio(this.preco, this.quantidade, this.titulo, this.descricao, this.urlImagem, this.localizacao, this.dataAnuncio, this.categoria, this.anunciante);
		return anuncio;
	}

}
