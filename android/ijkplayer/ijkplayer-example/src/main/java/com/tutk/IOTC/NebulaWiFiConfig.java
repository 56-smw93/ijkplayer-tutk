
/******************************************************************************
 *                                                                            *
 * Copyright (c) 2019 by TUTK Co.LTD. All Rights Reserved.                    *
 *                                                                            *
 *                                                                            *
 * Class: NebulaWiFiConfig.java                                                       *
 *                                                                            *
 * Author: C.T & Roger                                                         *
 *                                                                            *
 * Date: 2019-04-24                                                           *
 *                                                                            *
 ******************************************************************************/

package com.tutk.IOTC;
import com.tutk.IOTC.util.Uint8;

import java.nio.ByteBuffer;
import java.util.*;

//base on struct  NebulaWiFiConfig.h
public class NebulaWiFiConfig {

    public static final int MAX_WIFI_SSID_LENGTH = 32;
    public static final int MAX_WIFI_PWD_LENGTH = 32;
    public static final int MAX_PUBLIC_UDID_LENGTH = 40;
    public static final int MAX_PIN_CODE_LENGTH = 9;
    public static final int MAX_TIMEZONE_LENGTH = 50;

    private static String byteArrayToString(byte[] data){
        String str = new String(data);
        if(str.indexOf('\0')>0){
            str = str.substring(0,str.indexOf('\0'));
        }
        return str;
    }

    private static ByteBuffer stringToByteBuffer(String data , int maxSize){
        return byteArrayToByteBuffer(data.getBytes(),maxSize);
    }

    private static ByteBuffer byteArrayToByteBuffer(byte[] data , int maxSize){
        if(maxSize < data.length)return null;

        ByteBuffer buffer = ByteBuffer.allocate(maxSize);
        buffer.put(data);
        buffer.position(0);
        return buffer;
    }

    private static byte[] byteBufferToByteArray(ByteBuffer buffer){
        buffer.position(0);
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        return data;
    }

    public enum NebulaAPEncTypeEnum {

        WIFIAPENC_INVALID(0),
        WIFIAPENC_NONE(1),
        WIFIAPENC_WEP(2),
        WIFIAPENC_WPA_TKIP(3),
        WIFIAPENC_WPA_AES(4),
        WIFIAPENC_WPA2_TKIP(5),
        WIFIAPENC_WPA2_AES(6),

        WIFIAPENC_WPA_PSK_TKIP(7),
        WIFIAPENC_WPA_PSK_AES(8),
        WIFIAPENC_WPA2_PSK_TKIP(9),
        WIFIAPENC_WPA2_PSK_AES(10);

        private int value;

        private NebulaAPEncTypeEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static NebulaAPEncTypeEnum toEncType(int value){
            for(NebulaAPEncTypeEnum type : NebulaAPEncTypeEnum.values()){
                if(type.value == value)return type;
            }
            return null;
        }
    }

    public enum NebulaWifiConnectResult {
        WIFICONN_FAIL(0),
        WIFICONN_OK(1),        //device get message,but not connect success
        WIFICONN_SUCCESS(2);

        private int value;

        private NebulaWifiConnectResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static NebulaWifiConnectResult toResult(int value){
            for(NebulaWifiConnectResult result : NebulaWifiConnectResult.values()){
                if(result.value == value)return result;
            }
            return null;
        }
    }

    public enum NebulaSetRegionResult {
        SET_REGION_FAIL(0),
        SET_REGION_SUCCESS(1);

        private int value;

        private NebulaSetRegionResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static NebulaSetRegionResult toResult(int value){
            for(NebulaSetRegionResult result : NebulaSetRegionResult.values()){
                if(result.value == value)return result;
            }
            return null;

        }
    }

    public enum NebulaSetConfigResult {
        SET_REGION_FAIL(0),
        SET_REGION_SUCCESS(1);

        private int value;

        private NebulaSetConfigResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static NebulaSetConfigResult toResult(int value){
            for(NebulaSetConfigResult result : NebulaSetConfigResult.values()){
                if(result.value == value)return result;
            }
            return null;

        }
    }

