package net.kaijo.emeraldarmorr.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaijo.emeraldarmorr.EmeraldGear;
import net.kaijo.emeraldarmorr.items.utils.Materials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class Weapons {
    public static Item EMERALD_SWORD;
    public static Item EMERALD_SPEAR;

    public static void register(){
        EMERALD_SWORD = registerWeapons("emerald_sword");
        EMERALD_SPEAR = registerWeapons("emerald_spear");
    }

    private static Item registerWeapons(String identifier){
        Identifier id = Identifier.of(EmeraldGear.MOD_ID, identifier);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        switch (identifier){
            case "emerald_spear" -> {
                Item weapon = new Item(new Item.Settings()
                        .registryKey(key)
                        .spear(Materials.TOOL_MATERIAL, 0.95F, 0.95F, 0.5F, 2.3F, 7.8F, 6.73F, 5.0F, 11.27F, 4.5F)
                        .spear(
                                Materials.TOOL_MATERIAL,
                                0.95F,
                                0.95F,
                                0.6F,
                                2.5F,
                                8.0F,
                                6.61F,
                                4.3F,
                                8.2F,
                                4.3F
                        )
                        .maxDamage(731)
                        .maxCount(1)
                        .repairable(Items.EMERALD)
                );
                Registry.register(Registries.ITEM, id, weapon);
                addToInventory(identifier, weapon);
                return weapon;
            }

            case "emerald_sword" -> {
                Item weapon = new Item(new Item.Settings()
                        .registryKey(key)
                        .sword(Materials.TOOL_MATERIAL,5F,-2.4F)
                        .maxDamage(830)
                        .maxCount(1)
                        .repairable(Items.EMERALD)
                );
                Registry.register(Registries.ITEM, id, weapon);
                addToInventory(identifier, weapon);
                return weapon;
            }

            default -> {
                return null;
            }
        }
    }

    private static void addToInventory(String identifier, Item item){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            switch (identifier){
                case "emerald_spear" -> entries.addAfter(Items.GOLDEN_SPEAR, item);
                case "emerald_sword" -> entries.addAfter(Items.GOLDEN_SWORD, item);
                default -> entries.add(item);

            }
        });
    }
}
