package net.fabricmc.example.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandException;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;

public class Commands {


    public static int giveBookQuests(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        final ServerCommandSource source =  ctx.getSource();
        final ServerPlayerEntity self = source.getPlayer();
        ItemStack book = new ItemStack(Items.BOOK);
        if(!self.getInventory().insertStack(book)) {
            throw new CommandException(new TranslatableText("commands.giveBookQuest.isfull"));
        }
        source.sendFeedback(new TranslatableText("commands.giveBookQuest.success", self.getDisplayName()), true);
        return 1;
    }

}
