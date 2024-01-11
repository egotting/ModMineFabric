package net.fabricmc.example.exceptions;

public class PlayerAlreadyHaveBookQuests extends RuntimeException {
    public PlayerAlreadyHaveBookQuests(String s) {
        super(s);
    }
}
