package io.forcesoftware.loaders;

import io.forcesoftware.Main;
import io.forcesoftware.models.setting.Settings;

public class SettingsLoader extends Loader {

    private Settings settings;

    public void loadSettings() {
        loadFile("{}");

        settings = Main.GSON.fromJson(getFileContents(), Settings.class);

        Main.LOGGER.info("Loaded settings");
    }

    @Override
    public String getFileName() {
        return "settings.json";
    }

    public Settings getSettings() {
        return settings;
    }
}
