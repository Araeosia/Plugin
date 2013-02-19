package com.araeosia.Araeosia.util;

import com.araeosia.Araeosia.AraeosiaPlugin;

import java.sql.*;

public class Database {
	private Connection connection=null;
	private AraeosiaPlugin plugin;

	public Database(AraeosiaPlugin plugin) throws Exception{
		this.plugin = plugin;
		if(!initDB()){
			throw new Exception("Could not connect to database!");
		}
	}

	private Boolean initDB(){
		try{
			if(connection==null || !connection.isValid(30)){
				connection = DriverManager.getConnection(
						plugin.getConfig().getString("Araeosia.database.url"),
						plugin.getConfig().getString("Araeosia.database.user"),
						plugin.getConfig().getString("Araeosia.database.password")
				);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			return false;
		}
	}

	public Boolean isBanned(String player){
		// TODO write this
		initDB();
		try{
			PreparedStatement s = connection.prepareStatement("SELECT * FROM Araeosia_bans WHERE player=? AND active=TRUE");
			s.setString(1, player);
			ResultSet rs = s.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}
