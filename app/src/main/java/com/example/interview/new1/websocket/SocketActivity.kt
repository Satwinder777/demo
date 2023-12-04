package com.example.interview.new1.websocket

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.interview.databinding.ActivitySocketBinding
import com.piesocket.channels.Channel
import com.piesocket.channels.PieSocket
import com.piesocket.channels.misc.PieSocketEvent
import com.piesocket.channels.misc.PieSocketEventListener
import com.piesocket.channels.misc.PieSocketOptions
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class SocketActivity : AppCompatActivity() {

    lateinit var binding: ActivitySocketBinding
    lateinit var pieSocket: PieSocket
    lateinit var channel: Channel
    lateinit var webSocket: WebSocket
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySocketBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var pieSocketOption = PieSocketOptions()
//
//        pieSocketOption.clusterId = "free.blr2"
//        pieSocketOption.apiKey = "p3X3pnu2uqlblhxiFhJMwK80ONeRmJJZe4vppwbQ"
//
//        pieSocket = PieSocket(pieSocketOption)
//        channel = pieSocket.join("roomId")

        var okHttpClient = OkHttpClient()
//        okHttpClient.


                binding.startsk.setOnClickListener{


                    webSocket =okHttpClient.newWebSocket(createRequest(),websocketlistener())
                }
        binding.sendbtn.setOnClickListener {
            var text =binding.et1.text.toString()
            webSocket.send(text)
        }

        binding.closesk.setOnClickListener {
//            var text =binding.et1.text.toString()
            webSocket.close(1000,"not reason for cloing socket")
        }



    }
    fun createRequest():Request{
        var  request ="wss://free.blr2.piesocket.com/v3/1?api_key=p3X3pnu2uqlblhxiFhJMwK80ONeRmJJZe4vppwbQ&notify_self=1"
        return Request.Builder().url(request).build()
    }
   inner class websocketlistener: WebSocketListener(){
        override fun onOpen(webSocket: WebSocket, response: Response) {
            super.onOpen(webSocket, response)
            webSocket.send("Web Socked Open call")
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosed(webSocket, code, reason)
//            Toast.makeText(this@SocketActivity, "webSocket closed!!", Toast.LENGTH_SHORT).show()
            Log.e("testedcase11", "onClosed: webSocket closed!!", )
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            super.onFailure(webSocket, t, response)
//            Toast.makeText(this@SocketActivity, "webSocket Failer!", Toast.LENGTH_SHORT).show()
            Log.e("testedcase11", "onClosed: webSocket failer>>${t.message}!!", )

        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            super.onMessage(webSocket, text)
//            Toast.makeText(this@SocketActivity, "msg >>$text" , Toast.LENGTH_SHORT).show()
            Log.e("testedcase11", "onClosed: satta >>$text", )

        }
    }

}


