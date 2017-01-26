package com.terebenin.vkclient.models.newsItem;

/**
 * Created by evgeny on 26.01.17.
 */

public class LikesBean {
    /**
     * count : 0
     * user_likes : 0
     * can_like : 1
     * can_publish : 1
     */

    private int count;
    private int user_likes;
    private int can_like;
    private int can_publish;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUser_likes() {
        return user_likes;
    }

    public void setUser_likes(int user_likes) {
        this.user_likes = user_likes;
    }

    public int getCan_like() {
        return can_like;
    }

    public void setCan_like(int can_like) {
        this.can_like = can_like;
    }

    public int getCan_publish() {
        return can_publish;
    }

    public void setCan_publish(int can_publish) {
        this.can_publish = can_publish;
    }
}