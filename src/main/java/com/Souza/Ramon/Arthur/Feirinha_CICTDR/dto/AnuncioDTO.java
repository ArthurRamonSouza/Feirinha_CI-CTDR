package com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Anuncio;
import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.CategoriaAnuncio;

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

	public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotBlank
	private Double preco;
	@NotBlank
	private int quantidade;
	@NotBlank
	private String titulo;
	private String descricao;
	private String urlImagem;
	private String localizacao;
	@NotBlank
	private String dataAnuncio;
	@NotBlank
	private String categoria;
	@NotBlank
	private String matriculaAnunciante;

	public Anuncio toAnuncio() {
		Anuncio anuncio = new Anuncio();
		anuncio.setPreco(this.preco);
		anuncio.setQuantidade(this.quantidade);
		anuncio.setTitulo(this.titulo);
		anuncio.setDescricao(this.descricao);
		anuncio.setUrlImagem(this.urlImagem);
		anuncio.setLocalizacao(this.localizacao);
		anuncio.setDataAnuncio(stringToLocalDate(this.dataAnuncio));
		anuncio.setCategoria(stringToCategoria(this.categoria));
		anuncio.setMatriculaAnunciante(this.matriculaAnunciante);
		return anuncio;
	}
	
	public LocalDate stringToLocalDate(String stringDataAnuncio) {
		return LocalDate.parse(stringDataAnuncio, DATE_FORMATTER);
	}
	
	public CategoriaAnuncio stringToCategoria(String categoria) {
		return CategoriaAnuncio.valueOf(categoria);
	}
}