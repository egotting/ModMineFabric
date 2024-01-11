package net.fabricmc.example.ITEMS.FOLDER_PURPLE_APPLE;

import net.fabricmc.example.ITEMS.CUSTOM_ITEMS_GROUP.FoodGroup;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;


public class PurpleApple extends Item {
    // mecionando o grupo do item
    public PurpleApple() {
        super(new Settings().group(FoodGroup.FOOD_GROUP_ITEM).food(new FoodComponent.Builder().alwaysEdible().build()));
    }

    // extanciando o item da class
    public static final Item PURPLE_APPLE = new PurpleApple();
    //extanciando o identificador do item
    public static final Identifier PURPLE_APPLE_ID = new Identifier("purple", "purple_apple");

}