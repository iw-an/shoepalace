package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.billing.Profile;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ProfileLoader extends Loader {

    @Getter
    private List<Profile> profiles;

    public void loadProfiles() {
        this.profiles = new ArrayList<>();

        loadFile("[]");

        profiles = Main.GSON.fromJson(getFileContents(), new TypeToken<List<Profile>>() {
        }.getType());

        Main.LOGGER.info("Loaded " + profiles.size() + " profiles");
    }

    public void saveProfiles() {
        saveData(profiles);
    }

    @Override
    public String getFileName() {
        return "profiles.json";
    }
}
