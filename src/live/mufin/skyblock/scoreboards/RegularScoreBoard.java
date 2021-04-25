package live.mufin.skyblock.scoreboards;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import live.mufin.skyblock.Main;
import net.md_5.bungee.api.ChatColor;

public class RegularScoreBoard implements Listener {

	private Main plugin;

	public RegularScoreBoard(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		this.createBoard(e.getPlayer());
		
	}
	
	public void createBoard(Player player) {
		//time and date
		DateFormat dform = new SimpleDateFormat("dd/MM/yy");
		DateFormat tform = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		
		
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("regular", "dummy", ChatColor.translateAlternateColorCodes('&', "&e&lSKYBLOCK"));
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score = obj.getScore(ChatColor.GRAY + dform.format(date));
		score.setScore(12);
		Score score2 = obj.getScore(ChatColor.RESET + " " + ChatColor.RESET + " ");
		score2.setScore(11);
		Score score3 = obj.getScore(ChatColor.WHITE + " comingsoon");
		score3.setScore(10);
		Score score4 = obj.getScore(ChatColor.GRAY + " " + tform.format(date));
		score4.setScore(9);
		Score score5 = obj.getScore(ChatColor.GRAY + " ⏣ " + ChatColor.GREEN + "Your Island");
		score5.setScore(8);
		Score score6 = obj.getScore(ChatColor.RESET + " " + ChatColor.RESET + " "  + ChatColor.RESET + " " );
		score6.setScore(7);
		Score score7 = obj.getScore("Flight Duration: " + ChatColor.GREEN + "∞");
		score7.setScore(6);
		Score score8 = obj.getScore("Coins: " + ChatColor.GOLD + plugin.data.getConfig().getLong(player.getUniqueId() + ".skyblock.coins"));
		score8.setScore(5);
		Score score9 = obj.getScore("Bits: " + ChatColor.AQUA + plugin.data.getConfig().getInt(player.getUniqueId() + ".skyblock.bits"));
		score9.setScore(4);
		Score score10 = obj.getScore(ChatColor.RESET + " ");
		score10.setScore(3);
		Score score11 = obj.getScore(ChatColor.YELLOW + "www.mufin.live");
		score11.setScore(2);
		player.setScoreboard(board);
	}
	
	
}
