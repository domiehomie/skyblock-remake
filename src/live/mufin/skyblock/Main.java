package live.mufin.skyblock;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import live.mufin.skyblock.commands.CoinsCommand;
import live.mufin.skyblock.commands.ItemCommand;
import live.mufin.skyblock.commands.LoggerCommand;
import live.mufin.skyblock.commands.ScoreboardReloadCommand;
import live.mufin.skyblock.commands.SetCoinsCommand;
import live.mufin.skyblock.commands.SetFlightCommand;
import live.mufin.skyblock.commands.SetLoggerCommand;
import live.mufin.skyblock.commands.SetStatCommand;
import live.mufin.skyblock.commands.SkyblockCommand;
import live.mufin.skyblock.commands.StatsCommand;
import live.mufin.skyblock.commands.tabcompleters.ItemTabComplete;
import live.mufin.skyblock.commands.tabcompleters.SetLoggerTabComplete;
import live.mufin.skyblock.commands.tabcompleters.SetStatTabComplete;
import live.mufin.skyblock.events.FoodEvent;
import live.mufin.skyblock.events.JoinEvent;
import live.mufin.skyblock.events.LoggingEvents;
import live.mufin.skyblock.events.SkyblockDeathEvents;
import live.mufin.skyblock.events.SkyblockmenuPreventRemoval;
import live.mufin.skyblock.gui.SkyblockMenu;
import live.mufin.skyblock.items.ItemDataManager;
import live.mufin.skyblock.items.ItemManager;
import live.mufin.skyblock.items.abilities.MushroomSoup;
import live.mufin.skyblock.playerdata.PlayerDataManager;
import live.mufin.skyblock.playerdata.Stats;
import live.mufin.skyblock.scoreboards.RegularScoreBoard;

public class Main extends JavaPlugin {

	public Utils utils;
	public ItemDataManager items;
	FileConfiguration config = this.getConfig();
	public PlayerDataManager data;
	public RegularScoreBoard board;
	public ItemManager item;
	public PlayerDeath death;
	private MushroomSoup soup;
	public Stats stats;

	public void onEnable() {
		this.utils = new Utils(this);
		this.data = new PlayerDataManager(this);
		this.saveDefaultConfig();
		this.board = new RegularScoreBoard(this);
		this.items = new ItemDataManager(this);
		this.item = new ItemManager(this);
		this.death = new PlayerDeath(this);
		this.soup = new MushroomSoup(this);
		this.stats = new Stats(this);

		this.getCommand("skyblock").setExecutor(new SkyblockCommand(this));
		this.getCommand("stats").setExecutor(new StatsCommand(this));
		this.getCommand("coins").setExecutor(new CoinsCommand(this));
		this.getCommand("setcoins").setExecutor(new SetCoinsCommand(this));
		this.getCommand("setstat").setExecutor(new SetStatCommand(this));
		this.getCommand("scoreboardreload").setExecutor(new ScoreboardReloadCommand(this));
		this.getCommand("setlogger").setExecutor(new SetLoggerCommand(this));
		this.getCommand("item").setExecutor(new ItemCommand(this));
		this.getCommand("logger").setExecutor(new LoggerCommand(this));
		this.getCommand("setflight").setExecutor(new SetFlightCommand(this));
		
		this.getCommand("setlogger").setTabCompleter(new SetLoggerTabComplete(this));
		this.getCommand("setstat").setTabCompleter(new SetStatTabComplete());
		this.getCommand("item").setTabCompleter(new ItemTabComplete(this));
		
		
		this.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		this.getServer().getPluginManager().registerEvents(new RegularScoreBoard(this), this);
		this.getServer().getPluginManager().registerEvents(new SkyblockmenuPreventRemoval(), this);
		this.getServer().getPluginManager().registerEvents(new LoggingEvents(this), this);
		this.getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		this.getServer().getPluginManager().registerEvents(new SkyblockDeathEvents(this), this);
		this.getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		this.getServer().getPluginManager().registerEvents(new MushroomSoup(this), this);
		this.getServer().getPluginManager().registerEvents(new SkyblockMenu(this), this);
		
		soup.runnable();
	}

	public void onDisable() {

	}
}
