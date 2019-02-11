package com.example.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eventbus.TypesOfMessage.MessageEvent;
import com.example.eventbus.TypesOfMessage.StickyMessage;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {

    private Button btnNormal, btnSticky;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        message = findViewById(R.id.editText);

        btnNormal = findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = message.getText().toString();
                if (userText.equals("")){
                    EventBus.getDefault().post(new MessageEvent("Hejo"));
                } else {
                    EventBus.getDefault().post(new MessageEvent(userText));
                }
                finish();
            }
        });

        btnSticky = findViewById(R.id.btnSticky);
        btnSticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new StickyMessage("This is sticky message"));
                finish();
            }
        });
    }
}
