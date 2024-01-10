package net.fabricmc.example.ITEMS.FOLDER_START_BOOK;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class StartBook extends Item {
    public StartBook() {
        super(new Settings().group(ItemGroup.MISC));
    }

    public static final Item START_BOOK = new StartBook();

    public static final Identifier ID_START_BOOK = new Identifier("purple","start_book");


}
