package io.forcesoftware.loaders;

import io.forcesoftware.Main;
import io.forcesoftware.models.Proxy;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProxyLoader extends Loader {

    @Getter
    private List<Proxy> proxies;

    public void loadProxies() {
        proxies = new ArrayList<>();

        loadFile("");

        try (Stream<String> stream = Files.lines(getFile().toPath())) {
            stream.forEach((line) -> {
                String[] text = line.split(":");
                if (text.length >= 2) {
                    Proxy proxy = new Proxy(text[0], text[1]);
                    if (text.length > 2) {
                        proxy = new Proxy(text[0], text[1], text[2], text[3]);
                    }
                    proxies.add(proxy);
                }
            });
        } catch (IOException e) {
            Main.LOGGER.error("Could not load proxies: " + e.getLocalizedMessage());
            e.printStackTrace();
            return;
        }

        Main.LOGGER.info("Loaded " + proxies.size() + " proxies");
    }

    @Override
    public String getFileName() {
        return "proxies.txt";
    }
}
