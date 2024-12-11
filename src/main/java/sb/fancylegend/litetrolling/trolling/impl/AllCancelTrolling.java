package sb.fancylegend.litetrolling.trolling.impl;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import sb.fancylegend.litetrolling.LiteTrolling;
import sb.fancylegend.litetrolling.trolling.AbstractTrolling;
import sb.fancylegend.litetrolling.trolling.TrollingType;

public final class AllCancelTrolling extends AbstractTrolling {
    public AllCancelTrolling() {
        super(TrollingType.ALL_CANCEL);
    }

    @Override
    public void packetReceive(PacketReceiveEvent e) {
        if (Math.random() < LiteTrolling.getConfiguration().getPacketsCancelChance() / 100.0) e.setCancelled(true);
    }

    @Override
    public void packetSend(PacketSendEvent e) {
    }
}
