package io.forcesoftware.loaders;

import io.forcesoftware.Main;
import io.forcesoftware.models.setting.Settings;
import lombok.Getter;

public class SettingsLoader extends Loader<Settings> {

    @Getter
    private Settings settings;

    public void loadSettings() {
        loadFile("{}");

        settings = Main.GSON.fromJson(getFileContents(), Settings.class);

        Main.LOGGER.info("Loaded settings");
    }

    @Override
    protected String getFileName() {
        return "settings.json";
    }

    @Override
    protected Settings getType() {
        return settings;
    }
}
