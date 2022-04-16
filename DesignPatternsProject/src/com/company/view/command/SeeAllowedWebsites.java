package com.company.view.command;

import com.company.proxy.WebBrowser;
import com.company.strategy.ManualSorter;
import com.company.strategy.Sorter;

import java.util.List;

public class SeeAllowedWebsites extends Command {
    public SeeAllowedWebsites(String key, String description) {
        super(key, description);
    }

    @Override
    public void execute() {
        List<String> urls = WebBrowser.allowedURLs;
        Sorter sorter = new ManualSorter();
        sorter.sort(urls);
        System.out.println("Allowed websites: " + urls);
    }
}
