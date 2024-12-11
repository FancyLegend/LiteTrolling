package sb.fancylegend.litetrolling.trolling;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;

public interface ITrolling {
    void packetReceive(PacketReceiveEvent e);
    void packetSend(PacketSendEvent e);
}
