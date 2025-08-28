package org.survivalcraft.painlib.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.survivalcraft.painlib.PainLib;

public abstract class Gui implements Listener {

    private final JavaPlugin plugin = PainLib.getInstance().getPlugin();

    private final Inventory inventory;
    private final Player player;
    private final String name;
    private boolean registered = false;

    public Gui(Player player, String name, int rows) {
        this.inventory = Bukkit.createInventory(null, rows * 9, name);
        this.player = player;
        this.name = name;
    }

    public abstract void drawScreen();

    public void open() {
        player.openInventory(inventory);
        drawScreen();
        onOpen();
        player.updateInventory();

        if(!registered) {
            Bukkit.getPluginManager().registerEvents(this, this.plugin);
            registered = true;
        }
    }

    public void close() {
        onClose();
        HandlerList.unregisterAll(this);
        player.closeInventory();
    }

    public void setItem(int slot, ItemStack stack) {
        inventory.setItem(slot, stack);
    }

    public abstract void onOpen();
    public abstract void onClose();
    public abstract void onClick(int position, ItemStack stack, ClickType type);


    @EventHandler
    public void playerClickInventoryEvent(InventoryClickEvent event) {
        if(event.getClickedInventory() == null) return;
        if(event.getView().getTitle().equals(this.name)) {
            event.setCancelled(true);
            onClick(event.getSlot(), event.getCurrentItem(), event.getClick());
        }
    }

    @EventHandler
    public void onPlayerCloseInventory(InventoryCloseEvent event) {
        if(event.getInventory() == this.inventory) {
            this.onClose();

            if(!GuiManager.isGuiManaged(this.getClass())) {
                HandlerList.unregisterAll(this);
            }
        }
    }

    public Player getPlayer() {
        return player;
    }
}