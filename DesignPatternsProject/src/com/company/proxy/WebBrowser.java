package com.company.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Proxy design pattern (structural):
 * first go through ProxyWebBrowser that checks if the
 * student is allowed to go to the specified website.
 */
public interface WebBrowser {
    List<String> allowedURLs = new ArrayList<>(Arrays.asList("www.wikipedia.com", "www.github.com", "www.w3schools.com"));

    void goToWebsite(String url) throws Exception;
}
