package net.fabricmc.example.FOLDER_PURPLE_APPLE.CustomItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;


public class PurpleApple extends Item {
    // mecionando o grupo do item
    public PurpleApple() {
        super(new Settings().group(ItemGroup.FOOD));
    }

    // extanciando o item da class
    public static final Item PURPLE_APPLE = new PurpleApple();
    //extanciando o identificador do item
    public static final Identifier PURPLE_APPLE_ID = new Identifier("purple", "purple_apple");

}