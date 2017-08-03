package com.chrishonwyllie.filterablerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chrishon on 8/3/17.
 */

// This class is what is used to populate the RecyclerView
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    // Data that will be used
    private List<ListObject> filteredListData;
    private List<ListObject> listData;

    // Used to inflate the custom recyclerview_list_item
    private LayoutInflater inflater;

    // Optional
    private Context mContext;


    // Instantiate objects
    public RecyclerViewAdapter(List<ListObject> listData, Context c) {
        this.mContext = c;
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
        this.filteredListData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create a view for each recycler view item. Used to display objects
        // In Twitter, this "recycler_view_item" would probably display a variety of widgets such as
        // ImageView (Profile Image), TextView (Text for Twitter post), username, time since post, etc.....
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // Essentially used to customize each RecyclerView item
        // set profile image, twitter post text, etc...
        ListObject listObject = filteredListData.get(position);

        holder.listItemTextView.setText(listObject.listText);
        holder.idTextView.setText(listObject.listTextId);
    }


    @Override
    public int getItemCount() {
        return filteredListData.size();
    }


    // Filter function that comes standard with RecyclerView
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                // Convert passed in CharSequence from parameter to a String object
                String charString = charSequence.toString();

                // If the user is not typing, revert to the original list data
                if (charString.isEmpty()) {

                    //
                    filteredListData = listData;
                } else {

                    // Construct a new arraylist to handle the filtered results
                    ArrayList<ListObject> filteredList = new ArrayList<>();

                    // Loop through every listObject in the original listData
                    for (ListObject listObject : listData) {

                        // If either the listText or listTextId contains the passed in CharSequence...
                        if (listObject.listText.toLowerCase().contains(charString) || listObject.listTextId.toLowerCase().contains(charString)) {

                            // Add this object to the newly constructed filteredList
                            filteredList.add(listObject);
                        }
                    }

                    // Set the original filteredListData to this newly constructed filteredList
                    filteredListData = filteredList;
                }


                // Return the results of this filter
                FilterResults filterResults = new FilterResults();
                //filterResults.values = mFilteredList;
                filterResults.values = filteredListData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                // Notify the
                filteredListData = (ArrayList<ListObject>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    // This is a custom RecyclerView.ViewHolder object. It could have been named something like "TwitterPostViewHolder"
    // It is used to gather references to all widgets in your custom recyclerview_list_item
    // Must conform to ViewHolder object
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView listItemTextView;
        private TextView idTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            listItemTextView = (TextView) itemView.findViewById(R.id.textview);
            idTextView = (TextView) itemView.findViewById(R.id.idtextview);

        }
    }
}
