package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Preferences {
    public static final String preferencesName = "ShoppingListPrefs";
    public static final String shoppingListSettingName = "shoppingItems";
    public static void saveShoppingList(ArrayList<CheckedShoppingListItem> items, SharedPreferences sharedPreferences){
        //Save shopping list to sharedPreferences using a JSON string
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(items);
        editor.putString(shoppingListSettingName,json);
        System.out.println(json);
        editor.commit();
    }

    public static ArrayList<CheckedShoppingListItem> loadShoppingList(SharedPreferences sharedPreferences){
        //Restore shopping list from JSON string saved within sharedPreferences
        Gson gson = new Gson();
        String json = sharedPreferences.getString(shoppingListSettingName, null);
        Type type = new TypeToken<ArrayList<CheckedShoppingListItem>>() {}.getType();

        ArrayList<CheckedShoppingListItem> items = gson.fromJson(json,type);

        return items;
    }
}
