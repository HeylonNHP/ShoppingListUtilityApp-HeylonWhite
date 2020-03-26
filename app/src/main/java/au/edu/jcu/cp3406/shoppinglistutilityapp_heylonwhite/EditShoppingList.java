package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditShoppingList extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter adapter;
    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shopping_list);

        input = (EditText)findViewById(R.id.textView3);


        adapter = new ArrayAdapter<String>(this,R.layout.main_listview, R.id.textView, list );
        ListView listView = (ListView)findViewById(R.id.shoppingListView);
        listView.setAdapter(adapter);

    }

    public void addItemClick(View view) {
        list.add(input.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
