package sb.fancylegend.litetrolling.trolling;

public abstract class AbstractTrolling implements ITrolling {
    private final TrollingType type;

    public AbstractTrolling(TrollingType type) {
        this.type = type;
    }

    public TrollingType getType() {
        return type;
    }
}
