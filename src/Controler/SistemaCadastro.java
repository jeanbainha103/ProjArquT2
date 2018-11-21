package Controler;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Usuario;

public class SistemaCadastro {
	private static Cadastro cadastro;
	
	public static ArrayList<Usuario> iniciaCadastro(String login, String senha, ArrayList<Usuario> listUser) {
		cadastro = new Cadastro(login, senha, listUser);
		cadastro.cadastrarUser();
		return cadastro.cadastrarUser();
	}
}
