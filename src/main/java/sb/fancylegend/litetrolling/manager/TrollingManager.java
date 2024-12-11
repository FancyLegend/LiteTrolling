package sb.fancylegend.litetrolling.manager;

import sb.fancylegend.litetrolling.trolling.AbstractTrolling;
import sb.fancylegend.litetrolling.trolling.TrollingType;
import sb.fancylegend.litetrolling.trolling.impl.AllCancelTrolling;
import sb.fancylegend.litetrolling.trolling.impl.DamageTrolling;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;

public final class TrollingManager {
    private final HashMap<Player, HashSet<AbstractTrolling>> trollings = new HashMap<>();

    public HashMap<Player, HashSet<AbstractTrolling>> getTrollings() {
        return trollings;
    }

    public void addTrolling(Player player, TrollingType type) {
        trollings.computeIfAbsent(player, p -> new HashSet<>());
        if (type == TrollingType.ALL_CANCEL) trollings.get(player).add(new AllCancelTrolling());
    }

    public void addDamageTrolling(Player player, double multiplier) {
        trollings.computeIfAbsent(player, p -> new HashSet<>());
        trollings.get(player).removeIf(t -> t.getType() == TrollingType.DAMAGE);
        trollings.get(player).add(new DamageTrolling(multiplier));
    }

    public void removeTrolling(Player player, TrollingType type) {
        HashSet<AbstractTrolling> set = trollings.get(player);
        if (set == null) return;
        set.removeIf(t -> t.getType() == type);
    }

    public boolean isAlreadyTrollingSetup(Player player, TrollingType type) {
        HashSet<AbstractTrolling> set = trollings.get(player);
        if (set == null) return false;
        return set.stream().anyMatch(t -> t.getType() == type);
    }
}
