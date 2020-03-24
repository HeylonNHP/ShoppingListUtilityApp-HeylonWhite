package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.main_listview, R.id.textView, new String[]{"one","two"} );
        ListView listView = (ListView)findViewById(R.id.shopping_list_view);
        listView.setAdapter(adapter);
    }
}
