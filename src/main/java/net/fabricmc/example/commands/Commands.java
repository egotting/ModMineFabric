package net.fabricmc.example.commands;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.example.ITEMS.FOLDER_START_BOOK.StartBook;
import net.fabricmc.example.consts.CommandsMessages;
import net.minecraft.command.CommandException;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class Commands implements Command {

    private ServerCommandSource commandSource;

    public ServerCommandSource getCommandSource() {
        return commandSource;
    }

    public void setCommandSource(ServerCommandSource commandSource) {
        this.commandSource = commandSource;
    }

    public Runnable giveBookQuests() {
        return () -> {
            if (!this.verifyIfPlayerAlreadyGetBookOfQuests(this.getPlayer())) {
                ItemStack book = new ItemStack(StartBook.START_BOOK); // Book start mod
                if (!this.getPlayer().getInventory().insertStack(book)) {
                    throw new CommandException(CommandsMessages.INVENTORY_PLAYER_IS_FULL); //  If is inventory of player full
                }
                this.getCommandSource().sendFeedback(CommandsMessages.COMMAND_BOOK_START, true);
            };
        };
    }

    private boolean verifyIfPlayerAlreadyGetBookOfQuests(PlayerEntity player) {
        if (player.getInventory().contains(StartBook.START_BOOK.getDefaultStack())) {
            this.getCommandSource().sendFeedback(CommandsMessages.BOOK_ALREADY_ON_INVENTORY, false);
           // throw new PlayerAlreadyHaveBookQuests("The player already have the book of quests");
            return true;
        }
        return false;
    }

    private PlayerEntity getPlayer() {
            final ServerPlayerEntity self;
            try {
                self = this.getCommandSource().getPlayer(); //CommandSource return player of command context
            } catch (CommandSyntaxException e) {
                throw new RuntimeException(e); // Custom exception after
            }
            return self;
    }

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}