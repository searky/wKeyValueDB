package com.github.searky.wKeyValueDB.wRaft.Serializer;

public interface Serializer<T> {
    /**
     * calculate the size of the object.
     * @param entry the object needs to be serialized
     * @return the size of bytes that needs
     */
    int size(T entry);

    /**
     * serialize the object instance into the byte array.
     * @param entry the object instance
     * @param buffer byte buffer
     * @param offset the offset of the buffer, where to write the serialized bytes
     * @param length the length of serialized size, which is the return value of {@link Serializer#size(Object)}
     */
    void serialize(T entry, byte[] buffer, int offset, int length);

    /**
     * convert to object instance from the byte array.
     * @param buffer byte buffer
     * @param offset the offset of the buffer, where to read the serialized bytes
     * @param length the length of serialized bytes
     * @return the object instance
     */
    T parse(byte[] buffer, int offset, int length);

    /**
     * the type{@link com.github.searky.wKeyValueDB.wRaft.Serializer.impl.Type} of this object.
     * @return the type value
     */
    byte type();

    /**
     * get the serialize class
     * @return the class
     */
    Class<T> getSerializeClass();
}
