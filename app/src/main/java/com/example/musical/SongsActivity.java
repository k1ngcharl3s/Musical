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

public class SongsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // The activity will be ran in 'portrait' mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Locate the TextView containing the ID 'album name'
        TextView name = findViewById(R.id.album_name);

        // Create the list for songs
        ArrayList<MusicalItem> songs = new ArrayList<MusicalItem>();

        // Locate the Intent of the album name
        Intent intent = getIntent();
        final String selectedAlbumName = (String) intent.getSerializableExtra("EXTRA_ALBUM_NAME");
        // Will the intent be received
        if (selectedAlbumName == null) { // No
            // No need to show the TextView of the ID 'album_name'
            name.setVisibility(View.GONE);

            // Populate the song list
            songs.add(new MusicalItem(getString(R.string.song_killah), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_forty), getString(R.string.album_mailbox_money)));
            songs.add(new MusicalItem(getString(R.string.song_hunnit), getString(R.string.artist_nipsey_hussle), getString(R.string.length_two_minute_forty_three), getString(R.string.album_mailbox_money)));
            songs.add(new MusicalItem(getString(R.string.song_between), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_fifteen), getString(R.string.album_mailbox_money)));
            songs.add(new MusicalItem(getString(R.string.song_checc), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_seven), getString(R.string.album_name_crenshaw)));
            songs.add(new MusicalItem(getString(R.string.song_right), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_sixteen), getString(R.string.album_name_crenshaw)));
            songs.add(new MusicalItem(getString(R.string.song_mornin), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_twenty), getString(R.string.album_name_crenshaw)));
            songs.add(new MusicalItem(getString(R.string.song_days), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_six), getString(R.string.album_name_crenshaw)));
            songs.add(new MusicalItem(getString(R.string.song_victory), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_fifty_eigth), getString(R.string.album_victory_lap)));
            songs.add(new MusicalItem(getString(R.string.song_rap), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_forty_six), getString(R.string.album_victory_lap)));
            songs.add(new MusicalItem(getString(R.string.song_young), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_forty_six), getString(R.string.album_victory_lap)));
            songs.add(new MusicalItem(getString(R.string.song_bl2), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_ten), getString(R.string.album_victory_lap)));
            songs.add(new MusicalItem(getString(R.string.song_big), getString(R.string.artist_nipsey_hussle), getString(R.string.length_six_twenty_two), getString(R.string.album_victory_lap)));
        } else {
            // Display the title of album
            name.setText(selectedAlbumName);

            // Populate the list of songs based on selected album
            if (selectedAlbumName.equalsIgnoreCase(getString(R.string.album_mailbox_money))) {
                songs.add(new MusicalItem(getString(R.string.song_killah), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_forty), getString(R.string.album_mailbox_money)));
                songs.add(new MusicalItem(getString(R.string.song_hunnit), getString(R.string.artist_nipsey_hussle), getString(R.string.length_two_minute_forty_three), getString(R.string.album_mailbox_money)));
                songs.add(new MusicalItem(getString(R.string.song_between), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_fifteen), getString(R.string.album_mailbox_money)));
            } else if (selectedAlbumName.equalsIgnoreCase(getString(R.string.album_name_crenshaw))) {
                songs.add(new MusicalItem(getString(R.string.song_checc), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_seven), getString(R.string.album_name_crenshaw)));
                songs.add(new MusicalItem(getString(R.string.song_right), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_sixteen), getString(R.string.album_name_crenshaw)));
                songs.add(new MusicalItem(getString(R.string.song_mornin), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_twenty), getString(R.string.album_name_crenshaw)));
                songs.add(new MusicalItem(getString(R.string.song_days), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_six), getString(R.string.album_name_crenshaw)));
            } else {
                songs.add(new MusicalItem(getString(R.string.song_victory), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_fifty_eigth), getString(R.string.album_victory_lap)));
                songs.add(new MusicalItem(getString(R.string.song_rap), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_forty_six), getString(R.string.album_victory_lap)));
                songs.add(new MusicalItem(getString(R.string.song_young), getString(R.string.artist_nipsey_hussle), getString(R.string.length_three_minute_forty_six), getString(R.string.album_victory_lap)));
                songs.add(new MusicalItem(getString(R.string.song_bl2), getString(R.string.artist_nipsey_hussle), getString(R.string.length_four_minute_ten), getString(R.string.album_victory_lap)));
                songs.add(new MusicalItem(getString(R.string.song_big), getString(R.string.artist_nipsey_hussle), getString(R.string.length_six_twenty_two), getString(R.string.album_victory_lap)));
            }
        }

        // Locate the ImageButton that will close the current activity and go to the previous one
        ImageButton returnButton = findViewById(R.id.return_button);

        // Create the click listener on the ImageButton
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Create the {@link SongAdapter}, where the data is the source for {@link Song}s.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Locate the {@link ListView} object in the view of {@link Activity}.
        // There will be a {@link ListView} with the ID view known as list.
        ListView listView = findViewById(R.id.list);

        // Demand that the {@link ListView} use the {@link SongAdapter}, that was just created
        // in the previous line of code
        listView.setAdapter(adapter);

        // Create an item click listener for the view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                // What is the album name that resides in the ListView once it is clicked
                // It will be passed to the AlbumsActivity
                LinearLayout linearLayout = (LinearLayout) view;
                TextView songTextView = linearLayout.findViewById(R.id.list_item_description_text_view);
                String songName = songTextView.getText().toString();
                // What is the name of the artist in the ListView
                // It will be passed along to the ALbumsActivity
                TextView artistTextView = linearLayout.findViewById(R.id.list_item_detail_text_view);
                String artistName = artistTextView.getText().toString();

                // This code will be ran will an item from the songs View is selected
                Intent songsIntent = new Intent(SongsActivity.this, SongInfoActivity.class);
                // Send an Intent with the name of the artist if it is sent to the intent
                songsIntent.putExtra("EXTRA_ARTIST_NAME", artistName);
                // Send the Intent wiht the name of the album
                if (selectedAlbumName != null) {
                    songsIntent.putExtra("EXTRA_ALBUM_NAME", selectedAlbumName);
                }
                // Send the Intent with the name of the album when it is selected
                songsIntent.putExtra("EXTRA_SONG_NAME", songName);
                startActivity(songsIntent);

            }
        });
    }
}
