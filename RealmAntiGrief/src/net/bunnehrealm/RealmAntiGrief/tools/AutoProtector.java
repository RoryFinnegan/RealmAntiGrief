package net.bunnehrealm.RealmAntiGrief.tools;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.bunnehrealm.RealmAntiGrief.AntiGrief;
import net.bunnehrealm.RealmAntiGrief.tools.UUIDManager;

public class AutoProtector implements Listener {

	UUIDManager UUIDManager;
	AntiGrief AntiGrief;
	ClaimsManager ClaimsManager;
	List<String> blocks;

	public AutoProtector(AntiGrief AntiGrief) {
		this.AntiGrief = AntiGrief;
	}

	public AutoProtector(ClaimsManager ClaimsManager) {
		this.ClaimsManager = ClaimsManager;
	}

	public void createClaim(String playerUUID, String world, int x, int y, int z) {
		
		Player player = (Player) UUIDManager.getPlayer(playerUUID);
		AntiGrief.claims.set("Ids." + ClaimsManager.idNumb++ + ".world."
				+ player.getWorld().getName().toString() + ".MainClaim.", x + "/" + y + "/" + z + "/" );

	}
}
