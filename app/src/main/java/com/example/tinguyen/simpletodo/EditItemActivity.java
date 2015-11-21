package com.example.tinguyen.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {
    private final int RESULT_OK = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String textitem = getIntent().getStringExtra("todoitem");
        TextView tvItem = (TextView) findViewById(R.id.etEditItem);
        tvItem.append(textitem);
        tvItem.requestFocus();


    }

    public void onSaveItem(View v) {
        EditText etName = (EditText) findViewById(R.id.etEditItem);
        int main_pos = getIntent().getIntExtra("itempos", 0);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", etName.getText().toString());
        data.putExtra("pos",main_pos);
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        this.finish(); // closes the activity, pass data to parent

    }
}
