package net.kaijo.emeraldarmorr.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaijo.emeraldarmorr.EmeraldGear;
import net.kaijo.emeraldarmorr.items.utils.Materials;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public final class Armor {

    public static Item EMERALD_HELMET;
    public static Item EMERALD_CHESTPLATE;
    public static Item EMERALD_LEGGINGS;
    public static Item EMERALD_BOOTS;
    public static Item EMERALD_NAUTILUS_ARMOR;
    public static Item EMERALD_HORSE_ARMOR;


    public static void register() {
        EMERALD_BOOTS = registerArmor("emerald_boots", EquipmentType.BOOTS);
        EMERALD_LEGGINGS = registerArmor("emerald_leggings", EquipmentType.LEGGINGS);
        EMERALD_CHESTPLATE = registerArmor("emerald_chestplate", EquipmentType.CHESTPLATE);
        EMERALD_HELMET = registerArmor("emerald_helmet", EquipmentType.HELMET);
        EMERALD_NAUTILUS_ARMOR = registerArmor("emerald_nautilus_armor", null);
        EMERALD_HORSE_ARMOR = registerArmor("emerald_horse_armor", null);
    }

    private static Item registerArmor(String identifier, EquipmentType type) {
        Identifier id = Identifier.of(EmeraldGear.MOD_ID, identifier);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        switch (identifier) {
            case "emerald_helmet" -> {
                Item item = new Item(
                        new Item.Settings()
                                .registryKey(key)
                                .armor(Materials.ARMOR_MATERIAL, type)
                                .repairable(Items.EMERALD)
                                .maxDamage(234)
                );
                addToInventory(item, identifier);
                return Registry.register(Registries.ITEM, id, item);
            }
            case "emerald_chestplate" -> {
                Item item = new Item(
                        new Item.Settings()
                                .registryKey(key)
                                .armor(Materials.ARMOR_CHESTPLATE_MATERIAL, type)
                                .repairable(Items.EMERALD)
                                .maxDamage(328)
                );
                addToInventory(item, identifier);
                return Registry.register(Registries.ITEM, id, item);
            }
            case "emerald_leggings" -> {
                Item item = new Item(
                        new Item.Settings()
                                .registryKey(key)
                                .armor(Materials.ARMOR_MATERIAL, type)
                                .repairable(Items.EMERALD)
                                .maxDamage(316)
                );
                addToInventory(item, identifier);
                return Registry.register(Registries.ITEM, id, item);
            }
            case "emerald_boots" -> {
                Item item = new Item(
                        new Item.Settings()
                                .registryKey(key)
                                .armor(Materials.ARMOR_MATERIAL, type)
                                .repairable(Items.EMERALD)
                                .maxDamage(264)
                );
                addToInventory(item, identifier);
                return Registry.register(Registries.ITEM, id, item);
            }
            case "emerald_nautilus_armor" -> {
                Item item = new Item(new Item.Settings()
                        .registryKey(key)
                        .nautilusArmor(Materials.MOB_ARMOR_MATERIAL)
                );
                addToInventory(item, identifier);
                return Registry.register(Registries.ITEM, id, item);
            }
            case "emerald_horse_armor" -> {
                Item item = new Item(new Item.Settings()
                        .registryKey(key)
                        .horseArmor(Materials.MOB_ARMOR_MATERIAL)
                );
                addToInventory(item, identifier);
                return Registry.register(Registries.ITEM, id, item);
            }
            default -> {
                return null;
            }
        }
    }

    private static void addToInventory(Item item, String identifier) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            switch (identifier){
                case "emerald_helmet", "emerald_chestplate", "emerald_leggings", "emerald_boots" -> entries.addAfter(Items.GOLDEN_HELMET, item);
                case "emerald_horse_armor" -> entries.addAfter(Items.GOLDEN_HORSE_ARMOR, item);
                case "emerald_nautilus_armor" -> entries.addAfter(Items.GOLDEN_NAUTILUS_ARMOR, item);

                default -> entries.add(item);
            }
        });
    }
}
