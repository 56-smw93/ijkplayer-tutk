/**
 * Region.java
 *
 * Copyright (c) by TUTK Co.LTD. All Rights Reserved.
 */
package com.tutk.IOTC;

/**
* Enum the master region type that IOTCAPI supports.
*/
public enum TUTKRegion {
    REGION_RESERVED(0),
    REGION_CN(1),
    REGION_EU(2),
    REGION_US(3),
    REGION_ASIA(4),
    REGION_COUNT(5);
    private int value;

    private TUTKRegion(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TUTKRegion toRegion(int value){
        for(TUTKRegion region : TUTKRegion.values()){
            if(region.value == value)return region;
        }
        return null;
    }
}
