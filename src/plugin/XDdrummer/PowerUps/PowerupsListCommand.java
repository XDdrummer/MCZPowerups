package plugin.XDdrummer.PowerUps;

import java.util.logging.Logger;

import plugin.XDdrummer.PowerUps

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class PowerupsListCommand implements CommandExecutor {
	Logger log = Bukkit.getLogger();
	
	MCZPowerupsMain plugin;

	public PowerupsListCommand(MCZPowerupsMain pPlugin) {
		this.plugin = pPlugin;
	}

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player p = (Player) s;
			if(p.hasPermission("powerups.admin")||p.isOp()) {
				p.sendMessage(ChatColor.GREEN + "[MCZPowerups] Admin's List of MC-Z Powerups!" + "\n"
				+ ChatColor.RED + "Note- in order to be effected by powerups, must have perm 'powerups.active'" + "\n"
				+ ChatColor.BLUE + "Diamond blocks provide 20 seconds of Jump + Regeneration." + "\n"
				+ ChatColor.GREEN + "Emerald blocks provide 20 seconds of Strentgh + Night Vision." + "\n"
				+ ChatColor.YELLOW + "Gold blocks provide 20 seconds of Speed + Fire Resistance." + "\n"
				+ ChatColor.AQUA + "Beacons provide 60 seconds of Damage Resistance, but 30 seconds of Confusion." + "\n"
				+ ChatColor.BLUE + "Water is poisonous! It gives you 10 seconds of Confusion + Hunger." + "\n"
				+ ChatColor.RED + "Lava weakens you! It gives you 5 seconds of weakness." + "\n"
				+ ChatColor.AQUA + "Warning! You can not breathe under water!");
			}
		}else {
			
		}


		return false;
	}
}
