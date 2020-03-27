package io.forcesoftware.loaders;

import io.forcesoftware.Main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public abstract class Loader<Type> {

    private File file;

    protected abstract String getFileName();

    protected abstract Type getType();

    protected void loadFile(String defaultContents) {
        file = new File(Main.configPath + "/" + getFileName());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            List<String> lines = Collections.singletonList(defaultContents);
            try {
                Files.write(Paths.get(file.getPath()), lines, StandardCharsets.UTF_8);
            } catch (Exception e) {
                Runtime.getRuntime().halt(1);
            }
        }
    }

    public void saveData() {
        try {
            Files.write(Paths.get(getFile().getAbsolutePath()), Main.GSON.toJson(getType()).getBytes());
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
