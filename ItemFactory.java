package de.christianbernstein.mcutils.itembuilder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.HashMap;
import java.util.List;

public class ItemFactory {

    public static ItemStack create(String name, List<String> desc, Material material){
        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(desc);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static HashMap<Integer, ItemStack> createCluster(@org.jetbrains.annotations.NotNull List<Integer> targets, Material material){
        HashMap<Integer, ItemStack> output = new HashMap<Integer, ItemStack>();
        for(int i = 1; i <= targets.size() -1; i++){
            ItemStack itemStack = new ItemStack(material, 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("");
            itemStack.setItemMeta(itemMeta);
            output.put(i, itemStack);
        }
        return output;
    }
}
