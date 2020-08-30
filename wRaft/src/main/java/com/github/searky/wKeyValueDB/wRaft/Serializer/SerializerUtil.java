package com.github.searky.wKeyValueDB.wRaft.Serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Serializer Utility
 */
public class SerializerUtil {
    private static final Logger logger = LoggerFactory.getLogger(SerializerUtil.class);
    private static Map<Class<?>/* Object Class */, Serializer<?>/* Serializer Implement */> serializerMap = new HashMap<>();
    private static Map<Byte/* Type of Serializer */, Class<?>/* Object Class */> typeMap = new HashMap<>();

}
