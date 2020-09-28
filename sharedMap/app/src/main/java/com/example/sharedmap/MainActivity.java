package com.example.sharedmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton Menu;
    Button Map, Community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Menu=(ImageButton)findViewById(R.id.menu);
        Map=(Button)findViewById(R.id.map);
        Community=(Button)findViewById(R.id.community);

        //지도버튼 눌렀을 경우
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                GoogleMap googleMap = new GoogleMap();
                transaction.replace(R.id.frame, googleMap);
            }
        });
        //커뮤니티버튼 눌렀을 경우
        Community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                CommunityMenu communityMenu = new CommunityMenu();
                transaction.replace(R.id.frame, communityMenu);
            }
        });
    }
}
