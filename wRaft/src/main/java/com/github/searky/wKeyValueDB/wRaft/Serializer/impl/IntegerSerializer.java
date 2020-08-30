package com.github.searky.wKeyValueDB.wRaft.Serializer.impl;

import com.github.searky.wKeyValueDB.wRaft.Serializer.Serializer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * integer serializer
 */
public class IntegerSerializer implements Serializer<Integer> {

    @Override
    public int size(Integer entry) {
        return Integer.SIZE;
    }

    @Override
    public void serialize(Integer entry, byte[] buffer, int offset, int length) {
        byte[] intBytes = ByteBuffer.allocate(Integer.SIZE).putInt(entry).array();
        System.arraycopy(intBytes, 0, buffer, offset, intBytes.length);
    }

    @Override
    public Integer parse(byte[] buffer, int offset, int length) {
        return ByteBuffer.wrap(buffer, offset, length).getInt();
    }

    @Override
    public byte type() {
        return Type.TYPE_INTEGER;
    }

    @Override
    public Class<Integer> getSerializeClass() {
        return Integer.class;
    }
}
