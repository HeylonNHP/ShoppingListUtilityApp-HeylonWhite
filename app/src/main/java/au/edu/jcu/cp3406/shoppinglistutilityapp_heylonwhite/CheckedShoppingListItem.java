package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import androidx.annotation.NonNull;

public class CheckedShoppingListItem {
    boolean checked = false;
    String name;
    public CheckedShoppingListItem(String name){
        this.name = name;
    }

    public CheckedShoppingListItem(String name, boolean state){
        this(name);
        this.checked = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
