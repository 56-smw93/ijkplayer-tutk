package com.tutk.IOTC;

import java.util.ArrayList;

public class NebulaAbort {
    private ArrayList<Long> mAbortTargets = new ArrayList<>();
    private boolean mAbort = false;

    synchronized public void abort() {
        mAbort = true;
        for (long target : mAbortTargets) {
            Nebula_API_Abort(target);
        }
    }

    synchronized private void onAvailable(long abort) {
        if (mAbort) {
            Nebula_API_Abort(abort);
        } else {
            mAbortTargets.add(abort);
        }
    }

    synchronized private void onUnavailable(long abort) {
        mAbortTargets.remove(abort);
    }

    private native void Nebula_API_Abort(long abort);
}
