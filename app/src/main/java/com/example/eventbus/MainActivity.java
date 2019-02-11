package com.example.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.eventbus.TypesOfMessage.MessageEvent;
import com.example.eventbus.TypesOfMessage.StickyMessage;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button launchButton;

    /*documentation
        http://greenrobot.org/eventbus/
        https://code.tutsplus.com/articles/effective-android-components-communication-with-greenrobot-eventbus--cms-27654
    */

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        textView = findViewById(R.id.textView);
        launchButton = findViewById(R.id.button);
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class );
                startActivity(intent);
            }
        });
    }

    // Within the same delivery thread, higher priority(2) subscribers will receive events before others with a lower priority(1)
    @Subscribe (priority = 2) //first
    public void onEvent(MessageEvent event){
        textView.setText("Priority 2: " + event.getCustomMessage());
    }
    @Subscribe (priority = 1, threadMode = ThreadMode.BACKGROUND) //second
    public void onEvent2(MessageEvent event){
        textView.append(" Priority 1: " + event.getCustomMessage());
    }

    /* Register and unregister
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onStickyEvent(StickyMessage event) {
        textView.setText(event.getStickyMessage());
    }
}
