package io.github.rypofalem.armorstandeditor.menu;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class ASEMenuTracker {

    private static final Map<InventoryView, ASEMenuType> menuMap = new ConcurrentHashMap<>();

    public static InventoryView open(Player player, Inventory inventory, ASEMenuType type) {
        InventoryView view = player.openInventory(inventory);
        menuMap.put(view, type);
        return view;
    }

    public static ASEMenuType getMenuType(InventoryView view) {
        return menuMap.get(view);
    }

    public static void close(InventoryView view) {
        menuMap.remove(view);
    }
}
