package net.kaijo.emeraldarmorr;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import java.nio.file.Path;

public class Config {
    public static CommentedFileConfig CONFIG;

    public static void load(Path configDir) {
        Path path = configDir.resolve("emeraldgear.toml");

        CONFIG = CommentedFileConfig.builder(path)
                .autosave()
                .autoreload()
                .build();

        CONFIG.load();

        CONFIG.add("settings.enableVillagerDiscounts", true);
        CONFIG.setComment("settings.enableVillagerDiscounts", "Experimental");

        CONFIG.save();
    }
}