package com.example.robin.adminpanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showcom extends AppCompatActivity {

    TextView textView1,textView2,fortype,fordate;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcom);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        String id = bundle.getString("cid");
        String type = bundle.getString("type");
        String date = bundle.getString("date");
        textView1= findViewById(R.id.showid);
        textView2 = findViewById(R.id.details);
        fortype = findViewById(R.id.type);
        fordate = findViewById(R.id.date);
        button = findViewById(R.id.assign);

        textView1.setText(id);
        textView2.setText(message);
        fortype.setText(type);
        fordate.setText(date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Showcom.this,Tech.class);
                startActivity(intent);
            }
        });


    }
}
