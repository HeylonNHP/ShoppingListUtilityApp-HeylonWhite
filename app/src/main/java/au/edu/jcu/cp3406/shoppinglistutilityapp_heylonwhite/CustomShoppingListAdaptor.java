package au.edu.jcu.cp3406.shoppinglistutilityapp_heylonwhite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class CustomShoppingListAdaptor extends BaseAdapter implements ListAdapter {
    private ArrayList<CheckedShoppingListItem> list = new ArrayList<>();
    private Context context;

    public CustomShoppingListAdaptor(ArrayList<CheckedShoppingListItem> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.edit_shopping_list, null);
        }

        CheckedTextView itemText = (CheckedTextView) view.findViewById(R.id.checkedListItemText);
        itemText.setText(list.get(position).getName());
        itemText.setChecked(list.get(position).isChecked());

        //Delete button listener handling
        Button deleteButton = (Button)view.findViewById(R.id.listItemDeleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        //CheckedTextView listener handling
        itemText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((CheckedTextView) v).toggle();
                list.get(position).setChecked(((CheckedTextView) v).isChecked());
            }
        });

        return view;
    }
}
