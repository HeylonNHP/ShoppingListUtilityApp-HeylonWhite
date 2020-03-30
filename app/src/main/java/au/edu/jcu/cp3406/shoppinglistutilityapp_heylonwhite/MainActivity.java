package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.main_listview, R.id.textView, list );
        ListView listView = (ListView)findViewById(R.id.shopping_list_view);
        listView.setAdapter(adapter);

        ArrayList<CheckedShoppingListItem> items = Preferences.loadShoppingList(getSharedPreferences(Preferences.preferencesName,MODE_PRIVATE));

        if(null != items){
            for (CheckedShoppingListItem item: items) {
                if(item.isChecked()){
                    list.add(item.getName());
                }
            }
        }
    }

    public void editShoppingListClick(View view){
        Intent intent = new Intent(this,EditShoppingList.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
    }
}
