package com.test.testaves.datamodels;

import java.io.Serializable;

public class UserProfileImageModel implements Serializable {
    private final String small;
    private final String medium;
    private final String large;

    public UserProfileImageModel(String small, String medium, String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }


    public String getLarge() {
        return large;
    }

}
