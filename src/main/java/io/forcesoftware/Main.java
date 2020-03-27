package io.forcesoftware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Getter
public class Main {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final Logger LOGGER = LogManager.getLogger("io.forcesoftware.Main");

    public static Path configPath;

    public static void main(String[] args) {
        setConfigurationPath();
        createConfigurationDirectory();
        new ShoePalaceBot();
    }

    public static void setConfigurationPath() {
        if (SystemUtils.IS_OS_WINDOWS) {
            configPath = Paths.get(System.getenv("AppData"), "spbot");
        } else if (SystemUtils.IS_OS_MAC) {
            configPath = Paths.get(System.getProperty("user.home"), "Library", "Application Support", "spbot");
        } else if (SystemUtils.IS_OS_LINUX) {
            // Create a hidden directory in the user's home directory on Linux
            configPath = Paths.get(System.getProperty("user.home"), ".spbot");
        }
    }

    public static void createConfigurationDirectory() {
        if (!Files.exists(configPath)) {
            try {
                Files.createDirectory(configPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
