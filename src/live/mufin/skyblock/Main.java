package live.mufin.skyblock;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import live.mufin.skyblock.commands.CoinsCommand;
import live.mufin.skyblock.commands.SetStatTabComplete;
import live.mufin.skyblock.commands.SetCoinsCommand;
import live.mufin.skyblock.commands.SetStatCommand;
import live.mufin.skyblock.commands.SkyblockCommand;
import live.mufin.skyblock.commands.StatsCommand;
import live.mufin.skyblock.events.JoinEvent;
import live.mufin.skyblock.playerdata.PlayerDataManager;

public class Main extends JavaPlugin {
	
	public Utils utils;
	FileConfiguration config = this.getConfig();
	public PlayerDataManager data;
	
	public void onEnable() {
		this.utils = new Utils(this);
		this.data = new PlayerDataManager(this);
		this.saveDefaultConfig();
		
		this.getCommand("skyblock").setExecutor(new SkyblockCommand(this));
		this.getCommand("stats").setExecutor(new StatsCommand(this));
		this.getCommand("coins").setExecutor(new CoinsCommand(this));
		this.getCommand("setcoins").setExecutor(new SetCoinsCommand(this));
		this.getCommand("setstat").setExecutor(new SetStatCommand(this));
		this.getCommand("setstat").setTabCompleter(new SetStatTabComplete());
		
		this.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
	}
	
	public void onDisable() {
		
	}
}
