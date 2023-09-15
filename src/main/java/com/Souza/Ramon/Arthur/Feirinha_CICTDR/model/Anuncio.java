package com.Souza.Ramon.Arthur.Feirinha_CICTDR.model;

import java.time.LocalDate;

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
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_anuncios")
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preco;
	private String titulo;
	private String descricao;
	private String urlImagem;
	private String localizacao;
	private LocalDate dataAnuncio;
	@Enumerated(EnumType.STRING)
	private CategoriaAnuncio categoria;
	
	@ManyToOne
	@JoinColumn(name="usuario_matricula")
	private Usuario anunciante;
	
	public Anuncio(Double preco, String titulo, String descricao, String urlImagem, CategoriaAnuncio categoria,
			String localizacao, Usuario anunciante) {
		super();
		this.preco = preco;
		this.titulo = titulo;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
		this.categoria = categoria;
		this.localizacao = localizacao;
		this.anunciante = anunciante;
	}
}
