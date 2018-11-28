package View;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
private static boolean logado = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Opcoes de acao:");
		System.out.println("Cadastrar produto = 0-nome do produto");
		System.out.println("Dar lances = 1-indice do produto-valor(sem pontuacao e espaco)");
		System.out.println("Retira produto e aceita o ultimo lance = 2-indice do produto-senha retirada");
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			String [] struct = input.split("-");
			DatagramSocket clientSocket = new DatagramSocket();
		    InetAddress IPAddress = InetAddress.getByName("localhost");
		    byte[] sendData = new byte[1024];	
		    String message = input;
			sendData = message.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7027);
			clientSocket.send(sendPacket);


			clientSocket.close();
			if (Integer.parseInt(struct[0])==1) {
				
			}else if (Integer.parseInt(struct[0])==2){
				DatagramSocket serverSocket = new DatagramSocket(9027);
				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String sentence = new String( receivePacket.getData());
				System.out.println("RECEIVED: " + sentence);
				
				serverSocket.close();
				if(sentence.contains("logado")) {
					logado = true;
					serverSocket.close();
					while(logado) {
						Scanner sc2 = new Scanner(System.in);
						String input2 = sc.nextLine();
						DatagramSocket clientSocket2 = new DatagramSocket();
					    InetAddress IPAddress2 = InetAddress.getByName("localhost");
					    byte[] sendData2 = new byte[1024];	
					    String message2 = input2;
						sendData2 = message2.getBytes();
						DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress2, 8027);
						clientSocket2.send(sendPacket2);
						
						System.out.println("client-8000");
		
						clientSocket2.close();
					}
				}else {
				}
			
				
			}
		}
	}
}