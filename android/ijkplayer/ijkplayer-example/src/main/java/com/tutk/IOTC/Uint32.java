package com.tutk.IOTC.util;

import java.nio.ByteBuffer;

public class Uint32 {
    public static byte[] toByteArray(int value){
        ByteBuffer buffer = Uint32.toByteBuffer(value);
        byte [] array = new byte[buffer.remaining()];
        buffer.get(array);
        return array;
    }

    public static ByteBuffer toByteBuffer(int value){
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(value);
        buffer.position(0);
        return buffer;
    }

    public static int toInteger(ByteBuffer buffer , int offset){
        return buffer.getInt(offset);
    }
}
