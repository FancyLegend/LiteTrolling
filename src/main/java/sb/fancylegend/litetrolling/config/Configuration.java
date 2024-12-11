package sb.fancylegend.litetrolling.config;

import org.bukkit.configuration.file.FileConfiguration;

public final class Configuration {
    private final int packetsCancelChance;
    public Configuration(FileConfiguration file) {
        this.packetsCancelChance = file.getInt("packets_cancel_chance", 65);
    }
    public int getPacketsCancelChance() {
        return packetsCancelChance;
    }
}
