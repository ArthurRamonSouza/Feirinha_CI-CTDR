package com.Souza.Ramon.Arthur.Feirinha_CICTDR.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_anuncios")
public class Anuncio implements Serializable {

	private static final long serialVersionUID = -2504626930903609858L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long anuncioId;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataAnuncio;
	public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@NotBlank
	@Enumerated(EnumType.STRING)
	private CategoriaAnuncio categoria;
	@ManyToOne(optional = true)
	@JoinColumn(name = "usuario_matricula", referencedColumnName = "matricula")
	private Usuario anunciante;

	public Anuncio(Double preco, int quantidade, String titulo, String descricao, String urlImagem, String localizacao,
			String stringDataAnuncio, String categoria, Usuario anunciante) {
		super();
		this.preco = preco;
		this.quantidade = quantidade;
		this.titulo = titulo;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
		this.localizacao = localizacao;
		this.dataAnuncio = LocalDate.parse(stringDataAnuncio, DATE_FORMATTER);
		this.categoria = CategoriaAnuncio.valueOf(categoria);
		this.anunciante = anunciante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static DateTimeFormatter getDateFormatter() {
		return DATE_FORMATTER;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public void setDataAnuncio(String stringDataAnuncio) {
		this.dataAnuncio = LocalDate.parse(stringDataAnuncio, DATE_FORMATTER);
	}

	public void setCategoria(String categoria) {
		this.categoria = CategoriaAnuncio.valueOf(categoria);
	}

	public void setCategoria(CategoriaAnuncio categoria) {
		this.categoria = categoria;
	}

	
	public void setAnunciante(Usuario anunciante) {
		this.anunciante = anunciante;
	}
}
