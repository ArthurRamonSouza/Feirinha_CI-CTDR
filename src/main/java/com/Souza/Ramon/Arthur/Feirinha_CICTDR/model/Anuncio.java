package com.Souza.Ramon.Arthur.Feirinha_CICTDR.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

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
@Table(name = "tb_anuncios")
public class Anuncio {
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
	private LocalDate dataAnuncio;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private CategoriaAnuncio categoria;
	@ManyToOne(optional = true)
	@JoinColumn(name = "matricula_nunciante", referencedColumnName = "matricula")
	private String matriculaAnunciante;
}
