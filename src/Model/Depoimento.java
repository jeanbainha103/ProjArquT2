package Model;

public class Depoimento implements Post{
	private Usuario user;
	private String comments;
	private String content;
	private String title;
	
	public Depoimento(Usuario user, String content, String title) {
		super();
		this.user = user;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return title;
	}
}
