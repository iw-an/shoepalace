package io.forcesoftware.models;

import java.util.UUID;

public class Proxy {

    private String ip;
    private String port;
    private String username;
    private String password;
    private boolean auth = false;

    public Proxy(String ip, String port, String... up) {
        this.ip = ip;
        this.port = port;
        if (up.length != 0) {
            this.auth = true;
            this.username = up[0];
            this.password = up[1];
        }
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAuth() {
        return auth;
    }
}
