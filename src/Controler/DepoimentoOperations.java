package Controler;

import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertContentAction;

import Model.Depoimento;
import Model.Usuario;

public class DepoimentoOperations implements PostOperations{
	public Depoimento cadastro(Depoimento dep, Usuario user, String content, String titulo) {
		dep.setContent(content);
		dep.setTitulo(titulo);
		user.listaDepoimentos.add(dep);
		return dep;
	}
	
	public void showPost(Usuario user) {
		ArrayList<Depoimento> all = user.listaDepoimentos;
		for (Depoimento depoimento : all) {
			System.out.println(depoimento.getTitle());
			System.out.println(depoimento.getContent());
		}
	}
}
