package net.kaijo.emeraldarmorr.items.utils;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.kaijo.emeraldarmorr.items.Armor;
import net.kaijo.emeraldarmorr.items.Tools;
import net.kaijo.emeraldarmorr.items.Weapons;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class AddToLootTables {
    private static final Item EMERALD_HELMET = Armor.EMERALD_HELMET;
    private static final Item EMERALD_CHESTPLATE = Armor.EMERALD_CHESTPLATE;
    private static final Item EMERALD_LEGGINGS = Armor.EMERALD_LEGGINGS;
    private static final Item EMERALD_BOOTS = Armor.EMERALD_BOOTS;
    private static final Item EMERALD_NAUTILUS_ARMOR = Armor.EMERALD_NAUTILUS_ARMOR;
    private static final Item EMERALD_HORSE_ARMOR = Armor.EMERALD_HORSE_ARMOR;

    private static final Item EMERALD_SWORD = Weapons.EMERALD_SWORD ;
    private static final Item EMERALD_SPEAR = Weapons.EMERALD_SPEAR ;

    private static final Item EMERALD_PICKAXE = Tools.EMERALD_PICKAXE;
    private static final Item EMERALD_SHOVEL = Tools.EMERALD_SHOVEL;

    public static void init(){
        LootTableEvents.MODIFY.register((key, builder, source, lookup) -> {
            if(!source.isBuiltin()) return;

            if(key.equals(LootTables.VILLAGE_ARMORER_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                );
            }

            if(key.equals(LootTables.VILLAGE_WEAPONSMITH_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.18f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.15f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.16f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.17f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.15f)))
                        .with(ItemEntry.builder(EMERALD_SWORD)
                                .conditionally(RandomChanceLootCondition.builder(0.15f)))
                        .with(ItemEntry.builder(EMERALD_PICKAXE)
                                .conditionally(RandomChanceLootCondition.builder(0.16f)))
                        .with(ItemEntry.builder(EMERALD_SPEAR)
                                .conditionally(RandomChanceLootCondition.builder(0.17f)))
                );
            }

            if(key.equals(LootTables.VILLAGE_TOOLSMITH_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .with(ItemEntry.builder(EMERALD_SHOVEL)
                                .conditionally(RandomChanceLootCondition.builder(0.15f)))
                        .with(ItemEntry.builder(EMERALD_PICKAXE)
                                .conditionally(RandomChanceLootCondition.builder(0.15f)))
                );
            }

            if(key.equals(LootTables.VILLAGE_SNOWY_HOUSE_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.05f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.06f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.07f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.04f)))
                );
            }


            if(key.equals(LootTables.VILLAGE_TAIGA_HOUSE_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.11f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.10f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.03f)))
                );
            }

            if(key.equals(LootTables.VILLAGE_PLAINS_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.12f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.10f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.11f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                );
            }

            if(key.equals(LootTables.VILLAGE_SAVANNA_HOUSE_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.10f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.07f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                );
            }

            if(key.equals(LootTables.VILLAGE_DESERT_HOUSE_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.06f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.07f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.05f)))
                );
            }

            if(key.equals(LootTables.DESERT_PYRAMID_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.06f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                        .with(ItemEntry.builder(EMERALD_NAUTILUS_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.07f)))
                );
            }

            if(key.equals(LootTables.JUNGLE_TEMPLE_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.18f)))
                );
            }

            if(key.equals(LootTables.BURIED_TREASURE_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_NAUTILUS_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.10f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                );
            }

            if(key.equals(LootTables.UNDERWATER_RUIN_SMALL_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_NAUTILUS_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.04f)))
                );
            }

            if(key.equals(LootTables.UNDERWATER_RUIN_BIG_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_NAUTILUS_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.04f)))
                );
            }

            if(key.equals(LootTables.SHIPWRECK_TREASURE_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_NAUTILUS_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.13f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.07f)))
                );
            }

            if(key.equals(LootTables.SHIPWRECK_SUPPLY_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_NAUTILUS_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.06f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.02f)))
                );
            }

            if(key.equals(LootTables.ANCIENT_CITY_CHEST)) {
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.15f))
                                .apply(EnchantWithLevelsLootFunction.builder(lookup, UniformLootNumberProvider.create(29, 30))))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.07f)))
                );
            }

            if(key.equals(LootTables.STRONGHOLD_CORRIDOR_CHEST)){
                builder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(EMERALD_HELMET)
                                .conditionally(RandomChanceLootCondition.builder(0.11f)))
                        .with(ItemEntry.builder(EMERALD_CHESTPLATE)
                                .conditionally(RandomChanceLootCondition.builder(0.08f)))
                        .with(ItemEntry.builder(EMERALD_LEGGINGS)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                        .with(ItemEntry.builder(EMERALD_BOOTS)
                                .conditionally(RandomChanceLootCondition.builder(0.10f)))
                        .with(ItemEntry.builder(EMERALD_HORSE_ARMOR)
                                .conditionally(RandomChanceLootCondition.builder(0.09f)))
                        .with(ItemEntry.builder(EMERALD_PICKAXE)
                                .conditionally(RandomChanceLootCondition.builder(0.10f)))
                        .with(ItemEntry.builder(EMERALD_SWORD)
                                .conditionally(RandomChanceLootCondition.builder(0.11f)))
                );
            }
        });
    }
}
