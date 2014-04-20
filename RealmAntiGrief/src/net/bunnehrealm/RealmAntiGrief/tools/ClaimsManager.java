package net.bunnehrealm.RealmAntiGrief.tools;

import net.bunnehrealm.RealmAntiGrief.AntiGrief;

public class ClaimsManager {

	AntiGrief AntiGrief;

	public ClaimsManager(AntiGrief AntiGrief) {
		this.AntiGrief = AntiGrief;
	}

	public String id;
	public int idNumb;
	public String world;
	public String MainClaim;
	public String SubClaim;
	public int x;
	public int y;
	public int z;

	public boolean isClaimed(String world_name, int b_x, int b_y, int b_z) {
		// Check all Ids
		for (String id : AntiGrief.claims.getStringList("Ids")) {
			idNumb = id.length();
			for (String world : AntiGrief.claims.getStringList(id + ".world.")) {

				if (world.equalsIgnoreCase(world_name)) {

					if (AntiGrief.claims.contains(world + ".MainClaim."
							+ b_x + "/" + b_y + "/" + b_z)) {
						// Tell receiver that land is claimed
						return true;
					} else
						for (String SubId : AntiGrief.claims
								.getStringList(world + "." + "SubClaims.Ids")) {
							if (SubId.contains(b_x + "/" + b_y + "/" + b_z)) {
								// Tell receiver that land is claimed
								return true;
							}

						}
				}
			}
		}

		return false;

	}

	//
	public boolean playerOwns(String player, String world_name, int b_x, int b_y, int b_z){
		// Check all Ids
				for (String id : AntiGrief.claims.getStringList("Ids")) {
					// Check the world
					for (String world : AntiGrief.claims.getStringList(id + ".world")) {

						if (world.equalsIgnoreCase(world_name)) {

							if (AntiGrief.claims.contains(world + "." + "MainClaim.Owners."
									+ player)) {
								// Tell receiver that player owns land
								return true;
							} else
								for (String SubId : AntiGrief.claims
										.getStringList(world + "." + "SubClaims.Ids")) {
									if (SubId.contains(".Owners." + player)) {
										// Tell receiver that land is claimed
										return true;
									}

								}
						}
					}
				}

				return false;
	}
}
