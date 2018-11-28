package Model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Image implements Post{
	private Usuario user;
	private ArrayList<String> comments;
	private String image;
	private String title;
	
	public Image(Usuario user) {
		super();
		this.user = user;
	}

	@Override
	public void addComent(String login, String senha, String comment) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments.add(comments);
	}

	public String getContent() {
		return image;
	}

	public void setTitulo(String titulo) {
		this.title = titulo;
	}

	public String getTitle() {
		return title;
	}
	
	public void setContent(String content) {
		this.image = content;
	}
}
