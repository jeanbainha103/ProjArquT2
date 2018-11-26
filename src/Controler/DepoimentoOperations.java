package Controler;

import Model.Depoimento;
import Model.Usuario;

public class DepoimentoOperations implements PostOperations{
	Depoimento depo = new Depoimento(null);
	public Depoimento cadastro(Depoimento dep, Usuario user, String content, String titulo) {
		this.depo = dep;
		inserirTitulo(titulo);
		return dep;
	}

	public void inserirTitulo(String titulo) {
		depo.setTitulo(titulo);
	}
	public void inserirComment(String comment) {
		depo.setComments(comment);
	}
}
