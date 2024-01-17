package net.fabricmc.example.ITEMS.FOLDER_START_BOOK;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ScreenBook extends HandledScreen<ScreenBookScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("purple","textures/gui/start_book.png");

    public ScreenBook(ScreenBookScreenHandler handler, PlayerInventory inventory, Text text)
    {
        super(handler,inventory, text);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY)
    {
        renderBackground(matrices);
    }
}
