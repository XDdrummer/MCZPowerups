package plugin.XDdrummer.PowerUps;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MCZPowerupsMain extends JavaPlugin implements Listener
{
	Logger log = Bukkit.getLogger();

	@Override
	public void onEnable() {
		log.info("[MCZPowerups] Enabled MC-ZPowerups!");
		log.info("[MCZPowerups] Plugin in Beta!");
		this.getPluginManager().registerEvents(this, this);
		this.getCommand("powerupslist").setExecutor(new PowerupsListCommand(this));
		this.saveConfig();
	}

	@Override
	public void onDisable() {
		log.info("[MCZPowerups] Disabled MC-ZPowerups!");
		log.info("[MCZPowerups] Plugin in Beta!");
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent ev) {
		Player p = ev.getPlayer();
		if(p.hasPermission("powerups.active")||p.isOp()) {
			Material block = p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();

			if(block == Material.DIAMOND_BLOCK){
				PotionEffect diamondEffect = new PotionEffect(PotionEffectType.JUMP, 19, 3);
				PotionEffect diamondEffect2 = new PotionEffect(PotionEffectType.REGENERATION, 20, 3);

				p.sendMessage(ChatColor.AQUA + "You received High Jump + Regeneration from Diamond Block!");
				p.addPotionEffect(diamondEffect);
				p.addPotionEffect(diamondEffect2);
			}else if(block == Material.EMERALD_BLOCK) {
				PotionEffect emeraldEffect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 19, 3);
				PotionEffect emeraldEffect2 = new PotionEffect(PotionEffectType.NIGHT_VISION, 20, 3);

				p.sendMessage(ChatColor.GREEN + "You received Strength + Night Vision from Emerald Block!");
				p.addPotionEffect(emeraldEffect);
				p.addPotionEffect(emeraldEffect2);
			}else if(block == Material.GOLD_BLOCK) {
				PotionEffect goldEffect = new PotionEffect(PotionEffectType.SPEED, 19, 3);
				PotionEffect goldEffect2 = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20, 3);

				p.sendMessage(ChatColor.YELLOW + "You received Speed + Fire Resistance from Gold Block!");
				p.addPotionEffect(goldEffect);
				p.addPotionEffect(goldEffect2);
			}else if(block == Material.BEACON) {
				PotionEffect beaconEffect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 61, 5);
				PotionEffect beaconEffect2 = new PotionEffect(PotionEffectType.BLINDNESS, 31, 5);

				p.sendMessage(ChatColor.BOLD + "You received Damage Resistance from Beacon, in exchange for 30 seconds of your vision!");
				p.addPotionEffect(beaconEffect);
				p.addPotionEffect(beaconEffect2);
			}else{}
		}
		
		if(p.hasPermission("powerups.liquid")||p.isOp())
		{
			Material liquid = p.getLocation().getBlock().getType();
			Material liquidPlayerIsIn =	p.getLocation().getBlock().getRelative(BlockFace.UP).getType();
			if((liquid == Material.WATER)||(liquid == Material.STATIONARY_WATER))
			{
				PotionEffect waterEffect = new PotionEffect(PotionEffectType.CONFUSION, 30, 1);
				PotionEffect waterEffect2 = new PotionEffect(PotionEffectType.HUNGER, 10, 1);
				
				p.sendMessage(ChatColor.RED + "The water is poisonous!");
				p.addPotionEffect(waterEffect);
				p.addPotionEffect(waterEffect2);
			}else if((liquid == Material.LAVA)||(liquid == Material.STATIONARY_LAVA))
			{
				PotionEffect lavaEffect = new PotionEffect(PotionEffectType.WEAKNESS, 5, 1);
				
				p.sendMessage(ChatColor.RED + "The burning lava weakens you!");
				p.addPotionEffect(lavaEffect);
			}else{}

			if((liquidPlayerIsIn == Material.WATER)||(liquidPlayerIsIn == Material.STATIONARY_WATER))
			{
				p.setRemainingAir(0);
				p.sendMessage(ChatColor.BLUE + "The water is too dirty to breathe in!");
			}else{}
		}
	}
}
