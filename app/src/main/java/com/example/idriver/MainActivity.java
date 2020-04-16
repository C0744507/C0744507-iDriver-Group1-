package com.example.idriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button ruleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ruleBtn = findViewById(R.id.rule_btn);


        ruleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivity.this, RulePage.class);
                startActivity(Intent);
            }
        });

    }
}