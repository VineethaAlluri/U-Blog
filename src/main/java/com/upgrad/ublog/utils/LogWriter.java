package com.upgrad.ublog.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO: 8.1. Implement writeLog() method with the following method signature.
 *  public static void writeLog(String logMessage, String path) throws IOException
 *  This method should append the log message to the log file that is stored at the
 *  Input path.
 */

public class LogWriter {

    public static void writeLog(String logMessage, String path) throws IOException {
        try {
            File file = new File(path);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(logMessage);
        } catch(IOException ex) {}

    }

}
