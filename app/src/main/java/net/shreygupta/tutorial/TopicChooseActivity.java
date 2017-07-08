package net.shreygupta.tutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopicChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_choose);

        Resources res = getResources();
        String[] items = res.getStringArray(R.array.items);

        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(a);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                Intent i = new Intent(TopicChooseActivity.this, ContentActivity.class);
                i.putExtra("position", pos);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {

            SharedPreferences sp = getSharedPreferences("my_sp", MODE_PRIVATE);
            SharedPreferences.Editor e = sp.edit();
            e.apply();
            startActivity(new Intent(TopicChooseActivity.this, MainActivity.class));
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}