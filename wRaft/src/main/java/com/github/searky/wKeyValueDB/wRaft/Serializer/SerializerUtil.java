package com.github.searky.wKeyValueDB.wRaft.Serializer;

import com.github.searky.wKeyValueDB.wRaft.spi.ServiceUtil;
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

    /**
     * load all the implement of Serializer
     */
    static {
        for (Serializer serializer : ServiceUtil.loadAll(Serializer.class)) {
            registerType(serializer.type(), serializer.getSerializeClass(), serializer);
            logger.info("Found Serializer, class: {}, type: {}.",
                    serializer.getSerializeClass().getCanonicalName(),
                    serializer.type());
        }
    }

    /**
     * register the Serializer to maps.
     * @param type the type of Serializer{@link Serializer}
     * @param cls the class of Serializer{@link Serializer}
     * @param serializer the Serializer{@link Serializer}
     */
    private static <E> void registerType(byte type, Class<E> cls, Serializer<E> serializer) {
        serializerMap.put(cls, serializer);
        typeMap.put(type, cls);
    }
}
