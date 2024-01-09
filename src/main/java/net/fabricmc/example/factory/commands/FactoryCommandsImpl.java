package net.fabricmc.example.factory.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.example.consts.CommandsMessages.COMMAND_SUCCESSFULLY_MESSAGE;
import static net.minecraft.server.command.CommandManager.literal;
public class FactoryCommandsImpl implements FactoryCommands{

    private CommandDispatcher<ServerCommandSource> dispatcher; // Variável de instância para o dispatcher

    @Override
    public void createCommandNoArguments(String nameCommand) {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> dispatcher.register(literal(nameCommand)
                .executes(context -> {
                    context.getSource().sendFeedback(Text.of(COMMAND_SUCCESSFULLY_MESSAGE), false);
                    return 1;
                }))));
    }

    @Override
    public void createCommandNoArguments(String nameCommand, Runnable function, String messageFeedback) {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> dispatcher.register(literal(nameCommand)
                .executes(context -> {
                    function.run();
                    context.getSource().sendFeedback(Text.of(messageFeedback), false);
                    return 1;
                }))));
    }

    @Override
    public LiteralCommandNode createLiteralCommands(CommandDispatcher<ServerCommandSource> dispatcher, String nameCommand, Runnable command) {
        LiteralArgumentBuilder<ServerCommandSource> commandBuilder = literal(nameCommand)
                .executes(context -> {
                    command.run();
                    return 1; // Return any appropriate value here
                });
        return dispatcher.register(commandBuilder);
    }


}

