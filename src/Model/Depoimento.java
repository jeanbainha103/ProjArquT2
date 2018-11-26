package Model;

import java.util.ArrayList;

public class Depoimento implements Post{
	private Usuario user;
	private ArrayList<String> comments;
	private String content;
	private String title;
	
	public Depoimento(Usuario user) {
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

	public void setComments (String comments) {
		this.comments.add(comments);
	}

	public String getContent() {
		return content;
	}
	
	public void setTitulo(String titulo) {
		this.title = titulo;
	}

	public String getTitle() {
		return title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
