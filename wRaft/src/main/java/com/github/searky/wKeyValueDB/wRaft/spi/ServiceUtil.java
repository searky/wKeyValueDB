package com.github.searky.wKeyValueDB.wRaft.spi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SuppressWarnings("unchecked")
public class ServiceUtil {
    /**
     * class name --> class instance mapping.
     */
    private final static Map<String, Object> singletonServices = new HashMap<>();

    /**
     * load all implement of service
     * @param service service interface class
     * @return the collection of implement classes
     */
    public synchronized static <S>Collection<S> loadAll(Class<S> service) {
        return StreamSupport.stream(ServiceLoader.load(service).spliterator(), false)
                .map(ServiceUtil::singletonFilter).collect(Collectors.toList());
    }

    /**
     * singleton filter.check if the implement of the service is annotated as Singleton.
     * if so, return the singleton instance from the singletonServices mapping,
     * else, return the new instance.
     * @param service
     * @param <S>
     * @return
     */
    private static <S> S singletonFilter(S service) {
        if (service.getClass().isAnnotationPresent(Singleton.class)) {
            String className = service.getClass().getCanonicalName();
            Object singletonInstance = singletonServices.putIfAbsent(className, service);
            return singletonInstance == null ? service : (S) singletonInstance;
        } else {
            return service;
        }
    }


}
