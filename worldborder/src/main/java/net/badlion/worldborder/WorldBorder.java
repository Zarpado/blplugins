package net.badlion.worldborder;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;


public class WorldBorder extends JavaPlugin
{
	public static WorldBorder plugin;

	public WorldBorder()
	{
		plugin = this;
	}

	@Override
	public void onEnable()
	{
		// Load (or create new) config file
		Config.load(this, false);

		// our one real command, though it does also have aliases "wb" and "worldborder"
		getCommand("wborder").setExecutor(new WBCommand(this));

		// keep an eye on teleports, to redirect them to a spot inside the border if necessary
		getServer().getPluginManager().registerEvents(new WBListener(), this);

		// Well I for one find this info useful, so...
		Location spawn = getServer().getWorlds().get(0).getSpawnLocation();
		Config.log("For reference, the main world's spawn location is at X: " + Config.coord.format(spawn.getX()) + " Y: " + Config.coord.format(spawn.getY()) + " Z: " + Config.coord.format(spawn.getZ()));
	}

	@Override
	public void onDisable()
	{
		Config.StopBorderTimer();
		Config.StoreFillTask();
		Config.StopFillTask();
	}

	// for other plugins to hook into
	public BorderData GetWorldBorder(String worldName)
	{
		return Config.Border(worldName);
	}
}
