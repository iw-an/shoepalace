package io.forcesoftware;

import io.forcesoftware.loaders.ProfileLoader;
import io.forcesoftware.loaders.ProxyLoader;
import io.forcesoftware.loaders.SettingsLoader;
import io.forcesoftware.loaders.TaskLoader;
import io.forcesoftware.models.billing.Address;
import io.forcesoftware.models.billing.Card;
import io.forcesoftware.models.billing.Profile;
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

        setupShutdownHook();

        // createDummyData();
    }

    private void registerLoaders() {
        (profileLoader = new ProfileLoader()).loadProfiles();
        (proxyLoader = new ProxyLoader()).loadProxies();
        (settingsLoader = new SettingsLoader()).loadSettings();
        (taskLoader = new TaskLoader()).loadTasks();
    }

    private void setupShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            profileLoader.saveData();
            taskLoader.saveData();
            settingsLoader.saveData();
        }));
    }

    private void beginTasks() {
        for (TaskData taskData : taskLoader.getTasks()) {
            ShoePalaceTask shoePalaceTask = new ShoePalaceTask(taskData);
            shoePalaceTask.start();
        }
    }

    /**
     * Simple method which will generate dummy data to test with
     */
    private void createDummyData() {
        Card card = new Card.Builder()
                .cardNumber("1234 1234 1234 1234")
                .cardExpiryMonth("10")
                .cardExpiryYear("2027")
                .cardCvv("123")
                .build();

        Address address = new Address.Builder()
                .addressOne("123 south st.")
                .state("California")
                .city("Los Angeles")
                .zip("90405")
                .firstName("Joe")
                .lastName("Smith")
                .phone("123 456 7890")
                .build();

        Profile profile = new Profile.Builder()
                .alias("test")
                .email("email@test.com")
                .card(card)
                .shippingAddress(address)
                .build();

        TaskData taskData = new TaskData.Builder()
                .id("1")
                .url("https://shoepalace.com")
                .profileAlias("test")
                .builder();

        profileLoader.addProfile(profile);
        taskLoader.addTask(taskData);
    }

    public static ShoePalaceBot getInstance() {
        return instance;
    }
}
