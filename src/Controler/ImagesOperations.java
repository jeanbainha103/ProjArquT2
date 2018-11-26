package Controler;

import Model.Image;
import Model.Usuario;

public class ImagesOperations implements PostOperations{
	Image image = new Image(null);
	public Image cadastro(Image im, Usuario user, String content, String titulo) {
		this.image = im;
		inserirTitulo(titulo);
		return im;
	}

	public void inserirTitulo(String titulo) {
		image.setTitulo(titulo);
	}
	public void inserirComment(String comment) {
		image.setComments(comment);
	}
}
