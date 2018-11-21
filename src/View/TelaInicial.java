package View;

import java.util.ArrayList;

import Controler.SistemaCadastro;
import Model.Usuario;

public class TelaInicial {
	public static void main(String[] args) {
		ArrayList<Usuario> listUser = new ArrayList<>();
		listUser = cadastrar("login1", "senha1", listUser);
		System.out.println(listUser);
		Gerente start = new Gerente();
		start.Iniciar("login", "senha", listUser);		
	}
	
	public static ArrayList<Usuario> cadastrar(String login, String senha, ArrayList<Usuario> listUser) {
		return SistemaCadastro.iniciaCadastro(login, senha, listUser);
	}

}
