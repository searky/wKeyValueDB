package com.github.searky.wKeyValueDB.wRaft.Serializer;

import com.github.searky.wKeyValueDB.wRaft.Serializer.impl.BooleanSerializer;
import com.github.searky.wKeyValueDB.wRaft.Serializer.impl.IntegerSerializer;
import org.junit.Assert;
import org.junit.Test;

public class SerializerTest {
    @Test
    public void integerSerializerTest() {
        Serializer<Integer> serializer = new IntegerSerializer();
        Integer value = 28;
        int size = serializer.size(value);
        byte[] buffer = new byte[size];
        serializer.serialize(value, buffer, 0, size);
        Integer result = 0;
        result = serializer.parse(buffer, 0, buffer.length);
        Assert.assertTrue(result == value);
        Assert.assertTrue(serializer.getSerializeClass() == Integer.class);
    }

    @Test
    public void booleanSerializerTest() {
        Serializer<Boolean> serializer = new BooleanSerializer();
        Boolean value = false;
        int size = serializer.size(value);
        byte[] buffer = new byte[size];
        serializer.serialize(value, buffer, 0, size);
        Boolean result = true;
        result = serializer.parse(buffer, 0, buffer.length);
        Assert.assertTrue(result == value);
        Assert.assertTrue(serializer.getSerializeClass() == Boolean.class);
    }
}
