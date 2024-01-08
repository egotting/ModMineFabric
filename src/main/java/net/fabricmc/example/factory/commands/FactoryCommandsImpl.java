package net.fabricmc.example.factory.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.fabricmc.example.consts.CommandsMessages.COMMAND_SUCCESSFULLY_MESSAGE;
import static net.minecraft.server.command.CommandManager.*;
public class FactoryCommandsImpl implements FactoryCommands{
    @Override
    public boolean createCommandNoArguments(String nameCommand) {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> dispatcher.register(literal(nameCommand)
                .executes(context -> {
                    context.getSource().sendFeedback(Text.of(COMMAND_SUCCESSFULLY_MESSAGE), false);
                    return 1;
                }))));
        return true;
    }
}

