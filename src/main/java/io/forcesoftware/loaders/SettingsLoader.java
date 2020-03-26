package io.forcesoftware.loaders;

import io.forcesoftware.Main;
import io.forcesoftware.models.setting.Settings;
import lombok.Getter;

public class SettingsLoader extends Loader {

    @Getter
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
}
