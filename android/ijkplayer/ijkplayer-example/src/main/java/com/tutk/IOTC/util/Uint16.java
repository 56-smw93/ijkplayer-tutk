package com.tutk.IOTC.util;

import java.nio.ByteBuffer;

public class Uint16 {
    public static byte[] toByteArray(int value){
        ByteBuffer buffer = Uint16.toByteBuffer(value);
        byte [] array = new byte[buffer.remaining()];
        buffer.get(array);
        return array;
    }

    public static ByteBuffer toByteBuffer(int value){
        short b = (short) (value & 0x0000ffff);
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putShort(b);
        buffer.position(0);
        return buffer;
    }

    public static int toInteger(ByteBuffer buffer , int offset){
        return buffer.getShort(offset);
    }

}
