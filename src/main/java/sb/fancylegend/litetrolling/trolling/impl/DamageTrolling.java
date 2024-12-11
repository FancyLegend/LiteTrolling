package sb.fancylegend.litetrolling.trolling.impl;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import sb.fancylegend.litetrolling.trolling.AbstractTrolling;
import sb.fancylegend.litetrolling.trolling.TrollingType;

public final class DamageTrolling extends AbstractTrolling {
    private final double multiplier;

    public DamageTrolling(double multiplier) {
        super(TrollingType.DAMAGE);
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public void packetReceive(PacketReceiveEvent e) {
    }

    @Override
    public void packetSend(PacketSendEvent e) {
    }
}
