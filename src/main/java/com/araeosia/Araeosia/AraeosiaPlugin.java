package com.araeosia.Araeosia;

import com.araeosia.Araeosia.listener.PlayerListener;
import com.araeosia.Araeosia.util.AraeosiaPlayer;
import com.araeosia.Araeosia.util.Database;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class AraeosiaPlugin extends JavaPlugin {

	private Database db;
	private ArrayList<AraeosiaPlayer> players = new ArrayList<>();

	@Override
	public void onEnable(){
		getLogger().info("Setting up AraeosiaPlugin!");
		if(!setupDependencies()){
			getLogger().severe("Setup failed!");
			getServer().getPluginManager().disablePlugin(this);
		}
		setupListeners();
	}
	@Override
	public void onDisable(){
		getLogger().info("Disabling AraeosiaPlugin!");
	}

	public Boolean setupDependencies(){
		try{
			db = new Database(this);
		}catch(Exception e){
			getLogger().severe("Could not establish database connection!");
			return false;
		}
		return true;
	}

	public void setupListeners(){
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}

	public Database getDb() {
		return db;
	}

	public ArrayList<AraeosiaPlayer> getPlayers() {
		return players;
	}
}
