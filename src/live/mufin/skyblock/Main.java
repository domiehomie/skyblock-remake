package live.mufin.skyblock;

import live.mufin.skyblock.commands.*;
import live.mufin.skyblock.commands.tabcompleters.GotoTabComplete;
import live.mufin.skyblock.events.*;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import live.mufin.skyblock.commands.tabcompleters.ItemTabComplete;
import live.mufin.skyblock.commands.tabcompleters.SetLoggerTabComplete;
import live.mufin.skyblock.commands.tabcompleters.SetStatTabComplete;
import live.mufin.skyblock.gui.SkyblockMenu;
import live.mufin.skyblock.items.ItemDataManager;
import live.mufin.skyblock.items.ItemManager;
import live.mufin.skyblock.items.abilities.ItemStats;
import live.mufin.skyblock.items.abilities.MushroomSoup;
import live.mufin.skyblock.playerdata.Stats;
import live.mufin.skyblock.scoreboards.RegularScoreBoard;

public class Main extends JavaPlugin {

	public Utils utils;
	public ItemDataManager items;
	FileConfiguration config = this.getConfig();
	public RegularScoreBoard board;
	public ItemManager item;
	private MushroomSoup soup;
	public Stats stats;
	private ItemStats itemStats;
	
	public void onEnable() {
		this.utils = new Utils(this);
		this.saveDefaultConfig();
		this.board = new RegularScoreBoard(this);
		this.items = new ItemDataManager(this);
		this.item = new ItemManager(this);
		
		this.soup = new MushroomSoup(this);
		this.stats = new Stats(this);
		this.itemStats = new ItemStats(this);

		this.getServer().createWorld(WorldCreator.name("hub"));

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
		this.getCommand("setbits").setExecutor(new SetBitsCommand(this));
		this.getCommand("build").setExecutor(new BuildCommand(this));
		this.getCommand("goto").setExecutor(new GotoCommand(this));

		this.getCommand("setlogger").setTabCompleter(new SetLoggerTabComplete());
		this.getCommand("setstat").setTabCompleter(new SetStatTabComplete());
		this.getCommand("item").setTabCompleter(new ItemTabComplete(this));
		this.getCommand("goto").setTabCompleter(new GotoTabComplete());
		
		this.getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		this.getServer().getPluginManager().registerEvents(new RegularScoreBoard(this), this);
		this.getServer().getPluginManager().registerEvents(new LoggingEvents(this), this);
		this.getServer().getPluginManager().registerEvents(new FoodEvent(), this);
		this.getServer().getPluginManager().registerEvents(new SkyblockDeathEvents(this), this);
		this.getServer().getPluginManager().registerEvents(new MushroomSoup(this), this);
		this.getServer().getPluginManager().registerEvents(new SkyblockMenu(this), this);
		this.getServer().getPluginManager().registerEvents(new BuildModeEvents(this), this);
		
		soup.runnable();
		itemStats.runnable();
	}

	public void onDisable() {
		
	}
}
