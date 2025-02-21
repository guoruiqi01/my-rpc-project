package com.grq.myrpc.registry;

import com.grq.myrpc.serializer.Serializer;
import com.grq.myrpc.serializer.SerializerFactory;
import org.junit.Test;

public class SerializerTest {
    @Test
    public void testSerializer() {
        Serializer serializer = SerializerFactory.getInstance("jdk");
        System.out.println(serializer);
    }
}
