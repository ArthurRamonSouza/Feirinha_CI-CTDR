package com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	private String apelido;
	private String senha;
	private String telefone;
	private String descricao;

	public Usuario toUsuario() {
		Usuario usuario = new Usuario(this.apelido, this.senha, this.telefone, this.descricao);
		return usuario;
	}
}
