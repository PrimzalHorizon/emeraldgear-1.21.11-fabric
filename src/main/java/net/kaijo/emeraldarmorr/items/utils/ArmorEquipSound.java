package net.kaijo.emeraldarmorr.items.utils;

import net.kaijo.emeraldarmorr.EmeraldGear;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ArmorEquipSound {

    public static final Identifier ARMOR_EQUIP_SOUND_ID = Identifier.of(EmeraldGear.MOD_ID, "armor.equip_emerald");
    public static final SoundEvent ARMOR_EQUIP_EMERALD = SoundEvent.of(ARMOR_EQUIP_SOUND_ID,1);

    public static void register() {
        Registry.register(
                Registries.SOUND_EVENT,
                ARMOR_EQUIP_SOUND_ID,
                ARMOR_EQUIP_EMERALD
        );
    }
}

