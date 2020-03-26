package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditShoppingList extends AppCompatActivity {
    ArrayList<CheckedShoppingListItem> list = new ArrayList<>();
    CustomShoppingListAdaptor adapter;
    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shopping_list);

        input = (EditText)findViewById(R.id.textView3);

        adapter = new CustomShoppingListAdaptor(list,this);

        //adapter = new ArrayAdapter<String>(this,R.layout.main_listview, R.id.textView, list );
        ListView listView = (ListView)findViewById(R.id.shoppingListView);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    public void addItemClick(View view) {
        list.add(new CheckedShoppingListItem(input.getText().toString()));
        adapter.notifyDataSetChanged();
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
