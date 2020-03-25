package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.billing.Profile;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileLoader {

    private static ArrayList<Profile> profiles;

    public static void loadProfiles() {

        Path applicationSupportDirectory = Paths.get(Main.getConfigPath() + "/profiles.json");
        if (!Files.exists(applicationSupportDirectory)) {
            new File(Main.getConfigPath()).mkdirs();
            List<String> lines = Arrays.asList("[]");
            Path file = Paths.get(Main.getConfigPath() + "/profiles.json");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (Exception e) {
                Runtime.getRuntime().halt(1);
                return;
            }
        }

        String contents;
        try {
            contents = new String(Files.readAllBytes(Paths.get(Main.getConfigPath() + "/profiles.json")));
        } catch (Exception e) {
            Runtime.getRuntime().halt(1);
            return;
        }

        profiles = Main.getGson().fromJson(contents, new TypeToken<ArrayList<Profile>>() {
        }.getType());

        Main.getLogger().info("Loaded " + profiles.size() + " profiles");
    }

    public static ArrayList<Profile> getProfiles() {
        return profiles;
    }
}
