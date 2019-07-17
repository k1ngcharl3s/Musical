package com.example.musical;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class ArtistAdapter extends ArrayAdapter<MusicalItem> {
    public ArtistAdapter(Activity context, ArrayList<MusicalItem> artists) {
        // This is where the ArrayAdapter's internal storage will be generated for the list
        // The argument that comes second when be used to populate the single TextView
        // This will be the custom adapter for the ImageView as well as the two TextViews
        // The adapter won't use the second argument so that is why 0 is used.
        super(context, 0, artists);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // See if the existing view will be recycled, inflate view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Locate the ImageView from the list_item.xml layout that has 'list_item_icon'
        ImageView artistImage = listItemView.findViewById(R.id.list_item_icon);
        // Assign the image to the ImageView
        artistImage.setImageResource(R.drawable.allmoney);

        // Get the {@link AndroidFlavor} objects that is found in this position of the list
        MusicalItem currentArtist = getItem(position);

        // Locate the TextView from the list_item.xml layout with
        // the 'list_item_description_text_view
        TextView artistTextView = listItemView.findViewById(R.id.list_item_description_text_view);
        // Retrieve the album title from the current Album object
        // The text will be provided on the album TextVIew
        artistTextView.setText(currentArtist.getArtistName());

        // Locate the TextView in the list_item.xml layout hat has the 'list_item_detail_text_view'
        TextView detailTextView = listItemView.findViewById(R.id.list_item_detail_text_view);
        // Make the TextView invisible
        detailTextView.setVisibility(View.GONE);

        // Return the complete list that will be displayed in the ListView (2 ListViews, Imagview)
        return listItemView;
    }
}
