package io.forcesoftware.loaders;

import io.forcesoftware.Main;
import io.forcesoftware.models.setting.Settings;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SettingsLoader {

    private static Settings settings;

    public static void loadSettings() {

        Path applicationSupportDirectory = Paths.get(Main.getConfigPath() + "/settings.json");
        if (!Files.exists(applicationSupportDirectory)) {
            new File(Main.getConfigPath()).mkdirs();
            List<String> lines = Arrays.asList("{}");
            Path file = Paths.get(Main.getConfigPath() + "/settings.json");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (Exception e) {
                Runtime.getRuntime().halt(1);
                return;
            }
        }

        String contents;
        try {
            contents = new String(Files.readAllBytes(Paths.get(Main.getConfigPath() + "/settings.json")));
        } catch (Exception e) {
            Runtime.getRuntime().halt(1);
            return;
        }

        settings = Main.getGson().fromJson(contents, Settings.class);

        Main.getLogger().info("Loaded settings");
    }

    public static Settings getSettings() {
        return settings;
    }
}
