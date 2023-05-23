/*! \file NebulaAPIs.java
This file describes all the APIs of the Nebula Bind module in IOTC platform.

\copyright Copyright (c) 2019 by Throughtek Co., Ltd. All Rights Reserved.

Revision Table

Version     | Name             |Date           |Description
------------|------------------|---------------|-------------------
3.3.0.1     |Phil Lin          |2019-05-08     |- Add Bind APIs
 */


package com.tutk.IOTC;

import com.tutk.IOTC.util.LoadLibrary;

public class NebulaAPIs {

    public static final int MAX_UDID_LENGTH = 106;
    public static final int MAX_PUBLIC_UDID_LENGTH = 40;
    public static final int MAX_PIN_CODE_LENGTH = 9;
    public static final int MAX_PROFILE_LENGTH = 45000;
    public static final int MAX_REALM_LENGTH = 128;
    public static final int MAX_NEBULA_PSK_LENGTH = 1024;
    public static final int MAX_NEBULA_IDENTITY_LENGTH = 119;
    public static final int MAX_NEBULA_SECRETID_LENGTH = 8;

    public native static String Nebula_Get_Version_String();
    public native static int Nebula_Initialize();
    public native static int Nebula_DeInitialize();
    public native static int Nebula_Device_New(String udid, String secret_id, String profile, NebulaCommandHandleFn command_handler, NebulaIdentityHandleFn identity_handler, NebulaSettingsChangeHandleFn settings_change_handler, long[] device_ctx);
    public native static int Nebula_Device_Login(long device_ctx, NebulaLoginStateHandleFn login_state_handler);
    public native static int Nebula_Device_Bind(long device_ctx, String pin_code, String psk, int timeout_msec, NebulaAbort abort);
    @Deprecated  public native static int Nebula_Device_New_Local_Bind_Message(String udid, String psk, String secret_id, String[] bind_message_string);
    public native static int Nebula_Device_New_Credential(String udid, String identity, String psk, String secret_id, String[] credential);
    public native static int Nebula_Device_Load_Settings(long device_ctx, String settings);
    public native static int Nebula_Device_Delete(long device_ctx);
    public native static int Nebula_Client_New(String public_udid, long[] client_ctx);
    public native static int Nebula_Client_New_From_Struct(NebulaClientInfo client_info, long[] client_ctx);
    public native static int Nebula_Client_New_From_String(String public_udid, String string_data, long[] client_ctx);
    public native static String Nebula_Client_To_String(long client_ctx);
    public native static int Nebula_Client_Bind(long client_ctx, String pin_code, String[] json_response, int timeout_msec, NebulaAbort abort);
    public native static int Nebula_Client_Connect(long client_ctx, NebulaClientConnectStateFn connect_state_handler, int timeout_msec, NebulaAbort abort);
    public native static int Nebula_Client_Send_Command(long client_ctx, String request, String[] response, int timeout_msec, NebulaAbort abort);
    public native static int Nebula_Client_Delete(long client_ctx);

    public native static int Nebula_Device_Push_Notification(long device_ctx, String notification, int timeout_msec, NebulaAbort abort);
    /*public native static int Nebula_Device_Get_Sleep_Packet(long client_ctx, byte[] pattern,
            NebulaSocketProtocol protocol, NebulaWakeUpData data, int timeout_ms);*/
    public native static int Nebula_Client_Wakeup_Device(long client_ctx, int timeout_msec, NebulaAbort abort);
    public native static int Nebula_Client_Check_Device_Online(long client_ctx, int timeout_msec, NebulaAbort abort);
    public native static int Nebula_Set_Log_Attr(St_LogAttr logAttr);


    public interface NebulaCommandHandleFn {
        int command_handler(long device_ctx, String identity, String func, String json_args, String[] json_response);
    }

    public interface NebulaIdentityHandleFn {
        void identity_handler(long device_ctx, String identity, String[] psk, int psk_length);
    }

    public interface NebulaSettingsChangeHandleFn {
        int settings_change_handler(long device_ctx, String settings);
    }

	public interface NebulaLoginStateHandleFn {
        class NebulaDeviceLoginState {
            public static final int NEBULA_DEVLOGIN_ST_CONNECTED = 1;
            public static final int NEBULA_DEVLOGIN_ST_DISCONNECTED = 2;
            public static final int NEBULA_DEVLOGIN_ST_RETRYLOGIN = 4;
        }

        int login_state_handler(long device_ctx, int state);
    }

    public interface NebulaClientConnectStateFn {
        class NebulaClientConnectState {
            public static final int STATE_CONNECTING = 1;
            public static final int STATE_CONNECTED = 2;
            public static final int STATE_DISCONNECTED = 4;
        }
        void connect_state_handler(long client_ctx, int state);
    }

    static {
        LoadLibrary.load("NebulaAPIs");
    }
}

