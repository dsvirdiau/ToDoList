package com.geekfreakdeveloper.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView toDoListRecycler;
    static ArrayList<String> toDoListArray = new ArrayList<String>();

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking objects
        toDoListRecycler = (RecyclerView) findViewById(R.id.recyclerView);
        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        //Toolbar
        setSupportActionBar(mToolbar);

        //RecyclerView layout manager
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        toDoListRecycler.setLayoutManager(recyclerLayoutManager);

        //RecyclerView item decorator
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(toDoListRecycler.getContext(),
                                                                                    recyclerLayoutManager.getOrientation());
        toDoListRecycler.addItemDecoration(dividerItemDecoration);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getList(), this);
        toDoListRecycler.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        toDoListArray.clear();
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent myIntent = new Intent(MainActivity.this, AddTaskActivity.class);
            MainActivity.this.startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> getList()
    {
        toDoListArray.add("Try to add more items using + sign");

        return toDoListArray;
    }
}
