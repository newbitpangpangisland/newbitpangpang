package com.example.newbitpangpang;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainrecyclerView;

    private MainAdator mAdator;
    private List<Board> mBoardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainrecyclerView = findViewById(R.id.main_recycler_view);
        findViewById(R.id.main_write_button).setOnClickListener((View.OnClickListener) this);

        mBoardList = new ArrayList<>();
        mBoardList.add(new Board(null, "hello1", null, "b"));
        mBoardList.add(new Board(null, "hello11", null, "c"));
        mBoardList.add(new Board(null, "hello111", null, "d"));
        mBoardList.add(new Board(null, "hello1111", null, "e"));

        mAdator = new MainAdator(mBoardList);
        mMainrecyclerView.setAdapter(mAdator);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void onclick(View v) {

    }

    private class MainAdator extends RecyclerView.Adapter<MainAdator.MainViewHolder> {

        private List<Board> mBoardList;

        public MainAdator(List<Board> mBoardList) {
            this.mBoardList = mBoardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = mBoardList.get(position);
            holder.mTitleView.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder {


            private TextView mTitleView;
            private TextView mNameTextView;

            public MainViewHolder(@NonNull View itemView) {
                super(itemView);

                mTitleView = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_text);

            }
        }
    }

    //나중에ㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔ작업 안한 부분임 초기 설정..................
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
}