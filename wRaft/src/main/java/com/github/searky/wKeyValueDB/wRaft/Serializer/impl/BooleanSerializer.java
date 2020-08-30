package com.github.searky.wKeyValueDB.wRaft.Serializer.impl;

import com.github.searky.wKeyValueDB.wRaft.Serializer.Serializer;

/**
 * boolean serializer
 */
public class BooleanSerializer implements Serializer<Boolean> {
    @Override
    public int size(Boolean entry) {
        return 1;
    }

    @Override
    public void serialize(Boolean entry, byte[] buffer, int offset, int length) {
        byte value = (byte) ((entry == Boolean.TRUE) ? 1 : 0);
        buffer[offset] = value;
    }

    @Override
    public Boolean parse(byte[] buffer, int offset, int length) {
        byte value = buffer[offset];
        return value == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public byte type() {
        return Type.TYPE_BOOLEAN;
    }

    @Override
    public Class<Boolean> getSerializeClass() {
        return Boolean.class;
    }
}
