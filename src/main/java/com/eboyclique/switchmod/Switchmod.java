///////////////////////////////////
// Main class of Switchmod Plugin. This class instantiates most needed variables.
// CLASS: Switchmod
// VERSION: 1.0.0
//
//  PROGRAMMER: Switch
//  OCT 8       Initial Impl
//
///////////////////////////////////
package com.eboyclique.switchmod;

import com.eboyclique.switchmod.rabbit.Producer;
import com.eboyclique.switchmod.rabbit.QueueConsumer;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * Driver for switchmod plugin. This plugin interfaces with JMS to communicate with EBC Discord Bot (JDA).
 */
@SuppressWarnings("unused")
public final class Switchmod extends JavaPlugin {
    public QueueConsumer consumer = null;
    public Thread consumerThread = null;
    public Producer producer = null;
    public Switchmod() {
        super();
        createMQ();
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

    private void createMQ() {
        try {
            consumer = new QueueConsumer("mc");
            consumerThread = new Thread(consumer);
            consumerThread.start();

            producer = new Producer("discord");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
