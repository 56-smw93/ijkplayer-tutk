package com.tutk.IOTC;

public class NebulaError {

    /** The function is performed successfully. */
    public static final int NEBULA_ER_NoERROR                           =0;

    public static final int API_ER_ANDROID_NULL                         =-100000;

    /** Nebula module has not been initialized */
    public static final int NEBULA_ER_NOT_INITIALIZE                    =-40000;

    /** The specified timeout has expired during some operation */
    public static final int NEBULA_ER_TIMEOUT                           =-40001;

    /** The passed-in arguments for the function are incorrect */
    public static final int NEBULA_ER_INVALID_ARG                       =-40002;

    /** The passed-in UDID for the function is incorrect */
    public static final int NEBULA_ER_INVALID_UDID                      =-40003;

    /** An error occurred during the http connection */
    public static final int NEBULA_ER_HTTP_ERROR                        =-40004;

    /** Failed to create threads. Please check if OS has ability to create threads */
    public static final int NEBULA_ER_FAIL_CREATE_THREAD                =-40005;

    /** Insufficient memory for allocation */
    public static final int NEBULA_ER_MEM_INSUFFICIENT                  =-40006;

    /** Failed to login to bridge server */
    public static final int NEBULA_ER_BRIDGE_SERVER_LOGIN_FAIL          =-40007;

    /** Nebula module has some resource allocating problem.*/
    public static final int NEBULA_ER_RESOURCE_ERROR                    =-40008;

    /** Failed to login to binding server */
    public static final int NEBULA_ER_BIND_SERVER_LOGIN_FAIL            =-40009;

    /** The passed-in buffer size is insufficient for the device token */
    public static final int NEBULA_ER_TOKEN_BUF_SIZE_INSUFFICIENT       =-40010;

    /** Device can not get rental UID */
    public static final int NEBULA_ER_RENT_UID_FAILED                   =-40011;

    /** The token for device to rent UID is invalid */
    public static final int NEBULA_ER_INVALID_TOKEN                     =-40012;

    /** The validity period of token for device to rent UID is expired */
    public static final int NEBULA_ER_TOKEN_EXPIRED                     =-40013;

    /** The passed-in command is not defined */
    public static final int NEBULA_ER_UNKNOWN_COMMAND                   =-40014;

    /** The http connection timeout */
    public static final int NEBULA_ER_HTTP_TIMEOUT                      =-40015;

    /** Device not login to bridge server */
    public static final int NEBULA_ER_BRIDGE_SERVER_NOT_LOGIN           =-40016;

    /** Client not bind to device */
    public static final int NEBULA_ER_CLIENT_NOT_BIND_TO_DEVICE         =-40017;

    /** Unknow status */
    public static final int NEBULA_ER_UNKNOW_STATUS                     =-40018;

    public static final int NEBULA_ER_DEVICE_ONLINE                     =-40019;

    public static final int NEBULA_ER_DEVICE_OFFLINE                    =-40020;

    public static final int NEBULA_ER_DEVICE_SLEEPING                   =-40021;

    public static final int NEBULA_ER_DEVICE_AWAKENING                  =-40022;
	
	//public static final int NEBULA_ER_CLIENT_COMMAND_IN_PROGRESS        =-40023;

    public static final int NEBULA_ER_INVALID_PIN_CODE                  =-40024;

    public static final int NEBULA_ER_INVALID_REALM                     =-40025;
	
	public static final int NEBULA_ER_NO_NOTIFICATION_LIST              =-40026;

    public static final int NEBULA_ER_LOGIN_ALREADY_CALLED              =-40027;
	
	public static final int NEBULA_ER_CONNECT_REFUSED              		=-40028;

	public static final int NEBULA_ER_DEVICE_FORCE_STOP                 =-40029;

    public static final int NEBULA_ER_CLIENT_FORCE_STOP                 =-40030;

    public static final int NEBULA_ER_INVALID_PSK                       =-40031;

    public static final int NEBULA_ER_ALREADY_INITIALIZED               =-40032;

    public static final int NEBULA_ER_INVALID_SECRETID                  =-40033;

    public static final int NEBULA_ER_DUPLICATE                         =-40034;

    public static final int NEBULA_ER_NO_SUCH_ENTRY                     =-40035;

    public static final int NEBULA_ER_FORCE_STOP                        =-40036;

    public static final int NEBULA_ER_INVALID_NODE                      =-40037;

    public static final int NEBULA_ER_SYNTAX_ERROR                      =-40038;

    public static final int NEBULA_ER_IOTC_LOGIN_ERROR                  =-40039;
    
    public static final int NEBULA_ER_RETRY                             =-40040;

    /** Buffer size too small */
    public static final int NEBULA_ER_EXCEED_BUFFER_SIZE                =-41001;

    /** Unknow message */
    public static final int NEBULA_ER_UNKNOW_MESSAGE                    =-41002;

    /** Message type and length not match */
    public static final int NEBULA_ER_MESSAGE_CHECK_FAIL                =-41003;

    /** Nebula Deivce not start */
    public static final int NEBULA_ER_BLE_DEVICE_NOT_READY              =-41007;

    /** Nebula Deivce callback function is NULL */
    public static final int NEBULA_ER_BLE_CALLBACK_IS_NULL              =-41008;

    /** Unknow UUID */
    public static final int NEBULA_ER_BLE_UNKNOW_UUID                   =-41009;

    /** BLE service is still woring */
    public static final int NEBULA_ER_BLE_SERVICE_NOT_STOP              =-41010;

	/** Unknow BLE status */
	public static final int NEBULA_ER_BLE_UNKNOW_STATUS                 =-41011;

    /** An error occurred while creating socket*/
    public static final int NEBULA_ER_SOCKET_CREATE_FAIL                =-42001;

    /** An error occurred while creating socket*/
    public static final int NEBULA_ER_SOCKET_ERROR                      =-42002;

    /** TCP connection not created yet*/
    public static final int NEBULA_ER_TCP_CONNECTION_NOT_CREATE         =-42003;

    /** There already a TCP connection created*/
    public static final int NEBULA_ER_TCP_ALREADY_CONNECTED             =-42004;

    /** JSON object is not this type*/
    public static final int NEBULA_ER_JSON_OBJ_TYPE_ERROR               =-43001;

    /** JSON object add data error*/
    public static final int NEBULA_ER_JSON_OBJ_ADD_ERROR                =-43002;

    /** object is not exist in JSON*/
    public static final int NEBULA_ER_JSON_OBJ_NOT_EXIST                =-43003;

    /** JSON array operate error*/
    public static final int NEBULA_ER_JSON_OBJ_ARRAY_ERROR              =-43004;
}