package com.Souza.Ramon.Arthur.Feirinha_CICTDR.model;

import java.io.Serializable;
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
public class Usuario implements Serializable {

	private static final long serialVersionUID = 6706916942992561477L;
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
	@OneToMany(mappedBy = "anunciante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Anuncio> anuncios;

	public Usuario(String apelido, String senha, String telefone, String descricao) {
		super();
		this.apelido = apelido;
		this.senha = senha;
		this.telefone = telefone;
		this.descricao = descricao;
	}

	public Usuario(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
	    return "Usuario{" +
	            "matricula='" + matricula + '\'' +
	            ", nome='" + nome + '\'' +
	            ", apelido='" + apelido + '\'' +
	            ", senha='" + senha + '\'' +
	            ", email='" + email + '\'' +
	            ", curso='" + curso + '\'' +
	            ", estrelas=" + estrelas +
	            ", telefone='" + telefone + '\'' +
	            ", descricao='" + descricao + '\'' +
	            '}';
	}
}
