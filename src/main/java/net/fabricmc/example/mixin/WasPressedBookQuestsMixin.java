package net.fabricmc.example.mixin;

import net.fabricmc.example.ITEMS.FOLDER_START_BOOK.StartBook;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftClient.class)
 // The purpose of this class is to cancel the event of dropping item when the current item from the player's hand is book quests
public class WasPressedBookQuestsMixin {

    @Redirect(method = "handleInputEvents",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;wasPressed()Z",
                    ordinal = 7))
    public boolean disableDropKey(KeyBinding binding) {
        ItemStack itemInHand = getItemInHand();
        if (itemInHand != null && itemInHand.getItem() == StartBook.START_BOOK) {
            assert MinecraftClient.getInstance().player != null;
            return false; // the item don't will be dropped
        }
        return binding.wasPressed();
    }

    private ItemStack getItemInHand() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player != null) {
            return  minecraftClient.player.getMainHandStack(); //Get the item from the player hand
        }
        return ItemStack.EMPTY;
    }

}
