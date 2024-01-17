package net.fabricmc.example.views;

import net.fabricmc.example.interfaces.PlayerFunction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class SenderMessagesToPlayer  implements  SenderMessagesPlayer {


    private Text message;


    public SenderMessagesToPlayer() {}


    public SenderMessagesToPlayer(Text message) {
        this.message = message;
    }


    public void setMessage(Text message) {
        this.message = message;
    }

    @Override
    public boolean sendToChat(Text message, PlayerFunction function) {
        PlayerEntity player = getPlayer(function);
        player.sendMessage(message, false);
        return true;
    }

    @Override
    public boolean sendToScreen(Text message, PlayerFunction function) {
        PlayerEntity player = getPlayer(function);
        player.sendMessage(message, true);
        return true;
    }

    private PlayerEntity getPlayer(PlayerFunction function) {
        MinecraftClient client = MinecraftClient.getInstance();
        return function.getPlayer(client);
    }
}
