package com.company.view.command;

public class ExitCommand extends Command {
    public ExitCommand(String key, String description) {
        super(key, description);
    }

    @Override
    public void execute() {
        System.out.println("See you next time!");
        System.exit(0);
    }
}
