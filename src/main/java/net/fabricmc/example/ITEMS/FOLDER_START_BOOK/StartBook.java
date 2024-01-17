package net.fabricmc.example.ITEMS.FOLDER_START_BOOK;

import net.fabricmc.example.ITEMS.CUSTOM_ITEMS_GROUP.ItemGroup;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class StartBook extends Item {
    // colocando a classe do item
    public StartBook() {
        super(new Settings().group(ItemGroup.ITEM_CUSTOM_GROUP));
    }

    // Criando o item
    public static final Item START_BOOK = new StartBook();

    // Criando o identificador do item (id)
    public static final Identifier ID_START_BOOK = new Identifier("purple","start_book");


}
