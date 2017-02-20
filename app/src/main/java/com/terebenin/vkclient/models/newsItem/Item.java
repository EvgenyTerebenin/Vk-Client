package com.terebenin.vkclient.models.newsItem;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;

/**
 * Created by evgeny on 26.01.17.
 */

@Entity
public class Item {
    /**
     * type : post
     * source_id : -65
     * date : 1485433268
     * post_id : 262203
     * post_type : post
     * text : За наводку можно получить деньги!
     * marked_as_ads : 0
     * attachments : [{"type":"link","link":{"url":"http://enter.kazanfirst.ru/?p=12772","title":"Цифра дня: сколько литров суррогата обнаружено в Татарстане в прошлом году","caption":"enter.kazanfirst.ru","description":"За наводку жители республики могут получить деньги. В 2016 году в Татарстане было изъято около 450 литров нелегального алкоголя. Об этом сообщила Госалкогольинспекция РТ на совещании по итогам года. Общая сумма штрафов составила около 30 миллионов рублей. К ответственности привлечены более 2 тысяч татарстанцев. За информацию о продаже сомнительной алкопродукции ведомство предлагает вознаграждение:","photo":{"id":456239182,"album_id":-2,"owner_id":14748097,"photo_75":"https://cs540106....4c5/V7INUJNMk6c.jpg","photo_130":"https://cs540106....4c6/LDoZCGoB9F4.jpg","photo_604":"https://cs540106....4c7/pcLVE1cYZQw.jpg","width":150,"height":87,"text":"","date":1485433267}}}]
     * post_source : {"type":"vk"}
     * comments : {"count":0,"can_post":1}
     * likes : {"count":0,"user_likes":0,"can_like":1,"can_publish":1}
     * reposts : {"count":0,"user_reposted":0}
     */

    private String type;

    @Property(nameInDb = "SOURCE_ID")
    private int source_id;

    private int date;
    private int post_id;
    private String post_type;

    @Property
    private String text;

    private int marked_as_ads;

    @Property
    private List<Attachment> attachments;


    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMarked_as_ads() {
        return marked_as_ads;
    }

    public void setMarked_as_ads(int marked_as_ads) {
        this.marked_as_ads = marked_as_ads;
    }

}