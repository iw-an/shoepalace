package io.forcesoftware;

import io.forcesoftware.loaders.ProfileLoader;
import io.forcesoftware.loaders.ProxyLoader;
import io.forcesoftware.loaders.SettingsLoader;
import io.forcesoftware.loaders.TaskLoader;
import io.forcesoftware.models.task.TaskData;
import io.forcesoftware.tasks.ShoePalaceTask;
import lombok.Getter;

@Getter
public class ShoePalaceBot {

    private static ShoePalaceBot instance;

    private ProfileLoader profileLoader;
    private ProxyLoader proxyLoader;
    private SettingsLoader settingsLoader;
    private TaskLoader taskLoader;

    public ShoePalaceBot() {
        instance = this;

        registerLoaders();
        beginTasks();
    }

    private void registerLoaders() {
        (profileLoader = new ProfileLoader()).loadProfiles();
        (proxyLoader = new ProxyLoader()).loadProxies();
        (settingsLoader = new SettingsLoader()).loadSettings();
        (taskLoader = new TaskLoader()).loadTasks();
    }

    private void beginTasks() {
        for (TaskData taskData : taskLoader.getTasks()) {
            ShoePalaceTask shoePalaceTask = new ShoePalaceTask(taskData);
            shoePalaceTask.start();
        }
    }

    public static ShoePalaceBot getInstance() {
        return instance;
    }
}
