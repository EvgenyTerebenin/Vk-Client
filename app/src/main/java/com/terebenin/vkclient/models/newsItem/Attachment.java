package com.terebenin.vkclient.models.newsItem;

/**
 * Created by evgeny on 07.02.17.
 */

public class Attachment {
    /**
     * type : link
     * link : {"url":"http://enter.kazanfirst.ru/?p=12772","title":"Цифра дня: сколько литров суррогата обнаружено в Татарстане в прошлом году","caption":"enter.kazanfirst.ru","description":"За наводку жители республики могут получить деньги. В 2016 году в Татарстане было изъято около 450 литров нелегального алкоголя. Об этом сообщила Госалкогольинспекция РТ на совещании по итогам года. Общая сумма штрафов составила около 30 миллионов рублей. К ответственности привлечены более 2 тысяч татарстанцев. За информацию о продаже сомнительной алкопродукции ведомство предлагает вознаграждение:","photo":{"id":456239182,"album_id":-2,"owner_id":14748097,"photo_75":"https://cs540106....4c5/V7INUJNMk6c.jpg","photo_130":"https://cs540106....4c6/LDoZCGoB9F4.jpg","photo_604":"https://cs540106....4c7/pcLVE1cYZQw.jpg","width":150,"height":87,"text":"","date":1485433267}}
     */

    private String type;
    private Photo photo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
