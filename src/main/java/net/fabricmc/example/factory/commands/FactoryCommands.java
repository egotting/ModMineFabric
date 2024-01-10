package net.fabricmc.example.factory.commands;

<<<<<<< HEAD
<<<<<<< HEAD
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

public interface FactoryCommands {
    void createCommandBasicCommandNoArguments(String nameCommand);

    void createCommandCommandNoArguments(String nameCommand, CommandDispatcher<ServerCommandSource> dispatcher);
=======
import net.fabricmc.example.commands.Commands;

public interface FactoryCommands {
    void createBasicCommandNoArguments(String nameCommand);
    void createCommandWithFunctionArgument(String nameComamnd, Commands commands, Runnable function);

>>>>>>> dri_branch
=======
import net.fabricmc.example.commands.Commands;

public interface FactoryCommands {
    void createBasicCommandNoArguments(String nameCommand);
    void createCommandWithFunctionArgument(String nameComamnd, Commands commands, Runnable function);

>>>>>>> dri_branch
}
