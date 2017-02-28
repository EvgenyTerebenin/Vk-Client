package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.serializer.TypeSerializer;
import com.google.gson.Gson;
import java.util.List;

/**
 * Created by evgeny on 24.02.17.
 */

public class AttachmentListSerializer extends TypeSerializer {

    private final static Gson gson = new Gson();
    String jsonAttachmentList;

    @Override
    public Class<?> getDeserializedType() {
        return List.class;
    }

    @Override
    public Class<?> getSerializedType() {
        return String.class;
    }

    @Override
    public Object serialize(Object data) {
        if (data == null) {
            return null;
        } else {
            jsonAttachmentList = gson.toJson(data);
            return jsonAttachmentList;
        }
    }

    @Override
    public Object deserialize(Object data) {
        if (data == null) {
            return null;
        } else {
            List<Attachment> attachmentList = gson.fromJson(jsonAttachmentList, List.class);
            return attachmentList;
        }
    }
}
