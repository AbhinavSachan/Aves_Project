package com.test.testaves.datamodels;

import java.io.Serializable;

public class UserModel implements Serializable {
    private final String name;
    private final String bio;
    private final String location;
    private final UserProfileImageModel profile_image;

    public UserModel(String name, String bio, String location, UserProfileImageModel profile_image) {
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public UserProfileImageModel getProfile_image() {
        return profile_image;
    }
}
