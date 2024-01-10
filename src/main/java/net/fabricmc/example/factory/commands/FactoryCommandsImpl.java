package net.fabricmc.example.factory.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.example.commands.Commands;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.example.consts.CommandsMessages.COMMAND_SUCCESSFULLY_MESSAGE;
import static net.minecraft.server.command.CommandManager.literal;
public class FactoryCommandsImpl implements FactoryCommands{

    @Override
    public void createBasicCommandNoArguments(String nameCommand) {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> dispatcher.register(literal(nameCommand)
                .executes(context -> {
                    context.getSource().sendFeedback(Text.of(COMMAND_SUCCESSFULLY_MESSAGE), false);
                    return 1;
                }))));
    }

    @Override
    public void createCommandWithFunctionArgument(String nameCommand, Commands commands, Runnable function) {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(
                    LiteralArgumentBuilder.<ServerCommandSource>literal(nameCommand)
                            .executes(context -> {
                                commands.setCommandSource(context.getSource()); //Context of command by player
                                commands.execute(function); // Execute the function of param
                                return 1;
                            })
                     );
        });
    }
}

