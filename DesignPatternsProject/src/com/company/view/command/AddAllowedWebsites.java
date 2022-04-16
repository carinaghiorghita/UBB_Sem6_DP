package com.company.view.command;

import com.company.proxy.WebBrowser;
import com.company.strategy.ManualSorter;
import com.company.strategy.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAllowedWebsites extends Command {
    public AddAllowedWebsites(String key, String description) {
        super(key, description);
    }

    @Override
    public void execute() {
        System.out.println("Input websites or \"stop\" to exit:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String url = scanner.nextLine();
        List<String> urls = new ArrayList<>();
        do {
            urls.add(url);
            System.out.print("> ");
            url = scanner.nextLine();
        } while (!url.equals("stop"));

        Sorter sorter = new ManualSorter();
        sorter.sort(urls);
        System.out.println("New allowed websites: " + urls);

        WebBrowser.allowedURLs.addAll(urls);
    }
}
