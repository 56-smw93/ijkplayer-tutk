/**
 * Region.java
 *
 * Copyright (c) by TUTK Co.LTD. All Rights Reserved.
 */
package com.tutk.IOTC;

/**
* Enum the master region type that IOTCAPI supports.
*/
public enum NebulaSocketProtocol {
    NEBULA_PROTO_TCP(0),
    NEBULA_PROTO_UDP(1);

    private int value;

    private NebulaSocketProtocol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
