package org.survivalcraft.painlib.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Builds an {@link ItemStack} with {@link ItemMeta}
 */
public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    public ItemBuilder(ItemStack item, int amount) {
        this.item = new ItemStack(item.getType(), amount);
    }

    public ItemBuilder(Material item) {
        this.item = new ItemStack(item);
    }

    public ItemBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(item);
    }

    public ItemBuilder setName(String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addLoreLine(String line) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        if(meta.hasLore()) lore = new ArrayList<>(Objects.requireNonNull(meta.getLore()));

        lore.add(ChatColor.translateAlternateColorCodes('&', line));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder glint() {
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(flags);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(unbreakable);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setSkullOwner(final OfflinePlayer owner) {
        try {
            SkullMeta meta = (SkullMeta)item.getItemMeta();
            meta.setOwningPlayer(owner);
            item.setItemMeta(meta);
        } catch(ClassCastException e) {}
        return this;
    }

    public ItemStack build() {
        return item;
    }
}