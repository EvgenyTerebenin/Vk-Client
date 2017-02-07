package com.terebenin.vkclient.models.newsItem;

import java.util.List;

/**
 * Created by evgeny on 26.01.17.
 */

public class Response {
    /**
     * items : [{"type":"post","source_id":-65,"date":1485433268,"post_id":262203,"post_type":"post","text":"За наводку можно получить деньги!","marked_as_ads":0,"attachments":[{"type":"link","link":{"url":"http://enter.kazanfirst.ru/?p=12772","title":"Цифра дня: сколько литров суррогата обнаружено в Татарстане в прошлом году","caption":"enter.kazanfirst.ru","description":"За наводку жители республики могут получить деньги. В 2016 году в Татарстане было изъято около 450 литров нелегального алкоголя. Об этом сообщила Госалкогольинспекция РТ на совещании по итогам года. Общая сумма штрафов составила около 30 миллионов рублей. К ответственности привлечены более 2 тысяч татарстанцев. За информацию о продаже сомнительной алкопродукции ведомство предлагает вознаграждение:","photo":{"id":456239182,"album_id":-2,"owner_id":14748097,"photo_75":"https://cs540106....4c5/V7INUJNMk6c.jpg","photo_130":"https://cs540106....4c6/LDoZCGoB9F4.jpg","photo_604":"https://cs540106....4c7/pcLVE1cYZQw.jpg","width":150,"height":87,"text":"","date":1485433267}}}],"post_source":{"type":"vk"},"comments":{"count":0,"can_post":1},"likes":{"count":0,"user_likes":0,"can_like":1,"can_publish":1},"reposts":{"count":0,"user_reposted":0}}]
     * profiles : []
     * groups : [{"id":65,"name":"Enter Казань","screen_name":"enter.media","is_closed":0,"type":"page","is_admin":0,"is_member":1,"photo_50":"https://pp.vk.me/...1a0/oca_fPBuFWs.jpg","photo_100":"https://pp.vk.me/...19f/uerDsQqqKR8.jpg","photo_200":"https://pp.vk.me/...19d/ZhT4cvPw5J8.jpg"},{"id":30666517,"name":"Типичный программист","screen_name":"tproger","is_closed":0,"type":"page","is_admin":0,"is_member":1,"photo_50":"https://pp.vk.me/...357/zkPslo4Jxqs.jpg","photo_100":"https://pp.vk.me/...356/52RxkdB2ITI.jpg","photo_200":"https://pp.vk.me/...355/_dBjv5eEXRg.jpg"},{"id":54530371,"name":"Библиотека программиста","screen_name":"proglib","is_closed":0,"type":"page","is_admin":0,"is_member":1,"photo_50":"https://pp.vk.me/...1ad/Brs6nTMRsFs.jpg","photo_100":"https://pp.vk.me/...1ac/QAojVWxc9hM.jpg","photo_200":"https://pp.vk.me/...1ab/LaI3wiAq8dw.jpg"}]
     * next_from : 1/262203_1485378000_5
     */

    private String next_from;
    private List<Items> items;
    private List<Profiles> profiles;
    private List<Groups> groups;

    public String getNext_from() {
        return next_from;
    }

    public void setNext_from(String next_from) {
        this.next_from = next_from;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<Profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profiles> profiles) {
        this.profiles = profiles;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}