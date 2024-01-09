package net.fabricmc.example.factory.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;

public interface FactoryCommands {
    void createCommandNoArguments(String nameCommand);
    void createCommandNoArguments(String nameCommand, Runnable function, String messageFeedback);

    LiteralCommandNode createLiteralCommands(CommandDispatcher<ServerCommandSource> dispatcher, String nameCommand, Runnable command);
}
