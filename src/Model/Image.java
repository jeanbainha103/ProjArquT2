package Model;

import java.awt.image.BufferedImage;

public class Image implements Post{
	private Usuario user;
	private String comments;
	private BufferedImage image;
	private String title;
	
	public Image(Usuario user, BufferedImage image, String title) {
		super();
		this.user = user;
		this.image = image;
		this.title = title;
	}

	@Override
	public void addComent(String login, String senha, String comment) {
		// TODO Auto-generated method stub
		
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BufferedImage getContent() {
		return image;
	}

	public String getTitle() {
		return title;
	}
}
