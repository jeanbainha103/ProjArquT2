package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import Controler.DepoimentoOperations;
import Controler.ImagesOperations;
import Model.Depoimento;
import Model.Image;
import Model.Usuario;

public class Gerente {
	private static ArrayList<Image> allImages = new ArrayList<>();;
	private static ArrayList<Depoimento> allDepoimentos = new ArrayList<>();;
	private Usuario user;
	private boolean logado = false;
	public void Iniciar(String login, String senha, ArrayList<Usuario> listUser) throws IOException {
		for (Usuario usuario : listUser) {
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha))
				logado = true;
				user = usuario;
		}
		while(logado) {
			DatagramSocket serverSocket = new DatagramSocket(8027);
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String( receivePacket.getData());
			System.out.println("RECEIVED: " + sentence);
			String [] struct = sentence.split("-");
			System.out.println("server-8000");
			
			switch(Integer.parseInt(struct[0])) {
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
			case 6: cadastrarDepoimento(user, struct[1], struct[2]);
			break;
			case 7: cadastrarImagem(user, struct[1], struct[2]);
			break;
			default:
			break;
			}
			serverSocket.close();
		}
	}
	
	public void verTodasImagens() {
		for (Image image : allImages) {
			System.out.println(image.getTitle());
			System.out.println(image.getContent());
		}
	}
	
	public void verTodosDepoimentos() {
		for (Depoimento depoimento : allDepoimentos) {
			System.out.println(depoimento.getTitle());
			System.out.println(depoimento.getContent());
		}
	}
	
	public void verSeusDepoimentos(Usuario user) {
		DepoimentoOperations d = new DepoimentoOperations();
		d.showPost(user);
	}
	
	public void verSuasImages(Usuario user) {
		ImagesOperations i = new ImagesOperations();
		i.showPost(user);
	}
	
	public void cadastrarDepoimento(Usuario user, String content, String titulo) {
		Depoimento depoimento = new Depoimento(user);
		DepoimentoOperations d = new DepoimentoOperations();
		depoimento = d.cadastro(depoimento, user, content, titulo);
		allDepoimentos.add(depoimento);
	}
	
	public void cadastrarImagem(Usuario user, String content, String titulo) {
		Image image = new Image(user);
		ImagesOperations i = new ImagesOperations();
		i.cadastro(image, user, content, titulo);
		allImages.add(image);
	}
}
