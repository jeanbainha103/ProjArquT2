package Controler;

import java.util.ArrayList;

import Model.Usuario;

public class Cadastro {
	private String login;
	private String senha;
	public ArrayList<Usuario> listUser;
	
	public Cadastro(String login, String senha, ArrayList<Usuario> listUser) {
		super();
		this.login = login;
		this.senha = senha;
		this.listUser = listUser;
	}

	public ArrayList<Usuario> cadastrarUser() {
		for (Usuario usuario : listUser) {
			if(usuario.getLogin().equals(login) || usuario.getSenha().equals(senha))
				return listUser;
		}
		Usuario user = new Usuario(login, senha);
		listUser.add(user);
		return listUser;
	}
}
