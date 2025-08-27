package org.survivalcraft.painlib.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;

public class CommandsManager {

    private final JavaPlugin plugin;
    private final HashMap<String, CommandExecutor> executors = new HashMap<>();
    private final HashMap<String, TabCompleter> completers = new HashMap<>();

    public CommandsManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers a {@link CommandExecutor} with the hooked {@link JavaPlugin}
     * @param name The command name. Must match exactly the name defined in the {@code plugin.yml}.
     * @param executor The {@link CommandExecutor} that will be called when the command is executed.
     * @throws IllegalStateException If the command is already registered.
     */
    public void registerCommand(String name, CommandExecutor executor) {
        if(this.executors.containsKey(name)) throw new IllegalStateException("The command '" + name + "' is already registered!");

        this.executors.put(name, executor);
        this.plugin.getCommand(name).setExecutor(executor);
    }

    /**
     * Registers a {@link TabCompleter} with the hooked {@link JavaPlugin}
     * @param commandName The command name. Must match exactly the name defined in the {@code plugin.yml}.
     * @param completer The {@link TabCompleter} that will be called when the command is executed.
     * @throws IllegalStateException If the command is not registered.
     */
    public void registerTabCompleter(String commandName, TabCompleter completer) {
        if(!this.executors.containsKey(commandName)) throw new IllegalStateException("The command '" + commandName + "' is not registered!");

        this.completers.put(commandName, completer);
        this.plugin.getCommand(commandName).setTabCompleter(completer);
    }

    public HashMap<String, CommandExecutor> getExecutors() {
        return executors;
    }

    public HashMap<String, TabCompleter> getCompleters() {
        return completers;
    }
}
