package sb.fancylegend.litetrolling.listener;

import sb.fancylegend.litetrolling.LiteTrolling;
import sb.fancylegend.litetrolling.trolling.impl.DamageTrolling;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;

public final class PlayerListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        LiteTrolling.getTrollingManager().getTrollings().remove(e.getPlayer());
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        HashSet set = LiteTrolling.getTrollingManager().getTrollings().get(p);
        if (set == null) return;
        set.forEach(o -> {
            if (o instanceof DamageTrolling dt) {
                e.setDamage(e.getDamage() * dt.getMultiplier());
            }
        });
    }
}
