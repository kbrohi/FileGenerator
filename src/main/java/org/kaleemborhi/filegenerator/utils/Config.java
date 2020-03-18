package org.kaleemborhi.filegenerator.utils;

public enum Config {
    DURATION(10);

    private int params;

    Config(int params) {
        this.params = params;
    }

    public int params(){
        return params * 60 * 10_000; //minutes
    }

}
