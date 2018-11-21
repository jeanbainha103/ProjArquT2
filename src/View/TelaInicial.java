package View;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Controler.SistemaCadastro;
import Model.Usuario;

public class TelaInicial {
	public static void main(String[] args) {
		ArrayList<Usuario> listUser = new ArrayList<>();
		while(true){
			try {
				ServerSocket servidor = new ServerSocket(12345);
				System.out.println("Servidor ouvindo a porta 12345");
				while(true) {
					Socket cliente = servidor.accept();
					System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
					ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
					DataInputStream dis = new DataInputStream(cliente.getInputStream()); // Saída de dados do cliente

				    while(true){
				        if(dis.available() >0){
				            String mensagem = ((DataInput) dis).readUTF(); // Lê a tal mensagem
				            System.out.println(mensagem); // E exibe na tela
				            /*listUser = cadastrar("login1", "senha1", listUser);
				    		System.out.println(listUser);
				    		ServerSocket server = new ServerSocket(8000);
				    		
				    		Usuario user = new Usuario("login1", "senha");
				    		Gerente start = new Gerente();
				    		start.Iniciar("login", "senha", listUser);	*/	
				            break;
				        } // Chegou alguma coisa?
				    }        
					saida.flush();
					saida.close();
					cliente.close();
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
