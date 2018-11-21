package Model;

import java.awt.image.BufferedImage;

public interface Post {	
	void addComent(String login, String senha, String comment);	
	String getComments();
	void setComments(String comments);
	public String getTitle();
}
