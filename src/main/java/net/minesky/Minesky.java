package net.minesky;

import net.fabricmc.api.ModInitializer;

import static net.minecraft.server.command.CommandManager.*;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class Minesky implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("foo")
        .executes(context -> {
      // For versions below 1.19, replace "Text.literal" with "new LiteralText".
      // For versions below 1.20, remode "() ->" directly.
      context.getSource().sendFeedback(() -> Text.literal("Called /foo with no arguments"), false);
 
      return 1;
    })));
    }
}
