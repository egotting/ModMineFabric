package net.fabricmc.example.mixin;

import net.fabricmc.example.ITEMS.FOLDER_START_BOOK.StartBook;
import net.fabricmc.example.views.SenderMessagesPlayer;
import net.fabricmc.example.views.SenderMessagesToPlayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.Item;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.fabricmc.example.consts.CommandsMessages.DONT_GIVE_THE_BOOK_QUESTS;

/**
 * @author Dridev
 * This mixin is responsible for canceling the drop event when the cursor selects the start book item
 */

@Mixin(HandledScreen.class)
public class NoDropStartBookItemInCursorMixin {
    private static final Item START_BOOK_ITEM = StartBook.START_BOOK;
    private boolean isStartBookItem = false;
    private SenderMessagesPlayer senderMessagesToPlayer = new SenderMessagesToPlayer();
    @Inject(method = "onMouseClick(Lnet/minecraft/screen/slot/Slot;IILnet/minecraft/screen/slot/SlotActionType;)V",
            at = @At("HEAD"),
            cancellable = true)

    public void cancelOnMouseClick(Slot slot, int slotId, int button, SlotActionType actionType, CallbackInfo ci) {
        if (slot == null && isStartBookItem) { // if the cursor is out inventory and your selected item is the StartBook, then the drop event is cancelled
            ci.cancel();
            // You can to use 'sendToChat' of senderMessageToPlayer if you prefer
            this.senderMessagesToPlayer.sendToScreen(DONT_GIVE_THE_BOOK_QUESTS, (client -> client.player));
            return;
        }
        // This gets the item of cursor selected and verify if is Start Book item
        if (slot != null && actionType == SlotActionType.PICKUP && slot.getStack().getItem().equals(START_BOOK_ITEM)) {
            this.isStartBookItem = true;
        }
    }
}
