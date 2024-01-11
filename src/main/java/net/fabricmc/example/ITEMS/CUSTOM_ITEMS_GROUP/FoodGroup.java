package net.fabricmc.example.ITEMS.CUSTOM_ITEMS_GROUP;

import net.fabricmc.example.ITEMS.FOLDER_PURPLE_APPLE.PurpleApple;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class FoodGroup {

        // Registrando a aba para items criados direcionados a comida
        public static final ItemGroup FOOD_GROUP_ITEM = FabricItemGroupBuilder.build(new Identifier("purple", "purple_apple"),
                () -> new ItemStack(PurpleApple.PURPLE_APPLE));
}
