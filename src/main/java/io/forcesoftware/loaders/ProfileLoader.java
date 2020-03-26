package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.billing.Profile;

import java.util.List;

public class ProfileLoader extends Loader {

    private List<Profile> profiles;

    public void loadProfiles() {
        loadFile("[]");

        profiles = Main.GSON.fromJson(getFileContents(), new TypeToken<List<Profile>>() {
        }.getType());

        Main.LOGGER.info("Loaded " + profiles.size() + " profiles");
    }

    @Override
    public String getFileName() {
        return "profiles.json";
    }

    public List<Profile> getProfiles() {
        return profiles;
    }
}
