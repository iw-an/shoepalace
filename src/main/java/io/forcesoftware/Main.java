package io.forcesoftware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.forcesoftware.loaders.ProfileLoader;
import io.forcesoftware.loaders.ProxyLoader;
import io.forcesoftware.loaders.SettingsLoader;
import io.forcesoftware.loaders.TaskLoader;
import io.forcesoftware.models.task.TaskData;
import io.forcesoftware.tasks.ShoePalaceTask;
import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final Logger LOGGER = LogManager.getLogger("io.forcesoftware.Main");

    public static String configPath;

    private static Main instance;

    public static void main(String[] args) {
        if (SystemUtils.IS_OS_WINDOWS) {
            configPath = System.getenv("AppData") + "/spbot";
        } else if (SystemUtils.IS_OS_MAC) {
            configPath = System.getProperty("user.home") + "/Library/Application Support/spbot";
        }

        instance = new Main();
    }

    private ProfileLoader profileLoader;
    private ProxyLoader proxyLoader;
    private SettingsLoader settingsLoader;
    private TaskLoader taskLoader;

    public Main() {
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

    public ProfileLoader getProfileLoader() {
        return profileLoader;
    }

    public ProxyLoader getProxyLoader() {
        return proxyLoader;
    }

    public SettingsLoader getSettingsLoader() {
        return settingsLoader;
    }

    public TaskLoader getTaskLoader() {
        return taskLoader;
    }

    public static Main getInstance() {
        return instance;
    }
}
