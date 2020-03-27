package io.forcesoftware.loaders;

import com.google.gson.reflect.TypeToken;
import io.forcesoftware.Main;
import io.forcesoftware.models.task.TaskData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TaskLoader extends Loader<List<TaskData>> {

    @Getter
    private List<TaskData> tasks;

    public void loadTasks() {
        this.tasks = new ArrayList<>();

        loadFile("[]");

        tasks = Main.GSON.fromJson(getFileContents(), new TypeToken<List<TaskData>>() {
        }.getType());

        int amount = tasks.size();
        Main.LOGGER.info("Loaded " + amount + " task" + (amount == 1 ? "" : "s"));
    }

    public void addTask(TaskData taskData) {
        this.tasks.add(taskData);
    }

    public void removeTask(TaskData taskData) {
        this.tasks.remove(taskData);
    }

    @Override
    protected String getFileName() {
        return "tasks.json";
    }

    @Override
    protected List<TaskData> getType() {
        return tasks;
    }
}
