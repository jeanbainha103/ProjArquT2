package View;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.Depoimento;
import Model.Image;
import Model.Usuario;

public class Gerente {
	private ArrayList<Image> allImages;
	private ArrayList<Depoimento> allDepoimentos;
	private Usuario user;
	private boolean logado = false;
	public void Iniciar(String login, String senha, ArrayList<Usuario> listUser) {
		for (Usuario usuario : listUser) {
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha))
				logado = true;
				user = usuario;
		}
		while(logado) {
			//CRIAR UM MEIO DE RECEBER UMA MENSAGEM
			
			switch(2) {
			case 1: logado = false;
			break;
			case 2: verTodasImagens();
			break;
			case 3: verTodosDepoimentos();
			break;
			case 4: verSeusDepoimentos(user);
			break;
			case 5: verSuasImages(user);
			break;
			case 6: cadastrarDepoimento(user);
			break;
			case 7: cadastrarImagem(user);
			break;
			default:
			break;
			}
		}
	}
	
	public void verTodasImagens() {
		for (Image image : allImages) {
			
		}
	}
	
	public void verTodosDepoimentos() {
		for (Depoimento depoimento : allDepoimentos) {
			
		}
	}
	
	public void verSeusDepoimentos(Usuario user) {
		System.out.println(user.getListaDepoimentos().get(0));
	}
	
	public void verSuasImages(Usuario user) {
		System.out.println(user.getListaImages().get(0));
	}
	
	public void cadastrarDepoimento(Usuario user) {
		Depoimento depoimento = new Depoimento(user, "teste01", "titulo test");
		user.AddDepoimento(depoimento);;
	}
	
	public void cadastrarImagem(Usuario user) {
		
	}
}
