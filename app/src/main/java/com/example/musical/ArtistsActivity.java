package com.example.musical;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        // The activity will only run in portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Locate the ImageButton that will stop the current activity and return to previous one
        ImageButton returnButton = findViewById(R.id.return_button);

        // Create an a click listener for the ImageButton
        returnButton.setOnClickListener(new View.OnClickListener() {
            // the code from this method will be ran when the returnButton is clicked
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Create the list of artists
        ArrayList<MusicalItem> artists = new ArrayList<MusicalItem>();
        artists.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, null));

        // Create the {@link SongAdapter}, which is the source for {@Song}s
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        // Locate the {@link ListView} object in the view of {@link Activity}.
        ListView listview = findViewById(R.id.list);

        // Make the {@link ListView} and utilize the {@link SongAdapter} that is above
        listview.setAdapter(adapter);

        // Create the item click listener for the VIew
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                // The name of the artist will be passed to the Albums Activity
                LinearLayout linearLayout = (LinearLayout) view;
                TextView artistTextView = linearLayout.findViewById(R.id.list_item_description_text_view);
                String artistName = artistTextView.getText().toString();

                // This code from this method will be ran when the item from the artist View is clicked
                Intent albumsIntent = new Intent(ArtistsActivity.this, AlbumsActivity.class);
                // Send the intent with the artist name after it is clicked
                albumsIntent.putExtra("EXTRA_ARTIST_NAME", artistName);
                startActivity(albumsIntent);

            }
        });
    }
}
