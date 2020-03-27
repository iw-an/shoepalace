package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.billing.Profile;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class ProfileLoader extends Loader<Map<String, Profile>> {

    @Getter
    private Map<String, Profile> profiles;

    public void loadProfiles() {
        this.profiles = new HashMap<>();

        loadFile("[]");

        profiles = Main.GSON.fromJson(getFileContents(), new TypeToken<Map<String, Profile>>() {
        }.getType());

        int amount = profiles.size();
        Main.LOGGER.info("Loaded " + amount + " profile" + (amount == 1 ? "" : "s"));
    }

    public Profile getProfile(String alias) {
        return this.profiles.get(alias);
    }

    public void addProfile(Profile profile) {
        this.profiles.put(profile.getAlias(), profile);
    }

    public void removeProfile(Profile profile) {
        this.profiles.remove(profile.getAlias());
    }

    @Override
    protected String getFileName() {
        return "profiles.json";
    }

    @Override
    protected Map<String, Profile> getType() {
        return profiles;
    }
}
