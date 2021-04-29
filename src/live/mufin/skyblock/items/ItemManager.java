package live.mufin.skyblock.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import live.mufin.skyblock.Main;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;

public class ItemManager {

	private Main plugin;
	
	public ItemManager(Main plugin) {
		this.plugin = plugin;
	}
	
	public enum Rarity {
		COMMON,
		UNCOMMON,
		RARE,
		EPIC,
		LEGENDARY,
		MYTHIC,
		SUPREME,
		SPECIAL,
	}
	
	public String getItemName(String item) {
		if(plugin.items.getConfig().contains(item + ".name"))
			return ChatColor.translateAlternateColorCodes('&', plugin.items.getConfig().getString(item + ".name"));
		else
			return null;
	}
	
	
	
	public List<String> getItemLore(String item) {
		if(plugin.items.getConfig().contains(item + ".lore")) {
			List<String> configLore = plugin.items.getConfig().getStringList(item + ".lore");
			List<String> lore = new ArrayList<String>();
			for(String loreitem : configLore) {
				lore.add(ChatColor.translateAlternateColorCodes('&', loreitem));
			}
			
			if(plugin.items.getConfig().contains(item + ".rarity")) {
				lore.add(ChatColor.RESET + "             ");
				try {
					Rarity rarity = Rarity.valueOf(plugin.items.getConfig().getString(item + ".rarity"));
					switch(rarity) {
					case COMMON:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&f&lCOMMON"));
						break;
					case UNCOMMON:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&a&lUNCOMMON"));
						break;
					case RARE:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&9&lRARE"));
						break;
					case EPIC:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&5&lEPIC"));
						break;
					case LEGENDARY:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&6&lLEGENDARY"));
						break;
					case MYTHIC:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&d&lMYTHIC"));
						break;
					case SUPREME:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&4&lSUPREME"));
						break;
					case SPECIAL:
						lore.add(ChatColor.translateAlternateColorCodes('&', "&c&lSPECIAL"));
						break;
					}
				}catch (IllegalArgumentException e){
					
				}
			}
			return lore;
		}else
			return null;
	}
	
	public Material getItemMaterial(String item) {
		if(plugin.items.getConfig().contains(item + ".material")) {
			try {
				return Material.valueOf(plugin.items.getConfig().getString(item + ".material"));
			} catch (IllegalArgumentException e ) {
				return null;
			}
		}else
			return null;
	}
	
	
	public ItemStack getItem(String itemname) {
		if(plugin.items.getConfig().contains(itemname)) { 
			Material material = this.getItemMaterial(itemname);
			ItemStack item = new ItemStack(material);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(this.getItemName(itemname));
			meta.setLore(this.getItemLore(itemname));
			if(plugin.items.getConfig().getBoolean(itemname + ".enchanted")) {
				meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}
			item.setItemMeta(meta);
			return item;
		}
		return null;
	}
	
	
	
	
	
}
