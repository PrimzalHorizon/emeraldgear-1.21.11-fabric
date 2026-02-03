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

public class Tools {
    public static Item emerald_shovel;
    public static Item emerald_pickaxe;
    public static Item emerald_axe;
    public static Item emerald_hoe;

    public static void register(){
        emerald_hoe = registerTool("emerald_hoe");
        emerald_axe = registerTool("emerald_axe");
        emerald_pickaxe = registerTool("emerald_pickaxe");
        emerald_shovel = registerTool("emerald_shovel");
    }

    private static Item registerTool(String identifier) {
        Identifier id = Identifier.of(EmeraldGear.MOD_ID, identifier);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        switch (identifier) {
            case "emerald_pickaxe" -> {
                Item tool = new Item(new Item.Settings()
                        .registryKey(key)
                        .pickaxe(Materials.TOOL_MATERIAL, 3.5F, -2.8F)
                        .repairable(Items.EMERALD)
                        .maxCount(1)
                        .maxDamage(784) // Durability

                );
                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            case "emerald_shovel" -> {
                Item tool = new Item(new Item.Settings()
                        .registryKey(key)
                        .shovel(Materials.TOOL_MATERIAL, 3.8F, -3.0F)
                        .repairable(Items.EMERALD)
                        .maxCount(1)
                        .maxDamage(624) // Durability
                );

                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            case "emerald_hoe" -> {
                Item tool = new Item(new Item.Settings()
                        .registryKey(key)
                        .hoe(Materials.TOOL_MATERIAL, 0.0F, -0.5F)
                        .repairable(Items.EMERALD)
                        .maxCount(1)
                        .maxDamage(541) // Durability
                );

                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            case "emerald_axe" -> {
                Item tool = new Item(new Item.Settings()
                        .registryKey(key)
                        .axe(Materials.TOOL_MATERIAL,8.0F, -3.1F)
                        .repairable(Items.EMERALD)
                        .maxDamage(1)
                        .maxDamage(753)
                );
                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            default -> {
                return null;
            }
        }
    }


    private static void addToInventory(Item item){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.GOLDEN_HOE, item);
        });
    }
}
