package plugin.XDdrummer.PowerUps;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

			}
		}else {
			
		}


		return false;
	}
}
