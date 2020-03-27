package io.forcesoftware.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proxy {

    private String ip;
    private String port;
    private String username;
    private String password;

    public Proxy(String ip, String port, String... up) {
        this.ip = ip;
        this.port = port;

        if (up.length != 0) {
            this.username = up[0];
            this.password = up[1];
        }
    }

    public boolean isAuth() {
        return username != null && password != null;
    }

    public String toString() {
        return ip + ":" + port + (username != null ? ":" + username + ":" : "") + (password != null ? password : "");
    }
}
