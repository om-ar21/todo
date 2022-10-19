package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public void save(User obj) {
		
		try {
			
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO user (nom,email,mdp) VALUES(?,?,?)");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getEmail());
				preparedStatement.setString(3,obj.getMdp());
			
	            preparedStatement.executeUpdate();
			
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public User connexion(String email,String mdp) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.
				prepareStatement("SELECT * FROM user WHERE email=? AND mdp=?");
				preparedStatement.setString(1,email);
				preparedStatement.setString(2,mdp);
				ResultSet resultat=preparedStatement.executeQuery();
				User u = new User();
				if(resultat.next()) {
					u.setId_user(resultat.getInt( "id_user" ));
					u.setNom(resultat.getString( "nom" ));
					u.setEmail(resultat.getString( "email" ));
					
					
					return u;
				}else {
					return null;
				}
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public int verifyEmail(String email) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT count(*) as mail FROM user WHERE email=?");
				preparedStatement.setString(1,email);
				
				
				
				ResultSet resultat=preparedStatement.executeQuery();
				resultat.next();

				int total = resultat.getInt( "mail" );
				return total;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return 0;
        }
	}
}
