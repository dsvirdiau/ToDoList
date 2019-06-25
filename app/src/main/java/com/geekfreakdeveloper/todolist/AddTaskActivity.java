package com.geekfreakdeveloper.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.backToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //Linking objects
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.toDoListArray.add(editText.getText().toString());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


}
