package Model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface Post {	
	void addComent(String login, String senha, String comment);	
	ArrayList<String> getComments();
	void setComments(String comments);
	public String getTitle();
}
