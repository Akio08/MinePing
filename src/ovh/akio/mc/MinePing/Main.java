package ovh.akio.mc.MinePing;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable(){
		this.getCommand("ms").setExecutor(new CommandMS());
	}
	public void onDisable(){
		
	}
}
