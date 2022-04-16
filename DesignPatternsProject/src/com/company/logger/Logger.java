package com.company.logger;

import java.io.*;

/**
 * Singleton design pattern (creational)
 */
public class Logger {
    private static OutputStream os;

    private static void initOS() {
        try {
            os = new FileOutputStream(new File("D:\\fac\\sem6\\dp\\DesignPatternsProject\\src\\com\\company\\logger\\sessionlog.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void log(String data) {
        if (os == null)
            initOS();
        try {
            data += "\n";
            Logger.os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //try {
                //os.close();
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
        }
    }
}
