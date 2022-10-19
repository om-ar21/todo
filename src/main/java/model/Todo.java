package model;

public class Todo {
	private int id_todo;
	private int id_user;
	private String titre;
	private String description;
	private boolean done;
	public int getId_todo() {
		return id_todo;
	}
	public void setId_todo(int id_todo) {
		this.id_todo = id_todo;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Todo(int id_todo, int id_user, String titre, String description, boolean done) {
		super();
		this.id_todo = id_todo;
		this.id_user = id_user;
		this.titre = titre;
		this.description = description;
		this.done = done;
	}
	public Todo(int id_user, String titre, String description, boolean done) {
		super();
		this.id_user = id_user;
		this.titre = titre;
		this.description = description;
		this.done = done;
	}
	
	public Todo(int id_user, String titre, String description) {
		super();
		this.id_user = id_user;
		this.titre = titre;
		this.description = description;
	}
	public Todo() {
		super();
	}
	@Override
	public String toString() {
		return "Todo [id_todo=" + id_todo + ", id_user=" + id_user + ", titre=" + titre + ", description=" + description
				+ ", done=" + done + "]";
	}
	
	
	
}