    public enum NebulaIOCtrlType
    {
        IOCTRL_RESERVE(0),
        IOCTRL_UDID_REQ(1),
        IOCTRL_UDID_RESP(2),
        IOCTRL_SSIDLIST_REQ(3),
        IOCTRL_SSIDLIST_RESP(4),
        IOCTRL_SETWIFI_REQ(5),
        IOCTRL_SETWIFI_RESP(6),
        IOCTRL_SETREGION_REQ(7),
        IOCTRL_SETREGION_RESP(8),
        IOCTRL_NEBULA_BIND_REQ(9),
        IOCTRL_NEBULA_BIND_RESP(10),
        IOTYPE_SETTIMEZONE_REQ(11),
        IOTYPE_SETTIMEZONE_RESP(12),
        IOTYPE_GETFWVERSION_REQ(13),
        IOTYPE_GETFWVERSION_RESP(14),
        IOTYPE_LAN_RESTART_REQ(15),
        IOTYPE_LAN_RESTART_RESP(16),
        IOCTRL_NEBULA_SECRET_ID_REQ(17),
        IOCTRL_NEBULA_SECRET_ID_RESP(18),
        IOCTRL_MSG_MAX_COUNT(19),   //not a msg, just count tutk defined msg count
        IOCTRL_NOT_SUPPORT_MSG(0xFF),
        IOCTRL_USER_DEFINED_START(0x100),
        IOCTRL_USER_DEFINED_END(0xFFFF);

        private int value;

        private NebulaIOCtrlType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public interface NebulaIOCtrlRequest {
        NebulaIOCtrlType getType();
        byte[] toByteArray();
    }

    //IOCTRL_UDID_REQ
    public static class NebulaIOCtrlMsgUDIDReq implements NebulaIOCtrlRequest {
        public byte[] reserve;

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOCTRL_UDID_REQ;
        }

        @Override
        public byte[] toByteArray() {
            return new byte[4];
        }
    }

    //IOCTRL_UDID_RESP
    public static class NebulaIOCtrlMsgUDIDResp {
        public String udid;
        public String pin_code;

        public NebulaIOCtrlMsgUDIDResp(String udid, String pin_code) {
            this.udid = udid;
            this.pin_code = pin_code;
        }

        public NebulaIOCtrlMsgUDIDResp(byte[] message_array) {
            if(message_array==null || message_array.length!=MAX_PUBLIC_UDID_LENGTH+MAX_PIN_CODE_LENGTH + 1)
            {
                this.udid=this.pin_code="";
                return;
            }

            byte[] udid_arr=new byte[MAX_PUBLIC_UDID_LENGTH];
            byte[] pin_code_arr=new byte[MAX_PIN_CODE_LENGTH];

            ByteBuffer data = ByteBuffer.wrap(message_array);
            data.get(udid_arr,0,MAX_PUBLIC_UDID_LENGTH);
            data.get(pin_code_arr,0,MAX_PIN_CODE_LENGTH);

            this.udid=byteArrayToString(udid_arr);
            this.pin_code=byteArrayToString(pin_code_arr);
        }

        public byte[] toByteArray() {
            if(this.udid.length()>MAX_PUBLIC_UDID_LENGTH || this.pin_code.length()>MAX_PIN_CODE_LENGTH)
            {
                return null;
            }

            ByteBuffer buffer = ByteBuffer.allocate(MAX_PUBLIC_UDID_LENGTH+MAX_PIN_CODE_LENGTH);
            buffer.put(stringToByteBuffer(udid,MAX_PUBLIC_UDID_LENGTH));
            buffer.put(stringToByteBuffer(pin_code,MAX_PIN_CODE_LENGTH));
            return byteBufferToByteArray(buffer);



        }
    }

    //IOCTRL_SSIDLIST_REQ
    public static class NebulaIOCtrlMsgSSIDListReq implements NebulaIOCtrlRequest {
        public int max_ap_count;//(uint8_t)

        public NebulaIOCtrlMsgSSIDListReq(int max_ap_count) {
            this.max_ap_count = max_ap_count;
        }

