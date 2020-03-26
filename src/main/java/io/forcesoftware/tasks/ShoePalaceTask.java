package io.forcesoftware.tasks;

import io.forcesoftware.Main;
import io.forcesoftware.models.billing.Profile;
import io.forcesoftware.models.task.TaskData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShoePalaceTask implements Runnable {

    private Thread thread;

    private Logger logger;

    private TaskData taskData;

    private Profile profile;

    public ShoePalaceTask(TaskData taskData) {
        this.logger = LogManager.getLogger("io.forcesoftware.Task");
        this.taskData = taskData;
    }

    @Override
    public void run() {
        for (Profile profile : Main.getInstance().getProfileLoader().getProfiles()) {
            if (profile.getAlias().equals(taskData.getProfileAlias())) {
                this.profile = profile;
            }
        }

        if (profile == null) {
            logger.error("Failed to find profile for task");
            return;
        }

        logger.info("Task started");
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, "ShoePalaceTask-" + taskData.getId());
            thread.start();
        }
    }
}
