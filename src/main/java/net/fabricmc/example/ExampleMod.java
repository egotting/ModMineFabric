package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.commands.Commands;
import net.fabricmc.example.factory.commands.FactoryCommands;
import net.fabricmc.example.factory.commands.FactoryCommandsImpl;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.fabricmc.example.ITEMS.FOLDER_PURPLE_APPLE.PurpleApple.PURPLE_APPLE;
import static net.fabricmc.example.ITEMS.FOLDER_PURPLE_APPLE.PurpleApple.PURPLE_APPLE_ID;
import static net.fabricmc.example.ITEMS.FOLDER_START_BOOK.StartBook.ID_START_BOOK;
import static net.fabricmc.example.ITEMS.FOLDER_START_BOOK.StartBook.START_BOOK;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("modid");

	@Override
	public void onInitialize() {

		FactoryCommands factoryCommands = new FactoryCommandsImpl();
		Commands commands = new Commands();
		factoryCommands.createCommandWithFunctionArgument("start", commands, commands.giveBookQuests());
		//Registrando o item
		BuiltinRegistries.add(Registry.ITEM, PURPLE_APPLE_ID, PURPLE_APPLE);
		BuiltinRegistries.add(Registry.ITEM,ID_START_BOOK,START_BOOK);
		// menssagem ao entrar no jogo
		LOGGER.info("Hi, my name is Ego and i`am the creator of this mod, i hope that u have fun 😘 !");

	}
}