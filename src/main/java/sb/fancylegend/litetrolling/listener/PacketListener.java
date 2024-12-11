package sb.fancylegend.litetrolling.listener;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import sb.fancylegend.litetrolling.LiteTrolling;
import sb.fancylegend.litetrolling.trolling.AbstractTrolling;
import org.bukkit.entity.Player;

import java.util.HashSet;

public final class PacketListener extends PacketListenerAbstract {
    @Override
    public void onPacketReceive(PacketReceiveEvent e) {
        if (e.getPlayer() == null) return;
        Player player = (Player) e.getPlayer();
        HashSet<AbstractTrolling> trolls = LiteTrolling.getTrollingManager().getTrollings().get(player);
        if (trolls != null) {
            for (AbstractTrolling t : trolls) t.packetReceive(e);
        }
    }

    @Override
    public void onPacketSend(PacketSendEvent e) {
        if (e.getPlayer() == null) return;
        Player player = (Player) e.getPlayer();
        HashSet<AbstractTrolling> trolls = LiteTrolling.getTrollingManager().getTrollings().get(player);
        if (trolls != null) {
            for (AbstractTrolling t : trolls) t.packetSend(e);
        }
    }
}
