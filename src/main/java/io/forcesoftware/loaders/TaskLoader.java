package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.task.TaskData;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskLoader {

    private static ArrayList<TaskData> tasks;

    public static void loadTasks() {

        Path applicationSupportDirectory = Paths.get(Main.getConfigPath() + "/tasks.json");
        if (!Files.exists(applicationSupportDirectory)) {
            new File(Main.getConfigPath()).mkdirs();
            List<String> lines = Arrays.asList("[]");
            Path file = Paths.get(Main.getConfigPath() + "/tasks.json");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (Exception e) {
                Runtime.getRuntime().halt(1);
                return;
            }
        }

        String contents;
        try {
            contents = new String(Files.readAllBytes(Paths.get(Main.getConfigPath() + "/tasks.json")));
        } catch (Exception e) {
            Runtime.getRuntime().halt(1);
            return;
        }

        tasks = Main.getGson().fromJson(contents, new TypeToken<ArrayList<TaskData>>() {
        }.getType());

        Main.getLogger().info("Loaded " + tasks.size() + " profiles");
    }

    public static ArrayList<TaskData> getTasks() {
        return tasks;
    }
}
