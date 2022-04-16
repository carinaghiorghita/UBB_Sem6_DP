package com.company.proxy;

import com.company.logger.Logger;

import java.awt.*;
import java.net.URI;

public class ActualWebBrowser implements WebBrowser {
    @Override
    public void goToWebsite(String url) throws Exception {
        System.out.println("Connected to " + url);
        Logger.log("A student connected to " + url);
        Desktop desk= Desktop.getDesktop();
        desk.browse(new URI(url));
    }
}
