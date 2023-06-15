package tv.danmaku.ijk.webrtc

import android.content.Context
import android.util.Log
import org.webrtc.IceCandidate
import org.webrtc.SessionDescription
import tv.danmaku.ijk.media.example.webrtc.NebulaRTCClient

private const val TAG = "ConnectToNeb"

class ConnectToNeb constructor(val context: Context): AppRTCClient.SignalingEvents {

    lateinit var mRtcClient: AppRTCClient

    fun sendCommand(nebulaAPIs: NebulaInterface, command: String): String {
        if(!this::mRtcClient.isInitialized) {
            mRtcClient = NebulaRTCClient(context,this,nebulaAPIs)
        }
        return mRtcClient.sendCustomCommand(command)
    }

    override fun onConnectedToRoom(params: AppRTCClient.SignalingParameters?) {
        Log.i(TAG,"smw: onConnectedToRoom: $params \n")
    }

    override fun onRemoteDescription(sdp: SessionDescription?) {
        Log.i(TAG,"smw: onRemoteDescription")
    }

    override fun onRemoteIceCandidate(candidate: IceCandidate?) {
        Log.i(TAG,"smw: onRemoteIceCandidate")
    }

    override fun onRemoteIceCandidatesRemoved(candidates: Array<out IceCandidate>?) {
        Log.i(TAG,"smw: onRemoteIceCandidatesRemoved")
    }

    override fun onChannelClose() {
        Log.i(TAG,"smw: onChannelClose")
    }

    override fun onChannelError(description: String?) {
        Log.i(TAG,"smw: onChannelError")
    }
}