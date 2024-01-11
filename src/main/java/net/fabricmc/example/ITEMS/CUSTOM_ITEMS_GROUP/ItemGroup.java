package net.fabricmc.example.ITEMS.CUSTOM_ITEMS_GROUP;

import net.fabricmc.example.ITEMS.FOLDER_START_BOOK.StartBook;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroup {
    // Registrando a aba para items no geral

    public static final net.minecraft.item.ItemGroup ITEM_CUSTOM_GROUP = FabricItemGroupBuilder.build(new Identifier("purple","start_book"),
            () -> new ItemStack(StartBook.START_BOOK));
}
