package sb.fancylegend.litetrolling.command;

import sb.fancylegend.litetrolling.LiteTrolling;
import sb.fancylegend.litetrolling.trolling.TrollingType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TrollingCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (!sender.hasPermission("litetrolling.admin")) return true;
        if (args.length < 2) return true;
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) return true;
        if (args[1].equalsIgnoreCase("lags")) {
            if (args.length > 2 && args[2].equalsIgnoreCase("stop")) {
                LiteTrolling.getTrollingManager().removeTrolling(target, TrollingType.ALL_CANCEL);
                sender.sendMessage("Применена функция троллинга lags stop на игрока " + target.getName());
                return true;
            }
            if (LiteTrolling.getTrollingManager().isAlreadyTrollingSetup(target, TrollingType.ALL_CANCEL)) {
                LiteTrolling.getTrollingManager().removeTrolling(target, TrollingType.ALL_CANCEL);
                sender.sendMessage("Применена функция троллинга lags stop на игрока " + target.getName());
            } else {
                LiteTrolling.getTrollingManager().addTrolling(target, TrollingType.ALL_CANCEL);
                sender.sendMessage("Применена функция троллинга lags на игрока " + target.getName());
            }
            return true;
        }
        if (args[1].equalsIgnoreCase("damage")) {
            if (args.length < 3) return true;
            if (args[2].equalsIgnoreCase("stop")) {
                LiteTrolling.getTrollingManager().removeTrolling(target, TrollingType.DAMAGE);
                sender.sendMessage("Применена функция троллинга damage stop на игрока " + target.getName());
                return true;
            }
            try {
                double val = Double.parseDouble(args[2]);
                if (val <= 1.0) {
                    LiteTrolling.getTrollingManager().removeTrolling(target, TrollingType.DAMAGE);
                    sender.sendMessage("Применена функция троллинга damage stop на игрока " + target.getName());
                } else {
                    LiteTrolling.getTrollingManager().addDamageTrolling(target, val);
                    sender.sendMessage("Применена функция троллинга damage " + val + " на игрока " + target.getName());
                }
            } catch (NumberFormatException ignored) {}
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String lbl, String[] args) {
        List<String> result = new ArrayList<>();
        if (!sender.hasPermission("litetrolling.admin")) return result;
        if (args.length == 1) {
            Bukkit.getOnlinePlayers().forEach(p -> result.add(p.getName()));
        } else if (args.length == 2) {
            result.add("lags");
            result.add("damage");
        } else if (args.length == 3 && args[1].equalsIgnoreCase("damage")) {
            result.add("stop");
            result.add("2.0");
            result.add("3.0");
        } else if (args.length == 3 && args[1].equalsIgnoreCase("lags")) {
            result.add("stop");
        }
        return result;
    }
}
