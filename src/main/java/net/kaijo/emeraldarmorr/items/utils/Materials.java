package net.kaijo.emeraldarmorr.items.utils;

import net.kaijo.emeraldarmorr.EmeraldGear;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Map;

public class Materials {
    private static final RegistryEntry<SoundEvent> ARMOR_EQUIP_SOUND = Registries.SOUND_EVENT.getEntry(SoundEvent.of(ArmorEquipSound.ARMOR_EQUIP_SOUND_ID));

    private static final RegistryKey<EquipmentAsset> ASSET_KEY =
            RegistryKey.of(
                    EquipmentAssetKeys.REGISTRY_KEY,
                    Identifier.of(EmeraldGear.MOD_ID, "emerald")
            );

    public static final ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
            500,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 6,
                    EquipmentType.LEGGINGS, 5,
                    EquipmentType.BOOTS, 2
            ),
            15,
            ARMOR_EQUIP_SOUND,
            0.0F,
            0.0F,
            TagKey.of(
                    Registries.ITEM.getKey(),
                    Identifier.of(EmeraldGear.MOD_ID, "repairs_emerald_armor")
            ),
            ASSET_KEY
    );

    public static final ArmorMaterial ARMOR_CHESTPLATE_MATERIAL = new ArmorMaterial(
            500,
            Map.of(
                    EquipmentType.HELMET, 0,
                    EquipmentType.CHESTPLATE, 5,
                    EquipmentType.LEGGINGS, 0,
                    EquipmentType.BOOTS, 0
            ),
            15,
            ARMOR_EQUIP_SOUND,
            1.0F,
            0.0F,
            TagKey.of(
                    Registries.ITEM.getKey(),
                    Identifier.of(EmeraldGear.MOD_ID, "repairs_emerald_armor")
            ),
            ASSET_KEY
    );

    public static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            300,
            7F,
            2.0F,
            15,
            TagKey.of(
                    Registries.ITEM.getKey(),
                    Identifier.of(EmeraldGear.MOD_ID, "repairs_emerald_tool")
            )

    );

    public static final ArmorMaterial MOB_ARMOR_MATERIAL = new ArmorMaterial(
            0,
            Map.of(
                    EquipmentType.HELMET, 0,
                    EquipmentType.CHESTPLATE, 0,
                    EquipmentType.LEGGINGS, 0,
                    EquipmentType.BOOTS, 0,
                    EquipmentType.BODY, 9
            ),
            0,
            ARMOR_EQUIP_SOUND,
            1,
            0,
            TagKey.of(
                    Registries.ITEM.getKey(),
                    Identifier.of(EmeraldGear.MOD_ID,"repairs_emerald_armor"
                    )
            ),
            ASSET_KEY
    );
}