package net.fabricmc.example.factory.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

public interface FactoryCommands {
    void createCommandBasicCommandNoArguments(String nameCommand);

    void createCommandCommandNoArguments(String nameCommand, CommandDispatcher<ServerCommandSource> dispatcher);
}
