package net.fabricmc.example.ITEMS.FOLDER_START_BOOK;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenBookScreenHandler extends ScreenHandler
{
    public ScreenBookScreenHandler(int syncId, PlayerInventory playerInventory)
    {
        this(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    protected  ScreenBookScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context)
    {
        super(type, syncId);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}