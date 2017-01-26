package com.terebenin.vkclient.models.newsItem;

/**
 * Created by evgeny on 26.01.17.
 */

public class CommentsBean {
    /**
     * count : 0
     * can_post : 1
     */

    private int count;
    private int can_post;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCan_post() {
        return can_post;
    }

    public void setCan_post(int can_post) {
        this.can_post = can_post;
    }
}
