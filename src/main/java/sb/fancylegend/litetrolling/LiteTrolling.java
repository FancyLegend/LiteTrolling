package sb.fancylegend.litetrolling;

import com.github.retrooper.packetevents.PacketEvents;
import sb.fancylegend.litetrolling.command.TrollingCommand;
import sb.fancylegend.litetrolling.config.Configuration;
import sb.fancylegend.litetrolling.listener.PacketListener;
import sb.fancylegend.litetrolling.listener.PlayerListener;
import sb.fancylegend.litetrolling.manager.TrollingManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LiteTrolling extends JavaPlugin {

    private static TrollingManager trollingManager;
    private static Configuration configuration;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        configuration = new Configuration(getConfig());
        trollingManager = new TrollingManager();

        PacketEvents.getAPI().init();

        PacketEvents.getAPI().getEventManager().registerListener(new PacketListener());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("trolling").setExecutor(new TrollingCommand());
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }

    public static TrollingManager getTrollingManager() {
        return trollingManager;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}
