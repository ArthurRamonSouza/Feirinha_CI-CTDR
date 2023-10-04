package com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioDTO {
	private String matricula;
	private String apelido;
	private String senha;
	private String telefone;
	private String descricao;
	
	public UsuarioDTO(String matricula) {
		this.matricula = matricula;
	}	

	public Usuario toUsuario() {
		Usuario usuario = new Usuario(this.apelido, this.senha, this.telefone, this.descricao);
		return usuario;
	}
}
