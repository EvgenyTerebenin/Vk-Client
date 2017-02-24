package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.serializer.TypeSerializer;

/**
 * Created by evgeny on 24.02.17.
 */

public class AttachmentSerializer extends TypeSerializer {
    @Override
    public Class<?> getDeserializedType() {
        return Attachment.class;
    }

    @Override
    public SerializedType getSerializedType() {
        return SerializedType.STRING;
    }

    @Override
    public String serialize(Object data) {
        if (data == null) {
            return null;
        }
        return ((Attachment) data).getType();
    }

    @Override
    public Attachment deserialize(Object data) {
        if (data == null) {
            return null;
        }
        return new Attachment((String) data);
    }
}