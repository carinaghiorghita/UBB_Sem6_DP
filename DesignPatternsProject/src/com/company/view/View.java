package com.company.view;

import com.company.view.command.Command;
import com.company.view.command.VisitWebsiteCommand;
import com.company.view.command.AddAllowedWebsites;
import com.company.view.command.ExitCommand;
import com.company.view.command.SeeAllowedWebsites;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private Map<String, Command> commands = new HashMap<>();

    private void addCommand(Command c) {
        this.commands.put(c.getKey(), c);
    }

    private void fillCommandsMap() {
        this.addCommand(new ExitCommand("0", "Exit"));
        this.addCommand(new VisitWebsiteCommand("1", "Visit website"));
        this.addCommand(new SeeAllowedWebsites("2", "See allowed websites"));
        this.addCommand(new AddAllowedWebsites("3", "Add allowed websites"));
    }

    public View() {
        this.fillCommandsMap();
    }

    private void printMenu() {
        commands.values().stream()
                .sorted((com1, com2) -> {
                    Integer aux = Integer.parseInt(com1.getKey());
                    return aux.compareTo(Integer.parseInt(com2.getKey()));
                })
                .forEach((com) -> {
                    String line = String.format("%3s : %s", com.getKey(), com.getDescription());
                    System.out.println(line);
                });

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.println("Input the option: ");
            String key = scanner.nextLine();
            Command com = commands.get(key);
            if (com == null){
                System.out.println("Invalid Option");
                continue;
            }
            try {
                com.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
