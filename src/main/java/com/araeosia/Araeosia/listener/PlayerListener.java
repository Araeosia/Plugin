package com.araeosia.Araeosia.listener;

import com.araeosia.Araeosia.AraeosiaPlugin;
import com.araeosia.Araeosia.util.AraeosiaPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerListener implements Listener {
	private AraeosiaPlugin plugin;

	public PlayerListener(AraeosiaPlugin plugin){
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerLogin(final PlayerLoginEvent event){
		if(plugin.getDb().isBanned(event.getPlayer().getName())){
			event.setResult(PlayerLoginEvent.Result.KICK_BANNED);
			event.setKickMessage("You are banned!");
		}
	}
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event){
		event.setJoinMessage("");
		plugin.getPlayers().add(AraeosiaPlayer.load(event.getPlayer().getName()));
	}
}
