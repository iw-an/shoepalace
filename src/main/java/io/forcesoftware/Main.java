package io.forcesoftware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.forcesoftware.loaders.ProfileLoader;
import io.forcesoftware.loaders.ProxyLoader;
import io.forcesoftware.loaders.SettingsLoader;
import io.forcesoftware.loaders.TaskLoader;
import org.apache.commons.lang3.SystemUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static String configPath;

    private static Logger logger;

    private static Gson gson;

    public static void main(String[] args){

        if (SystemUtils.IS_OS_WINDOWS){
            configPath = System.getenv("AppData") + "/spbot";
        }else if (SystemUtils.IS_OS_MAC){
            configPath = System.getProperty("user.home") + "/Library/Application Support/spbot";
        }

        logger = LogManager.getLogger("io.forcesoftware.Main");
        gson = new GsonBuilder().setPrettyPrinting().create();

        ProxyLoader.loadProxies();
        ProfileLoader.loadProfiles();
        TaskLoader.loadTasks();
        SettingsLoader.loadSettings();
    }

    public static String getConfigPath() {
        return configPath;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static Gson getGson() {
        return gson;
    }
}
