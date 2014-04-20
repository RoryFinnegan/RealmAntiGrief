package net.bunnehrealm.RealmAntiGrief.listeners;

import net.bunnehrealm.RealmAntiGrief.tools.AutoProtector;
import net.bunnehrealm.RealmAntiGrief.tools.ClaimsManager;
import net.bunnehrealm.RealmAntiGrief.AntiGrief;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceManager implements Listener{
	
	AntiGrief AntiGrief;
	ClaimsManager ClaimsManager;
	
	public PlaceManager(AntiGrief AntiGrief){
		this.AntiGrief = AntiGrief;
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		
		Player player = e.getPlayer();
		player.sendMessage("placed");
		Block block = e.getBlockPlaced();
		Location b_loc = block.getLocation();
		String world_name = block.getWorld().getName();
		int b_x = b_loc.getBlockX();
		int b_y = b_loc.getBlockY();
		int b_z = b_loc.getBlockZ();
		String playerUUID = player.getUniqueId().toString();
		
		//If land is claimed
		if(ClaimsManager.isClaimed(world_name, b_x, b_y, b_z)){
			if(ClaimsManager.playerOwns(playerUUID, world_name, b_x, b_y, b_z)){
				
				//Let the player place the block
				e.setCancelled(false);
			}
		}
		//If land is NOT CLAIMED
		else{
			AutoProtector ap = new AutoProtector(AntiGrief);
			ap.createClaim(playerUUID, world_name, b_x, b_y, b_z);
		}
		
	}
	
	
}
