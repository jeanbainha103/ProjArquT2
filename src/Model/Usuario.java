package Model;

import java.util.ArrayList;

public class Usuario {
	private String login;
	private String senha;
	public ArrayList<Image> listaImages;
	public ArrayList<Depoimento> listaDepoimentos;
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		listaDepoimentos = new ArrayList<Depoimento>();
		listaImages = new ArrayList<Image>();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void AddImage(Image image) {
		listaImages.add(image);
	}
	
	public ArrayList<Image> getListaImages(){
		return listaImages;
	}
	
	public void AddDepoimento(Depoimento depoimento) {
		listaDepoimentos.add(depoimento);
	}
	
	public ArrayList<Depoimento> getListaDepoimentos(){
		return listaDepoimentos;
	}
}
