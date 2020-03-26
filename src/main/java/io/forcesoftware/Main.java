package io.forcesoftware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Getter
public class Main {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final Logger LOGGER = LogManager.getLogger("io.forcesoftware.Main");

    public static String configPath;

    public static void main(String[] args) {
        if (SystemUtils.IS_OS_WINDOWS) {
            configPath = System.getenv("AppData") + "/spbot";
        } else if (SystemUtils.IS_OS_MAC) {
            configPath = System.getProperty("user.home") + "/Library/Application Support/spbot";
        }

        new ShoePalaceBot();
    }
}
