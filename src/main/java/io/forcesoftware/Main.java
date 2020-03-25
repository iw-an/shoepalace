package io.forcesoftware;

import io.forcesoftware.loaders.ProxyLoader;
import org.apache.commons.lang3.SystemUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static String configPath;

    private static Logger logger;

    public static void main(String[] args){

        if (SystemUtils.IS_OS_WINDOWS){
            configPath = System.getenv("AppData") + "/spbot";
        }else if (SystemUtils.IS_OS_MAC){
            configPath = System.getProperty("user.home") + "/Library/Application Support/spbot";
        }

        logger = LogManager.getLogger("io.forcesoftware.Main");

        ProxyLoader.loadProxies();

    }

    public static String getConfigPath() {
        return configPath;
    }

    public static Logger getLogger() {
        return logger;
    }
}
