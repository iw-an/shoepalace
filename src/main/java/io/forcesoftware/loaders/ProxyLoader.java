package io.forcesoftware.loaders;

import io.forcesoftware.Main;
import io.forcesoftware.models.Proxy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProxyLoader {

    private static ArrayList<Proxy> proxies;

    public static void loadProxies(){

        proxies = new ArrayList<>();

        Path applicationSupportDirectory = Paths.get(Main.getConfigPath() + "/proxies.txt");
        if (!Files.exists(applicationSupportDirectory)){
            new File(Main.getConfigPath()).mkdirs();
            List<String> lines = Arrays.asList("");
            Path file = Paths.get(Main.getConfigPath() + "/proxies.txt");
            try{
                Files.write(file, lines, Charset.forName("UTF-8"));
            }catch (Exception e){
                Runtime.getRuntime().halt(1);
                return;
            }
        }

        try(Stream<String> stream = Files.lines(applicationSupportDirectory)) {
            stream.forEach((line)->{
                String[] text = line.split(":");
                if(text.length >= 2){
                    Proxy proxy = new Proxy(text[0], text[1]);
                    if(text.length > 2){
                        proxy = new Proxy(text[0], text[1], text[2], text[3]);
                    }
                    proxies.add(proxy);
                }
            });
        }catch (IOException e){

        }

        Main.getLogger().info("Loaded " + proxies.size() + " proxies");
    }

}
