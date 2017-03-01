package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.serializer.TypeSerializer;
import com.google.gson.Gson;

/**
 * Created by evgeny on 24.02.17.
 */

public class AttachmentListSerializer extends TypeSerializer {

    private final static Gson gson = new Gson();

    @Override
    public Class<?> getDeserializedType() {
        return Attachments.class;
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
            return gson.toJson(data);
        }
    }

    @Override
    public Object deserialize(Object data) {
        if (data == null) {
            return null;
        } else {
            Attachments attachmentList = gson.fromJson((String) data, Attachments.class);
            return attachmentList;
        }
    }
}