        public NebulaIOCtrlMsgSSIDListReq(byte[] message_array) {
            if(message_array==null || message_array.length!=1)
            {
                this.max_ap_count=-1;
                return;
            }
            this.max_ap_count=message_array[0];
        }

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOCTRL_SSIDLIST_REQ;
        }

        @Override
        public byte[] toByteArray() {
            if(this.max_ap_count > 255)//uint8_t
            {
                return null;
            }
            return Uint8.toByteArray(max_ap_count);
        }
    }

    //IOCTRL_SSIDLIST_RESP
    public static class NebulaIOCtrlMsgSSIDListResp {
        public String ssid;
        public NebulaAPEncTypeEnum enctype;	//refer to NebulaAPEncTypeEnum(uint8_t)

        public NebulaIOCtrlMsgSSIDListResp(String ssid, NebulaAPEncTypeEnum enctype) {
            this.ssid = ssid;
            this.enctype = enctype;
        }
    }

    public static byte[] SSIDListToByteArray(List<NebulaIOCtrlMsgSSIDListResp> ssid_resp_list)//convent NebulaIOCtrlMsgSSIDListResp list to byte array for NebulaGenIOCtrlForBLE()
    {
        int count = ssid_resp_list.size();
        int index=0;
        byte[] array=new byte[(MAX_WIFI_SSID_LENGTH+1+1)*count];
        String tmp_ssid;

        for(int i=0;i<count;i++)
        {
            if(ssid_resp_list.get(i).ssid.length()==0 || ssid_resp_list.get(i).ssid.length()>MAX_WIFI_SSID_LENGTH || ssid_resp_list.get(i).enctype == null)
            {
                //invalid value
                return null;
            }
            tmp_ssid=ssid_resp_list.get(i).ssid;
            System.arraycopy(tmp_ssid.getBytes(),0,array,index,MAX_WIFI_SSID_LENGTH+1);
            index+=MAX_WIFI_SSID_LENGTH+1;
            array[index]=(byte)ssid_resp_list.get(i).enctype.value;
            index+=1;
        }
        return array;
    }

    public static List<NebulaIOCtrlMsgSSIDListResp> ByteArrayToSSIDList(byte[] message_array)//convent byte array to NebulaIOCtrlMsgSSIDListResp list for NebulaHandleIOCtrlFn()
    {
        if(message_array.length%(MAX_WIFI_SSID_LENGTH+1+1)!=0)
        {
            //wrong NebulaIOCtrlMsgSSIDListResp size
            return null;
        }

        int count = (message_array.length)/(MAX_WIFI_SSID_LENGTH+1+1);
        int index=0;
        List<NebulaIOCtrlMsgSSIDListResp> ssid_resp_list=new ArrayList<NebulaIOCtrlMsgSSIDListResp>();
        byte[] tmp_ssid_arr=new byte[MAX_WIFI_SSID_LENGTH+1];
        int tmp_enctype;

        for(int i=0;i<count;i++)
        {
            System.arraycopy(message_array,index,tmp_ssid_arr,0,MAX_WIFI_SSID_LENGTH+1);
            index += MAX_WIFI_SSID_LENGTH+1;
            tmp_enctype = message_array[index];
            index += 1;

            ssid_resp_list.add(new NebulaIOCtrlMsgSSIDListResp((byteArrayToString(tmp_ssid_arr)),NebulaAPEncTypeEnum.toEncType(tmp_enctype)));
        }

        return ssid_resp_list;
    }

    //IOCTRL_SETWIFI_REQ
    public static class NebulaIOCtrlMsgSetWifiReq implements NebulaIOCtrlRequest {
        public String ssid;
        public String password;
        public NebulaAPEncTypeEnum enctype;	//refer to NebulaAPEncTypeEnum(uint8_t)

        public NebulaIOCtrlMsgSetWifiReq(NebulaIOCtrlMsgSSIDListResp wifi, String password) {
            this.ssid = wifi.ssid;
            this.password = password;
            this.enctype = wifi.enctype;
        }

        public NebulaIOCtrlMsgSetWifiReq(String ssid, String password,NebulaAPEncTypeEnum enctype) {
            this.ssid = ssid;
            this.password = password;
            this.enctype = enctype;
        }

        public NebulaIOCtrlMsgSetWifiReq(byte[] message_array) {
            if(message_array==null || message_array.length!=MAX_WIFI_SSID_LENGTH+1+MAX_WIFI_PWD_LENGTH+1+1)
            {
                this.ssid=this.password="";
                this.enctype=null;
                return;
            }
            byte[] ssid_arr=new byte[MAX_WIFI_SSID_LENGTH+1];
            byte[] pwd_arr=new byte[MAX_WIFI_PWD_LENGTH+1];
            System.arraycopy(message_array,0,ssid_arr,0,MAX_WIFI_SSID_LENGTH+1);
            System.arraycopy(message_array,MAX_WIFI_SSID_LENGTH+1,pwd_arr,0,MAX_WIFI_PWD_LENGTH+1);

            this.ssid=byteArrayToString(ssid_arr);
            this.password=byteArrayToString(pwd_arr);
            this.enctype= NebulaAPEncTypeEnum.toEncType(message_array[MAX_WIFI_SSID_LENGTH+1+MAX_WIFI_PWD_LENGTH+1]);
        }

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOCTRL_SETWIFI_REQ;
        }

        @Override
        public byte[] toByteArray() {
            if(this.ssid.length()>MAX_WIFI_SSID_LENGTH || this.password.length()>MAX_WIFI_PWD_LENGTH || enctype == null)
            {
                return null;
            }
            ByteBuffer buffer = ByteBuffer.allocate(MAX_WIFI_SSID_LENGTH+1+MAX_WIFI_PWD_LENGTH+1+1);
            buffer.put(stringToByteBuffer(ssid,MAX_WIFI_SSID_LENGTH+1));
            buffer.put(stringToByteBuffer(password,MAX_WIFI_PWD_LENGTH+1));
            return byteBufferToByteArray(buffer);
        }
    }

    //IOCTRL_SETWIFI_RESP
    public static class NebulaIOCtrlMsgSetWifiResp {
        public String ssid;
        public NebulaWifiConnectResult result;	//refer to NebulaWifiConnectResult(uint8_t)

        public NebulaIOCtrlMsgSetWifiResp(String ssid,NebulaWifiConnectResult result) {
            this.ssid = ssid;
            this.result=result;
        }

        public NebulaIOCtrlMsgSetWifiResp(byte[] message_array) {
            if(message_array==null || message_array.length!=MAX_WIFI_SSID_LENGTH+1+1)
            {
                this.ssid="";
                this.result = null;
                return;
            }

            byte[] ssid_arr=new byte[MAX_WIFI_SSID_LENGTH+1];
            System.arraycopy(message_array,0,ssid_arr,0,MAX_WIFI_SSID_LENGTH+1);
            this.ssid=byteArrayToString(ssid_arr);
            this.result = NebulaWifiConnectResult.toResult(message_array[MAX_WIFI_SSID_LENGTH+1]);
        }

        public byte[] toByteArray() {
            if(ssid.length()>MAX_WIFI_SSID_LENGTH || result == null) return null;

            ByteBuffer buffer = ByteBuffer.allocate(MAX_WIFI_SSID_LENGTH+1+1);
            buffer.put(stringToByteBuffer(ssid,MAX_WIFI_SSID_LENGTH+1));
            buffer.put(Uint8.toByteBuffer(result.value));
            return byteBufferToByteArray(buffer);


        }
    }


    //IOCTRL_SETREGION_REQ
    public static class NebulaIOCtrlMsgSetRegionReq implements NebulaIOCtrlRequest {
        public TUTKRegion tutk_region;	//refer to TUTKRegion(uint8_t)

        public NebulaIOCtrlMsgSetRegionReq(TUTKRegion tutk_region) {
            this.tutk_region = tutk_region;
        }

        public NebulaIOCtrlMsgSetRegionReq(byte[] message_array) {
            if(message_array==null || message_array.length!=1)
            {
                this.tutk_region=null;
                return;
            }
            this.tutk_region = TUTKRegion.toRegion(message_array[0]);
        }

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOCTRL_SETREGION_REQ;
        }

        public byte[] toByteArray() {
            if(tutk_region==null)return null;
            return Uint8.toByteArray(tutk_region.getValue());
        }
    }

    //IOCTRL_SETREGION_RESP
    public static class NebulaIOCtrlMsgSetRegionResp {
        public NebulaSetRegionResult result;	//refer to NebulaSetRegionResult(uint8_t)

        public NebulaIOCtrlMsgSetRegionResp(NebulaSetRegionResult result) {
            this.result = result;
        }

        public NebulaIOCtrlMsgSetRegionResp(byte[] message_array) {
            if(message_array==null || message_array.length!=1)
            {
                this.result=null;
                return;
            }
            this.result = NebulaSetRegionResult.toResult(message_array[0]);
        }

        public byte[] toByteArray() {
            if(result==null)return null;
            return Uint8.toByteArray(result.value);
        }
    }


    //IOCTRL_NEBULA_BIND_REQ
    public static class NebulaBindIOCtrlRequest implements NebulaIOCtrlRequest {
        public byte[] reserve;

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOCTRL_NEBULA_BIND_REQ;
        }

        @Override
        public byte[] toByteArray() {
            return new byte[4];
        }
    }

    //IOCTRL_NEBULA_BIND_RESP
    public static class NebulaIOCtrlMsgNebulaBindResp {
        public String bind_cipher;

        public NebulaIOCtrlMsgNebulaBindResp(String bind_cipher) {
            this.bind_cipher = bind_cipher;
        }

        public NebulaIOCtrlMsgNebulaBindResp(byte[] message_array) {
            if(message_array==null)
            {
                this.bind_cipher="";
                return;
            }

            byte[] bind_arr=new byte[message_array.length];

            ByteBuffer data = ByteBuffer.wrap(message_array);
            data.get(bind_arr,0,message_array.length);

            this.bind_cipher=byteArrayToString(bind_arr);
        }

        public byte[] toByteArray() {

            ByteBuffer buffer = ByteBuffer.allocate(this.bind_cipher.length());
            buffer.put(stringToByteBuffer(bind_cipher,this.bind_cipher.length()));
            return byteBufferToByteArray(buffer);
        }
    }

    public static class NebulaIOCtrlMsgNebulaSecretIdReq implements NebulaIOCtrlRequest {
        public byte[] reserve;

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOCTRL_NEBULA_SECRET_ID_REQ;
        }

        @Override
        public byte[] toByteArray() {
            return new byte[4];
        }
    }

    public static class NebulaIOCtrlMsgNebulaSecretIdResp {
        public String secret_id;

        public NebulaIOCtrlMsgNebulaSecretIdResp(String secret_id) {
            this.secret_id = secret_id;
        }

        public NebulaIOCtrlMsgNebulaSecretIdResp(byte[] message_array) {
            if(message_array==null)
            {
                this.secret_id="";
                return;
            }

            byte[] bind_arr=new byte[message_array.length];

            ByteBuffer data = ByteBuffer.wrap(message_array);
            data.get(bind_arr,0,message_array.length);

            this.secret_id=byteArrayToString(bind_arr);
        }

        public byte[] toByteArray() {

            ByteBuffer buffer = ByteBuffer.allocate(secret_id.length());
            buffer.put(stringToByteBuffer(secret_id,secret_id.length()));
            return byteBufferToByteArray(buffer);
        }
    }

    //IOTYPE_SETTIMEZONE_REQ
    public static class NebulaIOCtrlMsgTimeZoneReq implements NebulaIOCtrlRequest {
        public String timezone;

        public NebulaIOCtrlMsgTimeZoneReq(String timezone) {
            this.timezone = timezone;
        }

        public NebulaIOCtrlMsgTimeZoneReq(byte[] message_array) {
            if(message_array==null || message_array.length!=MAX_TIMEZONE_LENGTH + 1)
            {
                this.timezone="";
                return;
            }

            byte[] timezone_arr=new byte[MAX_TIMEZONE_LENGTH];

            ByteBuffer data = ByteBuffer.wrap(message_array);
            data.get(timezone_arr,0,MAX_TIMEZONE_LENGTH);

            this.timezone=byteArrayToString(timezone_arr);
        }

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOTYPE_SETTIMEZONE_REQ;
        }

        @Override
        public byte[] toByteArray() {
            if(this.timezone.length()>MAX_TIMEZONE_LENGTH)
            {
                return null;
            }

            ByteBuffer buffer = ByteBuffer.allocate(MAX_TIMEZONE_LENGTH);
            buffer.put(stringToByteBuffer(timezone,MAX_TIMEZONE_LENGTH));
            return byteBufferToByteArray(buffer);



        }
    }

    //IOTYPE_SETTIMEZONE_RESP
    public static class NebulaIOCtrlMsgTimeZoneResp {
        public NebulaSetConfigResult result;    //refer to NebulaSetConfigResult(uint8_t)

        public NebulaIOCtrlMsgTimeZoneResp(NebulaSetConfigResult result) {
            this.result = result;
        }

        public NebulaIOCtrlMsgTimeZoneResp(byte[] message_array) {
            if(message_array==null || message_array.length!=1)
            {
                this.result=null;
                return;
            }
            this.result = NebulaSetConfigResult.toResult(message_array[0]);
        }

        public byte[] toByteArray() {
            if(result==null)return null;
            return Uint8.toByteArray(result.value);
        }
    }

    //IOTYPE_GETFWVERSION_REQ
    public static class NebulaIOCtrlMsgGetFWVersionReq implements NebulaIOCtrlRequest {
        public byte[] reserve;

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOTYPE_GETFWVERSION_REQ;
        }

        @Override
        public byte[] toByteArray() {
            return new byte[4];
        }
    }
    //IOTYPE_GETFWVERSION_RESP
    public static class NebulaIOCtrlMsgGetFWVersionResp {
        public String fw_version;

        public NebulaIOCtrlMsgGetFWVersionResp(String fw_version) {
            this.fw_version = fw_version;
        }

        public NebulaIOCtrlMsgGetFWVersionResp(byte[] message_array) {
            if(message_array==null)
            {
                this.fw_version="";
                return;
            }

            byte[] version_arr=new byte[message_array.length];

            ByteBuffer data = ByteBuffer.wrap(message_array);
            data.get(version_arr,0,message_array.length);

            this.fw_version=byteArrayToString(version_arr);
        }

        public byte[] toByteArray() {

            ByteBuffer buffer = ByteBuffer.allocate(this.fw_version.length());
            buffer.put(stringToByteBuffer(fw_version,this.fw_version.length()));
            return byteBufferToByteArray(buffer);
        }
    }

    //IOTYPE_LAN_RESTART_REQ
    public static class NebulaIOCtrlMsgLanRestartReq implements NebulaIOCtrlRequest {
        public byte[] reserve;

        @Override
        public NebulaIOCtrlType getType() {
            return NebulaIOCtrlType.IOTYPE_LAN_RESTART_REQ;
        }

        @Override
        public byte[] toByteArray() {
            return new byte[4];
        }
    }
    //IOTYPE_LAN_RESTART_RESP
    public static class NebulaIOCtrlMsgLanRestartResp {
        public NebulaSetConfigResult result;    //refer to NebulaSetConfigResult(uint8_t)

        public NebulaIOCtrlMsgLanRestartResp(NebulaSetConfigResult result) {
            this.result = result;
        }

        public NebulaIOCtrlMsgLanRestartResp(byte[] message_array) {
            if(message_array==null || message_array.length!=1)
            {
                this.result=null;
                return;
            }
            this.result = NebulaSetConfigResult.toResult(message_array[0]);
        }

        public byte[] toByteArray() {
            if(result==null)return null;
            return Uint8.toByteArray(result.value);
        }
    }
    
}
