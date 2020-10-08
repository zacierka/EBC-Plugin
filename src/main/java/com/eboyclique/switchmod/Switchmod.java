package com.eboyclique.switchmod;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Driver for switchmod plugin. This plugin interfaces with JMS to communicate with EBC Discord Bot (JDA).
 */
@SuppressWarnings("unused")
public final class Switchmod extends JavaPlugin {

    public Switchmod() {
        super();
    }

    /**
     * This function runs when the plugin is started. Here commands, events, custom classes, etc., are initialized.
     * @see #onDisable() onDisable()
     */
    @Override
    public void onEnable() {
        System.out.println("***********************************\n");
        System.out.println("Initializing Switchmod\n");
        System.out.println("***********************************");
    }

    /**
     * Destructor method for when the server crashes, hangs, or gracefully exits.
     * @see #onEnable() onEnable()
     */
    @Override
    public void onDisable() {
        System.out.println("***********************************\n");
        System.out.println("Halting Switchmod\n");
        System.out.println("***********************************");
    }
}
