package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.task.TaskData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TaskLoader extends Loader {

    @Getter
    private List<TaskData> tasks;

    public void loadTasks() {
        this.tasks = new ArrayList<>();

        loadFile("[]");

        tasks = Main.GSON.fromJson(getFileContents(), new TypeToken<List<TaskData>>() {
        }.getType());

        Main.LOGGER.info("Loaded " + tasks.size() + " tasks");
    }

    public void saveTasks() {
        saveData(tasks);
    }

    @Override
    public String getFileName() {
        return "tasks.json";
    }
}
