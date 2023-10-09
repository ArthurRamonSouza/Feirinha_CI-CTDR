package com.Souza.Ramon.Arthur.Feirinha_CICTDR.dto;

import com.Souza.Ramon.Arthur.Feirinha_CICTDR.model.Usuario;

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
public class UsuarioDTO {
	private String apelido;
	private String senha;
	private String telefone;
	private String descricao;
	
	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setApelido(this.apelido);
		usuario.setDescricao(this.descricao);
		usuario.setSenha(this.senha);
		usuario.setTelefone(this.telefone);
		return usuario;
	}
}
