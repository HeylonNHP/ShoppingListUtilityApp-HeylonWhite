package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

        //Restore activity state
        SharedPreferences sharedPreferences = getSharedPreferences(Preferences.preferencesName, MODE_PRIVATE);
        ArrayList<CheckedShoppingListItem> loadedList = Preferences.loadShoppingList(sharedPreferences);
        if(null != savedInstanceState){
            String[] names = savedInstanceState.getStringArray("names");
            boolean[] states = savedInstanceState.getBooleanArray("states");

            for(int i = 0; i < names.length; ++i){
                list.add(new CheckedShoppingListItem(names[i],states[i]));
            }
        }else if(null != loadedList){
            list = loadedList;
        }

        //Initialise components
        input = (EditText)findViewById(R.id.textView3);

        adapter = new CustomShoppingListAdaptor(list,this);
        ListView listView = (ListView)findViewById(R.id.shoppingListView);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    public void addItemClick(View view) {
        //Add new item to shopping list
        list.add(new CheckedShoppingListItem(input.getText().toString()));
        input.setText("");
        adapter.notifyDataSetChanged();
    }

    public void gotoMain(View view) {
        //Save shopping list and return to main screen
        SharedPreferences sharedPreferences = getSharedPreferences(Preferences.preferencesName, MODE_PRIVATE);
        Preferences.saveShoppingList(list,sharedPreferences);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //If user presses the back button go back to main screen
        super.onBackPressed();
        gotoMain(null);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save activity state
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Boolean> states = new ArrayList<>();

        for (CheckedShoppingListItem item: list) {
            names.add(item.getName());
            states.add(item.isChecked());
        }

        outState.putStringArray("names",names.toArray(new String[names.size()]));

        boolean[] boolArray = new boolean[states.size()];

        for(int i = 0; i < states.size(); ++i){
            boolArray[i] = states.get(i);
        }

        outState.putBooleanArray("states", boolArray);
    }
}
