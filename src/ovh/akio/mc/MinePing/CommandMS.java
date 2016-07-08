package ovh.akio.mc.MinePing;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandMS implements CommandExecutor {

	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		String prefix = "§l•MinePing• ";
		
		switch(arg3.length){
		case 0:
			if(!(arg0 instanceof Player)){
				arg0.sendMessage(prefix + "§c§lYou must be a player to execute this command !");
				return true;
			}else{
				Player p = (Player) arg0;
				getPing(p,p);
				return true;
			}
		case 1:
			if(arg0 instanceof Player){
				if(arg3[0].toLowerCase().equals("help")){
					arg0.sendMessage(prefix + "§3§lUsage : /ms [player]");
					return true;
				}else{
					Player pinger = (Player) arg0;
					Player pinged = Bukkit.getPlayer(arg3[0]);
					if(pinged != null){
						getPing(pinger,pinged);
						return true;
					}else{
						pinger.sendMessage(prefix + "§c§lPlayer offline.");
						return true;
					}
				}
			}else{
				if(arg3[0].toLowerCase().equals("help")){
					arg0.sendMessage(prefix + "§3§lUsage : /ms <player>");
					return true;
				}else{
					Player pinger = (Player) arg0;
					Player pinged = Bukkit.getPlayer(arg3[0]);
					if(pinged != null){
						getPing(pinger,pinged);
						return true;
					}else{
						pinger.sendMessage(prefix + "§c§lPlayer offline.");
						return true;
					}
				}
			}
		default:
			arg0.sendMessage(prefix + "§3§lUsage : /ms [player]");
			return true;
		}
	}
	
	
	public void getPing(Player sender, Player pinger){
		String prefix = "§l•MinePing• ";
		Integer ping = ((CraftPlayer) pinger).getHandle().ping;
		if(ping == 0){
			sender.sendMessage(prefix + ChatColor.LIGHT_PURPLE + ping + "ms");
		}else if(ping>0 && ping<50){
			sender.sendMessage(prefix + ChatColor.AQUA + ping + "ms");
		}else if(ping>49 && ping<80){
			sender.sendMessage(prefix + ChatColor.GREEN + ping + "ms");
		}else if(ping>79 && ping<120){
			sender.sendMessage(prefix + ChatColor.YELLOW + ping + "ms");
		}else if(ping>119 && ping<160){
			sender.sendMessage(prefix + ChatColor.GOLD + ping + "ms");
		}else if(ping>159){
			sender.sendMessage(prefix + ChatColor.RED + ping + "ms");
		}
	}
	
}
