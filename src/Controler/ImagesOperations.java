package Controler;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Model.Depoimento;
import Model.Image;
import Model.Usuario;

public class ImagesOperations implements PostOperations{
	public Image cadastro(Image im, Usuario user, String content, String titulo) {
		im.setContent(content);
		im.setTitulo(titulo);
		return im;
	}

	public void showPost(Usuario user) {
		ArrayList<Image> all = user.listaImages;
		for (Image img : all) {
			System.out.println(img.getTitle());
			System.out.println(img.getContent());
		}
	}
}
