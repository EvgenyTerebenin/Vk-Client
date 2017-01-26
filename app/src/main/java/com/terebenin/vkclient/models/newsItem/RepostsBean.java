package com.terebenin.vkclient.models.newsItem;

/**
 * Created by evgeny on 26.01.17.
 */

public class RepostsBean {
    /**
     * count : 0
     * user_reposted : 0
     */

    private int count;
    private int user_reposted;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUser_reposted() {
        return user_reposted;
    }

    public void setUser_reposted(int user_reposted) {
        this.user_reposted = user_reposted;
    }
}