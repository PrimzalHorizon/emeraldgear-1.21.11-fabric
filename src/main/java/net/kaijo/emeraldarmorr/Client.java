package net.kaijo.emeraldarmorr;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import org.slf4j.Logger;

public class Client implements ClientModInitializer {
    public static String PREFIX = EmeraldGear.PREFIX;
    public static Logger LOGGER = EmeraldGear.LOGGER;


    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            registerCommand(dispatcher);
        });
        LOGGER.info(PREFIX + " Mod Initialized");
    }

    private static void registerCommand(CommandDispatcher<FabricClientCommandSource> dispatcher){
        dispatcher.register(ClientCommandManager.literal("emeraldgear")
                .then(ClientCommandManager.argument("setting", StringArgumentType.word())
                        .suggests(settings)
                        .then(ClientCommandManager.argument("option",StringArgumentType.word())
                                .suggests(bool)
                                .executes((context) -> {
                                    String setting = StringArgumentType.getString(context,"setting");
                                    String option = StringArgumentType.getString(context,"option");

                                    switch (setting){
                                        case "villagerDiscounts" -> {
                                            if(option.equals("false")){
                                                Config.CONFIG.set("settings.enableVillagerDiscounts", false);
                                                context.getSource().sendFeedback(Text.literal("Villager discount: " + option));
                                                return Command.SINGLE_SUCCESS;
                                            } else if (option.equals("true")) {
                                                Config.CONFIG.set("settings.enableVillagerDiscounts", true);
                                                context.getSource().sendFeedback(Text.literal("Villager discount: " + option));
                                                return Command.SINGLE_SUCCESS;
                                            }
                                            context.getSource().sendError(Text.literal("Unknown option " + option + " for " + setting));
                                            return 0;
                                        }
                                        default -> {
                                            context.getSource().sendError(Text.literal("Unknown setting: " + setting));
                                            return 0;
                                        }
                                    }
                                })))
        );
    }

    private static final SuggestionProvider<FabricClientCommandSource> bool = ((context, builder) -> {
        builder.suggest("true");
        builder.suggest("false");
        return builder.buildFuture();
    });

    private static final SuggestionProvider<FabricClientCommandSource> settings = ((context, builder) -> {
        builder.suggest("villagerDiscounts");
        return builder.buildFuture();
    });
}
