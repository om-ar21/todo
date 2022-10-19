package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoDAO {
public void save(Todo obj) {
		
		try {
			
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO todo (id_user,titre,description) VALUES(?,?,?)");
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setString(2,obj.getTitre());
				preparedStatement.setString(3,obj.getDescription());
			
	            preparedStatement.executeUpdate();
			
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
public ArrayList<Todo> getAllByIduser(int iduser) {
	ArrayList<Todo> list = new ArrayList<Todo>();
	
	try {

		PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM todo where id_user=? and done=0 ORDER BY id_todo DESC");
		preparedStatement.setInt(1,iduser);
		ResultSet resultat=preparedStatement.executeQuery();
		
		while(resultat.next()) {
			Todo o = new Todo();
			o.setId_todo(resultat.getInt( "id_todo" ));
			o.setId_user(resultat.getInt( "id_user" ));
			o.setTitre(resultat.getString( "titre" ));
			o.setDescription(resultat.getString( "description" ));
			o.setDone(resultat.getBoolean( "done" ));
		
			list.add(o);
		}


		return list;

	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}
public ArrayList<Todo> getAllByIduserCheck(int iduser) {
	ArrayList<Todo> list = new ArrayList<Todo>();
	
	try {

		PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM todo where id_user=? and done=1 ");
		preparedStatement.setInt(1,iduser);
		ResultSet resultat=preparedStatement.executeQuery();
		
		while(resultat.next()) {
			Todo o = new Todo();
			o.setId_todo(resultat.getInt( "id_todo" ));
			o.setId_user(resultat.getInt( "id_user" ));
			o.setTitre(resultat.getString( "titre" ));
			o.setDescription(resultat.getString( "description" ));
			o.setDone(resultat.getBoolean( "done" ));
		
			list.add(o);
		}


		return list;

	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}
public void check(int id) {
	try {
	
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE todo set done=1 WHERE id_todo=?");
			preparedStatement.setInt(1,id);
	        preparedStatement.executeUpdate();

	        System.out.println("check OK");
		
	} catch (Exception ex) {
    	ex.printStackTrace();
    	 System.out.println("check NO");
    }
}
}
