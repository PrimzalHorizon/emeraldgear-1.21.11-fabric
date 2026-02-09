package net.kaijo.emeraldarmorr.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaijo.emeraldarmorr.EmeraldGear;
import net.kaijo.emeraldarmorr.items.utils.Materials;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class Tools {
    public static Item EMERALD_PICKAXE;
    public static Item EMERALD_AXE;
    public static Item EMERALD_SHOVEL;
    public static Item EMERALD_HOE;

    public static void register(){
        EMERALD_HOE = registerTool("emerald_hoe");
        EMERALD_AXE = registerTool("emerald_axe");
        EMERALD_PICKAXE = registerTool("emerald_pickaxe");
        EMERALD_SHOVEL = registerTool("emerald_shovel");
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
                        .maxDamage(784)

                );
                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            case "emerald_shovel" -> {
                ShovelItem tool = new ShovelItem(Materials.TOOL_MATERIAL, 3.8F, -3.0F, new Item.Settings()
                        .registryKey(key)
                        .repairable(Items.EMERALD)
                        .maxCount(1)
                        .maxDamage(624)
                );

                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            case "emerald_hoe" -> {
                HoeItem tool = new HoeItem(Materials.TOOL_MATERIAL, 0.0F, -0.5F, new Item.Settings()
                        .registryKey(key)
                        .repairable(Items.EMERALD)
                        .maxCount(1)
                        .maxDamage(541)
                );

                addToInventory(tool);
                return Registry.register(Registries.ITEM, id, tool);
            }

            case "emerald_axe" -> {
                AxeItem tool = new AxeItem(Materials.TOOL_MATERIAL, 8.0F, -3.1F, new Item.Settings()
                        .registryKey(key)
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.GOLDEN_HOE, item));
    }
}
