package com.test.testaves.datamodels;

import java.io.Serializable;

public class ImagesModel implements Serializable {
    private final String regular;
    private final String small;
    private final String full;

    public ImagesModel(String regular, String small, String full) {
        this.regular = regular;
        this.small = small;
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public String getSmall() {
        return small;
    }

    public String getFull() {
        return full;
    }
}
