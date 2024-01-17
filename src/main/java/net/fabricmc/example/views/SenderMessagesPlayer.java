package net.fabricmc.example.views;

import net.fabricmc.example.interfaces.PlayerFunction;
import net.minecraft.text.Text;

public interface SenderMessagesPlayer {

    boolean sendToChat(Text message, PlayerFunction function);
    boolean sendToScreen(Text message, PlayerFunction function);

}
