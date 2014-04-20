package net.bunnehrealm.RealmAntiGrief;

import java.io.File;

import net.bunnehrealm.RealmAntiGrief.tools.AutoProtector;
import net.bunnehrealm.RealmAntiGrief.tools.ClaimsManager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiGrief extends JavaPlugin {

	public File claimsFile;
	public YamlConfiguration claims;
	public ClaimsManager ClaimsManager;
	PluginManager pm = getServer().getPluginManager();
	public AutoProtector autoProtect = new AutoProtector(this);
	
	public void onDisable() {
		
		saveClaims();
		getServer().getLogger()
				.info("Realm Anti Grief has been disabled!");

	}

	public void onEnable() {

		getServer().getLogger()
				.info("Realm Anti Grief has been enabled!");

		claimsFile = new File(getDataFolder(), "claims.yml");
		claims = new YamlConfiguration();
		
		try {
			createClaims();
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadClaims();
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(autoProtect, this);

	}
	
	//Create a claims file if it does not exist
	public void createClaims() throws Exception {
		if (!claimsFile.exists()) {
			getServer().getLogger().info("Creating a claims.yml");
			claimsFile.getParentFile().mkdirs();
			claimsFile.createNewFile();
		}
	}

	// Load The Claims
	public void loadClaims() {
		try {
			claims.load(claimsFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	// Save the Claims
	public void saveClaims() {
		try {
			claims.save(claimsFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
