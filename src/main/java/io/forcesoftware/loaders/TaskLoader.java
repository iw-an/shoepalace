package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.task.TaskData;

import java.util.List;

public class TaskLoader extends Loader {

    private List<TaskData> tasks;

    public void loadTasks() {
        loadFile("[]");

        tasks = Main.GSON.fromJson(getFileContents(), new TypeToken<List<TaskData>>() {
        }.getType());

        Main.LOGGER.info("Loaded " + tasks.size() + " tasks");
    }

    @Override
    public String getFileName() {
        return "tasks.json";
    }

    public List<TaskData> getTasks() {
        return tasks;
    }
}
