package net.fabricmc.example.interfaces;


import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

@FunctionalInterface
public interface PlayerFunction {
    PlayerEntity getPlayer(MinecraftClient client);
}
