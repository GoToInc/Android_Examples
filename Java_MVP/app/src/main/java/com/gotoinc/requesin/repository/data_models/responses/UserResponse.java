package com.gotoinc.requesin.repository.data_models.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Illia Derevianko on 23.11.18.
 * GoTo Inc.
 */
public class UserResponse {
    @Expose(serialize = false)
    @SerializedName("id")
    private int id;
    @Expose(serialize = false)
    @SerializedName("first_name")
    private String firstName;
    @Expose(serialize = false)
    @SerializedName("last_name")
    private String lastName;
    @Expose(serialize = false)
    @SerializedName("avatar")
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
