package net.fabricmc.example.factory.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.example.consts.CommandsMessages.COMMAND_SUCCESSFULLY_MESSAGE;
import static net.minecraft.server.command.CommandManager.literal;
public class FactoryCommandsImpl implements FactoryCommands{
    @Override
    public void createCommandBasicCommandNoArguments(String nameCommand) {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> dispatcher.register(literal(nameCommand)
                .executes(context -> {
                    context.getSource().sendFeedback(Text.of(COMMAND_SUCCESSFULLY_MESSAGE), false);
                    return 1;
                }))));
    }

    @Override
    public void createCommandCommandNoArguments(String nameCommand,  CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> builder = literal(nameCommand)
                .executes(ctx -> {
                    giveDiamond(ctx);
                    return 1;
                });
        dispatcher.register(builder);


    }

    public static int giveDiamond(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        final ServerCommandSource source = ctx.getSource();
        final PlayerEntity self = source.getPlayer();
        ItemStack diamond = new ItemStack(Items.DIAMOND, 1);
        PlayerInventory inventory = self.getInventory();
        inventory.addPickBlock(diamond);
        return 1;
    }


}

