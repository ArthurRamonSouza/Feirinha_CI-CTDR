package com.Souza.Ramon.Arthur.Feirinha_CICTDR.model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

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
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	private String matricula;
	private String nome;
	@NotNull
	private String apelido;
	@NotNull
	private String senha;
	private String email;
	private String curso;
	private Integer estrelas;
	@NotNull
	private String telefone;
	private String descricao;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anunciante", fetch = FetchType.LAZY)
	private ArrayList<Anuncio> anuncios;
	
	public Usuario(String apelido, String senha, String telefone, String descricao) {
		super();
		this.apelido = apelido;
		this.senha = senha;
		this.telefone = telefone;
		this.descricao = descricao;
	}	
}
