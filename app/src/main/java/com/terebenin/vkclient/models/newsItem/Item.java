package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by evgeny on 26.01.17.
 */
@Table(name = "Items")
public class Item extends Model {
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

    @Expose
    @Column(name = "Source_id")
    private int source_id;
    @Expose
    @Column(name = "Text")
    private String text;
    @Expose
    @Column(name = "attachments")
    private Attachments attachments;

    public Item() {
        super();
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}