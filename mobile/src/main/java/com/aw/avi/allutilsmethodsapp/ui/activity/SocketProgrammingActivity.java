package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.aw.avi.allutilsmethodsapp.R;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocketProgrammingActivity extends AppCompatActivity {
    //    public static final String SOCKET_URL = "wss://streamer.cryptocompare.com";
    public static final String SOCKET_URL = "http://chat.socket.io";
public static final String TAG="SocketProgramming";

    @BindView(R.id.tv_rates)
    TextView tvRates;
    private Socket mSocket;
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            String data = (String) args[0];
            Log.d(TAG, data);
//            Toast.makeText(this, "" + data, Toast.LENGTH_SHORT).show();
        }
    };

    {
        try {
            mSocket = IO.socket(SOCKET_URL);
            Log.d(TAG, "mSocket connected");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_programming);
        ButterKnife.bind(this);
//        try {
//            mSocket = IO.socket(SOCKET_URL);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        mSocket.on("new message", onNewMessage);
        mSocket.connect();
        mSocket.open();
//        mSocket.emit('SubAdd', ['0~Poloniex~BTC~USD']  );
//        mSocket.emit("SubAdd", "['0~Poloniex~BTC~USD']");
//        mSocket.emit("new message", "['0~Poloniex~BTC~USD']");


    }

    private void attemptSend() {
//        String message = mInputMessageView.getText().toString().trim();
//        if (TextUtils.isEmpty(message)) {
//            return;
//        }
//
//        mInputMessageView.setText("");
        mSocket.emit("new message", "Avi");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();
        mSocket.off("new message", onNewMessage);
    }
}
