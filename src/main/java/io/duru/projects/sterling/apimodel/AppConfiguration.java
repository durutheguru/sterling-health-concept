package io.duru.projects.sterling.apimodel;

/**
 * created by dduru on 04/11/18
 */
public class AppConfiguration {

    private String name;

    private boolean debug;


    public String getName() {
        return name;
    }

    public AppConfiguration setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public AppConfiguration setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }


}