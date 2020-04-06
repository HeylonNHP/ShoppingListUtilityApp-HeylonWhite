package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private SharedPreferences sharedPreferences;

    @Before
    public void before() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        sharedPreferences = context.getSharedPreferences(Preferences.preferencesName, Context.MODE_PRIVATE);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite", appContext.getPackageName());
    }

    @Test
    public void preferences(){
        //Test the Preferences class

        //Generate dummy list items
        ArrayList<CheckedShoppingListItem> list = new ArrayList<>();

        for(int i = 0; i < 5; ++i){
            String listItemName = String.valueOf((int)(Math.random()*1000));
            boolean listItemState = Math.random() > 0.5;

            CheckedShoppingListItem listItem = new CheckedShoppingListItem(listItemName,listItemState);

            list.add(listItem);
        }

        //Save items to sharedPreferences
        //The Preferences class uses GSON to convert the ArrayList to and from a String to save it in sharedPreferences
        //This shall test the accuracy of this conversion

        Preferences.saveShoppingList(list,sharedPreferences);

        ArrayList<CheckedShoppingListItem> loadedList = Preferences.loadShoppingList(sharedPreferences);

        //Check to see if the list values are the same
        for(int i = 0;i < loadedList.size(); ++i){
            CheckedShoppingListItem original = list.get(i);
            CheckedShoppingListItem loaded = loadedList.get(i);

            assertEquals(original.name,loaded.name);
            assertEquals(original.checked,loaded.checked);
        }
    }
}
