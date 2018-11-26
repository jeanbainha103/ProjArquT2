package View;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Controler.SistemaCadastro;
import Model.Usuario;

public class TelaInicial {
	
	public static void main(String[] args) throws IOException {
		ArrayList<Usuario> listUser = new ArrayList<>();
		while(true){
			try {				
				while(true) {
					DatagramSocket serverSocket = new DatagramSocket(7000);
					byte[] receiveData = new byte[1024];
					DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
					serverSocket.receive(receivePacket);
					String sentence = new String( receivePacket.getData());
					System.out.println("RECEIVED: " + sentence);
					String [] struct = sentence.split("-");
					
					if(struct[0].equals("1")) {
						cadastrar(struct[1], struct[2], listUser);
					} else if(struct[0].equals("2")) {
						new Thread() {							
						    public void run() {
						    	Gerente start = new Gerente();
					    		try {
									start.Iniciar(struct[1], struct[2], listUser);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    }
						}.start();
					}
					
					serverSocket.close();
				}
			}   
			catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}     
		
	
	
	public static ArrayList<Usuario> cadastrar(String login, String senha, ArrayList<Usuario> listUser) {
		return SistemaCadastro.iniciaCadastro(login, senha, listUser);
	}

	
}

