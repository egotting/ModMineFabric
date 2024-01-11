package net.fabricmc.example.commands;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandException;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

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
            try {
                final ServerPlayerEntity self = this.getCommandSource().getPlayer();
                ItemStack book = new ItemStack(Items.BOOK);
                if (!self.getInventory().insertStack(book)) {
                    throw new CommandException(new TranslatableText("commands.giveBookQuest.isfull")); //  If is inventory of player full
                }
                this.getCommandSource().sendFeedback(new TranslatableText("commands.giveBookQuest.success", self.getDisplayName()), true);
            } catch (CommandSyntaxException e) {
                throw new CommandException(new LiteralText(e.getMessage()));
            }
        };
    }


    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}