package com.tutk.IOTC;

import com.tutk.IOTC.util.LoadLibrary;

public class TUTKGlobalAPIs {
    /** The function is performed successfully. */
    public static final int TUTK_ER_NoERROR = 0;

    /** TUTK module(IOTC, Nebula) is already initialized.*/
    public static final int TUTK_ER_ALREADY_INITIALIZED = -1001;

    /** The arguments passed to a function is invalid. */
    public static final int TUTK_ER_INVALID_ARG = -1002;

    /** The arguments passed to a function is invalid. */
    public static final int TUTK_ER_MEM_INSUFFICIENT = -1003;

    /** The arguments passed to a function is invalid. */
    public static final int TUTK_ER_INVALID_LICENSE_KEY = -1004;

    public native static String TUTK_Get_Version_String();

    public native static int TUTK_Set_Log_Attr(St_LogAttr logAttr);

    public native static int TUTK_SDK_Set_Region(TUTKRegion region);

    public native static int TUTK_SDK_Set_License_Key(String key);

    public native static int TUTK_SDK_Set_Region_Code(String region);

    static {
        LoadLibrary.load("TUTKGlobalAPIs");
    }
}
