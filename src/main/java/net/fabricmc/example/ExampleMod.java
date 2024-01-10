package net.fabricmc.example;

<<<<<<< HEAD
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
=======
>>>>>>> dri_branch
import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.commands.Commands;
import net.fabricmc.example.factory.commands.FactoryCommands;
import net.fabricmc.example.factory.commands.FactoryCommandsImpl;
<<<<<<< HEAD
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;
=======
>>>>>>> dri_branch
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
<<<<<<< HEAD
		factoryCommands.createCommandBasicCommandNoArguments("Carlos");
		CommandDispatcher<ServerCommandSource> dispatcher = new CommandDispatcher<>(); // Cria um dispatcher de comandos
		factoryCommands.createCommandCommandNoArguments("diamante", dispatcher);
		//Registrando o item
=======
		Commands commands = new Commands();
		factoryCommands.createCommandWithFunctionArgument("start", commands, commands.giveBookQuests());
        //Registrando o item
>>>>>>> dri_branch
		BuiltinRegistries.add(Registry.ITEM, PURPLE_APPLE_ID, PURPLE_APPLE);
		// menssagem ao entrar no jogo
		LOGGER.info("Hi, my name is Ego and i`am the creator of this mod, i hope that u have fun 😘 !");

	}
}
