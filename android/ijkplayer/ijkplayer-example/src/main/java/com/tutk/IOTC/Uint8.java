package com.tutk.IOTC.util;

import android.util.Log;

import java.nio.ByteBuffer;

public class Uint8{
    public static byte[] toByteArray(int value){
        ByteBuffer buffer = Uint8.toByteBuffer(value);
        Log.d("TTT","buffer.remaining() : " + buffer.remaining());
        byte [] array = new byte[buffer.remaining()];
        buffer.get(array);
        return array;
    }

    public static ByteBuffer toByteBuffer(int value){
        byte b = (byte) (value & 0x000000ff);
        ByteBuffer buffer = ByteBuffer.allocate(1);
        buffer.put(b);
        buffer.position(0);
        return buffer;
    }

    public static int toInteger(ByteBuffer buffer , int offset){
        return buffer.get(offset);
    }

    public static int toInteger(ByteBuffer buffer){
        return toInteger(buffer,0);
    }
}
