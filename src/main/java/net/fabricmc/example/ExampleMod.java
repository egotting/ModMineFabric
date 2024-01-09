package net.fabricmc.example;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.commands.Commands;
import net.fabricmc.example.factory.commands.FactoryCommands;
import net.fabricmc.example.factory.commands.FactoryCommandsImpl;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.fabricmc.example.FOLDER_PURPLE_APPLE.CustomItems.PurpleApple.PURPLE_APPLE;
import static net.fabricmc.example.FOLDER_PURPLE_APPLE.CustomItems.PurpleApple.PURPLE_APPLE_ID;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("modid");


	@Override
	public void onInitialize() {

		FactoryCommands factoryCommands = new FactoryCommandsImpl();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			dispatcher.register(
					LiteralArgumentBuilder.<ServerCommandSource>literal("start")
							.executes(Commands::giveBookQuests)
			);
		});
        //Registrando o item
		BuiltinRegistries.add(Registry.ITEM, PURPLE_APPLE_ID, PURPLE_APPLE);
		// menssagem ao entrar no jogo
		LOGGER.info("Hi, my name is Ego and i`am the creator of this mod, i hope that u have fun 😘 !");
	}
}
