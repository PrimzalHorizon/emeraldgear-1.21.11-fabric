package net.kaijo.emeraldarmorr;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.kaijo.emeraldarmorr.items.Armor;
import net.kaijo.emeraldarmorr.items.Tools;
import net.kaijo.emeraldarmorr.items.Weapons;
import net.kaijo.emeraldarmorr.items.utils.ArmorEquipSound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmeraldGear implements ModInitializer {
    public static String MOD_ID = "emeraldgear";
    public static String PREFIX = "[Emerald Gear]";
    public static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info(PREFIX + " Mod initializing");
        Config.load(FabricLoader.getInstance().getConfigDir());
        ArmorEquipSound.register();
        Weapons.register();
        Armor.register();
        Tools.register();
    }
}
