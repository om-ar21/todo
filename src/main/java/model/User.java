package model;

public class User {
private int id_user;
private String nom;
private String email;
private String mdp;
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public User(int id_user, String nom, String email, String mdp) {
	super();
	this.id_user = id_user;
	this.nom = nom;
	this.email = email;
	this.mdp = mdp;
}
public User(String nom, String email, String mdp) {
	super();
	this.nom = nom;
	this.email = email;
	this.mdp = mdp;
}
public User() {
	super();
}
@Override
public String toString() {
	return "User [id_user=" + id_user + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + "]";
}


}
