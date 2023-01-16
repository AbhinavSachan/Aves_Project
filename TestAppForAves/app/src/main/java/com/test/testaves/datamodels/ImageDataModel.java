package com.test.testaves.datamodels;

import java.io.Serializable;

public class ImageDataModel implements Serializable {
    private final String description;
    private final String alt_description;
    private final ImagesModel urls;
    private final UserModel user;

    public ImageDataModel(String description, String alt_description, ImagesModel urls, UserModel user) {
        this.description = description;
        this.alt_description = alt_description;
        this.urls = urls;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public ImagesModel getUrls() {
        return urls;
    }

    public UserModel getUser() {
        return user;
    }
}
