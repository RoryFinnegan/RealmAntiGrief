package net.bunnehrealm.RealmAntiGrief.tools;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UUIDManager {
	public Player getPlayer(String playerUUID){
	for(Player p : Bukkit.getOnlinePlayers()){
		if(p.getUniqueId().toString().equalsIgnoreCase(playerUUID)){
			return p;
		}
		
	}
	return null;
	
}
}
