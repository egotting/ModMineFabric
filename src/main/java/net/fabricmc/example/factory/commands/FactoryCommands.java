package net.fabricmc.example.factory.commands;

import net.fabricmc.example.commands.Commands;

public interface FactoryCommands {
    void createBasicCommandNoArguments(String nameCommand);
    void createCommandWithFunctionArgument(String nameComamnd, Commands commands, Runnable function);

}
