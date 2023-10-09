package com.Souza.Ramon.Arthur.Feirinha_CICTDR.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	@Id
	private String matricula;
	@NotBlank
	private String nome;
	@NotBlank
	private String apelido;
	@NotBlank
	private String senha;
	@NotBlank
	private String email;
	@NotBlank
	private String curso;
	private Integer estrelas;
	@NotBlank
	private String telefone;
	private String descricao;
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "anunciante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Anuncio> anuncios;
}
