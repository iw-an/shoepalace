package io.forcesoftware.loaders;

import io.forcesoftware.Main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public abstract class Loader {

    private File file;

    public abstract String getFileName();

    protected void loadFile(String defaultContents) {
        file = new File(Main.configPath + "/" + getFileName());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<String> lines = Collections.singletonList(defaultContents);
            try {
                Files.write(Paths.get(file.getPath()), lines, StandardCharsets.UTF_8);
            } catch (Exception e) {
                Runtime.getRuntime().halt(1);
            }
        }
    }

    protected void saveData(Object object) {
        try {
            Files.write(Paths.get(getFile().getAbsolutePath()), Main.GSON.toJson(object).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileContents() {
        try {
            return new String(Files.readAllBytes(Paths.get(file.getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFile() {
        return file;
    }
}
