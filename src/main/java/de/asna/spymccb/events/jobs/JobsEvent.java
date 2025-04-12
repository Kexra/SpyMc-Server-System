package de.asna.spymccb.events.jobs;

import de.asna.spymccb.gui.JobGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class JobsEvent implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory == null) return;
        if (clickedInventory.getHolder() instanceof JobGUI) {
            event.setCancelled(true);
            ((JobGUI) clickedInventory.getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }
    }

}
