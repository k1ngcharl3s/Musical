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


import com.example.musical.AlbumAdapter;
import com.example.musical.MusicalItem;
import com.example.musical.R;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // The activity will be ran in portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Locate the TextView that has the artist name ID
        TextView name = findViewById(R.id.artist_name);

        // Create the list for the albums
        ArrayList<MusicalItem> albums = new ArrayList<MusicalItem>();

        // Will the intent with the artist name be received?
        Intent intent = getIntent();
        String artistName = (String) intent.getSerializableExtra("EXTRA_ARTIST_NAME");
        if (artistName == null) { // No it won't
            // No reason to show the TextView with artist name ID
            name.setVisibility(View.GONE);

            // Populate the album lists
            albums.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, getString(R.string.album_name_crenshaw)));
            albums.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, getString(R.string.album_mailbox_money)));
            albums.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, getString(R.string.album_victory_lap)));
        } else {
            // Display the artist name
            name.setText(artistName);

            // Popluate the list of albums by artist name
            if (artistName.equalsIgnoreCase(getString(R.string.artist_nipsey_hussle))) {
                albums.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, getString(R.string.album_name_crenshaw)));
                albums.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, getString(R.string.album_mailbox_money)));
                albums.add(new MusicalItem(null, getString(R.string.artist_nipsey_hussle), null, getString(R.string.album_victory_lap)));

            }
        }

        // Locate the ImageButton that will stop the current activity to recover the previous one
        ImageButton returnButton = findViewById(R.id.return_button);

        // Create the on click listener on that ImageButton
        returnButton.setOnClickListener(new View.OnClickListener() {
            // The code will be ran when the returnButton ImageButton is clicked
            @Override
            public void onClick (View view) {
                finish();
            }
        });

        // Create the {@link SongAdapter} the info will come from {@link Song}s
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Locate the {@link Listview} object coming from {@link Activity}
        // There will be a {@link ListView} with the view ID called, list, that is associated with
        // the activity_albums.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Direct {@link ListView} use the {@link SongAdapter} that was just created
        // {@link ListView} will display the list for every item {@link Song} from the list
        listView.setAdapter(adapter);

        // Create an item click listener for the View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                // THe album name will be passed on to the AlbumsActivity
                LinearLayout linearLayout = (LinearLayout) view;
                TextView albumTextView = linearLayout.findViewById(R.id.list_item_description_text_view);
                String albumName = albumTextView.getText().toString();
                // The artist name will be passed on to the AlbumsActivity
                TextView artistTextView = linearLayout.findViewById(R.id.list_item_detail_text_view);
                String artistName = artistTextView.getText().toString();

                // This code will be ran when an item from the songs Views is clicked
                Intent songsIntent = new Intent (AlbumsActivity.this, SongsActivity.class);
                // Send the intent that contains the artist name once the intent is passed
                songsIntent.putExtra("EXTRA_ARTIST_NAME", artistName);
                // Send the intent that contains the album name
                songsIntent.putExtra("EXTRA_ALBUM_NAME", albumName);
                startActivity(songsIntent);

            }
        });

    }
}
