/*! \file NebulaBLEAPIs.h
This file describes all the APIs of the Nebula BLE module.
IOTC module is a kind of data communication modules to provide basic data
transfer among devices and clients.

\copyright Copyright (c) 2010 by Throughtek Co., Ltd. All Rights Reserved.

Revision Table

Version     | Name             |Date           |Description
------------|------------------|---------------|-------------------
3.3.0.X     |C.T               |2019-04-24     |- Add NebulaBLEAPIs
 */

package com.tutk.IOTC;

import com.tutk.IOTC.util.LoadLibrary;

public class NebulaLANAPIs {

    public enum LanSearchRole
    {
        DEVICE,
        CLIENT
    }
    /*IOCtrl function for BLE connect*/
    private native static int Nebula_WiFi_Setup_Start_On_LAN(int role, int searchable);
    public native static int Nebula_Device_Listen_On_LAN(String cszUDID, String cszPWD, int timeout_ms);
    public native static st_UDIDInfo[] Nebula_App_Search_UDID_On_LAN(int[] arrNum, int timeout_ms);
    public native static int Nebula_App_Request_TCP_Connect_On_LAN(String cszUDID, String cszPWD, int timeout_ms);
    public native static void Nebula_WiFi_Setup_Stop_On_LAN();
    public native static int Nebula_Send_IOCtrl_On_LAN(int type, byte[] ioctrl_buf, int ioctrl_size);
    public static int Nebula_Send_IOCtrl_On_LAN(NebulaWiFiConfig.NebulaIOCtrlRequest request) {
        byte[] requestBuffer = request.toByteArray();
        return Nebula_Send_IOCtrl_On_LAN(request.getType().getValue(), requestBuffer, requestBuffer.length);
    }
    public native static int Nebula_Recv_IOCtrl_From_LAN(int[] pioType, byte[] ioCtrlBuf, int ioCtrlBufMaxSize, int timeout_ms);

    static {
        LoadLibrary.load("NebulaAPIs");
    }

    public static int Nebula_WiFi_Setup_Start_On_LAN(LanSearchRole role , int searchable){
        return Nebula_WiFi_Setup_Start_On_LAN(role.ordinal(),searchable);
    }
}
