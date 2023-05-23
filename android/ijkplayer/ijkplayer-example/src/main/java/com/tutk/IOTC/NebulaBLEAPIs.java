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

public class NebulaBLEAPIs {

	/*IOCtrl function for BLE connect*/
	public native static int Nebula_BLE_Get_Service_Info(String[] uuid);
	public native static int Nebula_BLE_Get_Characteristic_IOCtrl_Info(String[] uuid, int[] property);
	public native static int Nebula_BLE_Get_Characteristic_Net_Status_Info(String[] uuid, int[] property);
	public native static int Nebula_BLE_Client_Generate_IOCtrl_Message(int type, byte[] ioctrl_byte_array, byte[] message_buf);
	public native static int Nebula_BLE_Client_Restore_IOCtrl_Message(String characteristic_uuid, byte[] recv_buf, int data_len, NebulaHandleIOCtrlFn HandleIOCtrl);

	public interface NebulaHandleIOCtrlFn {
		void IOCtrlHandler(int type, byte[] ioctrl_buf, int ioctrl_len);
	}

    static {
        LoadLibrary.load("NebulaAPIs");
    }
}
