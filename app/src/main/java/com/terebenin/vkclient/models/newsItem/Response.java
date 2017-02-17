package com.terebenin.vkclient.models.newsItem;

import java.util.List;

/**
 * Created by evgeny on 26.01.17.
 */

public class Response {

    private String next_from;
    private List<Item> items;
    private List<Profile> profiles;
    private List<Group> groups;

    public String getNext_from() {
        return next_from;
    }

    public void setNext_from(String next_from) {
        this.next_from = next_from;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}