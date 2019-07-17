package com.example.musical;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SongInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        // The activity will only run in portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Locate the intent by artist name
        Intent intent = getIntent();
        String selectedArtistName = (String) intent.getSerializableExtra("EXTRA_ARTIST_NAME");
        // Locate the intent by album name
        String selectedAlbumName = (String) intent.getSerializableExtra("EXTRA_ALBUM_NAME");
        // Locate the intent by song name
        final String selectedSongName = (String) intent.getSerializableExtra("EXTRA_SONG_NAME");

        // Find the intent by album name
        TextView nameAlbum = findViewById(R.id.album_name);
        // Was the album found?
        if (selectedAlbumName == null) { // No
            // Assign the album name based by song
            if (selectedSongName.equals(getString(R.string.song_killah))) {
                nameAlbum.setText(getString(R.string.song_killah));
            } else if (selectedSongName.equals(getString(R.string.song_hunnit))) {
                nameAlbum.setText(getString(R.string.song_hunnit));
            } else if (selectedAlbumName.equals(getString(R.string.song_between))) {
                nameAlbum.setText(getString(R.string.song_between));
            } else if (selectedSongName.equals(getString(R.string.song_checc))) {
                nameAlbum.setText(getString(R.string.song_checc));
            } else if (selectedSongName.equals(getString(R.string.song_right))) {
                nameAlbum.setText(getString(R.string.song_right));
            } else if (selectedSongName.equals(getString(R.string.song_mornin))) {
                nameAlbum.setText(getString(R.string.song_mornin));
            } else if (selectedSongName.equals(getString(R.string.song_days))) {
                nameAlbum.setText(getString(R.string.song_days));
            } else if (selectedSongName.equals(getString(R.string.song_victory))) {
                nameAlbum.setText(getString(R.string.song_victory));
            } else if (selectedSongName.equals(getString(R.string.song_rap))) {
                nameAlbum.setText(getString(R.string.song_rap));
            } else if (selectedSongName.equals(getString(R.string.song_young))) {
                nameAlbum.setText(getString(R.string.song_young));
            } else if (selectedSongName.equals(getString(R.string.song_bl2))) {
                nameAlbum.setText(getString(R.string.song_bl2));
            } else {
                nameAlbum.setText(getString(R.string.song_big));
            }
        } else { // Thumbs up
            // Display the album title
            nameAlbum.setText(selectedAlbumName);
        }

        // Located the TextView by the ID 'artist_name'
        TextView nameArtist = findViewById(R.id.artist_name);
        // Display the name of artist
        nameArtist.setText(selectedArtistName);

        // Located the TextView by the ID 'song_name'
        TextView nameSong = findViewById(R.id.song_name);
        // Display the name of song
        nameSong.setText(selectedSongName);

        // Locate the TextView by the ID 'song_length'
        TextView nameDuration = findViewById((R.id.song_length));
        // Display the length of song
        if (selectedSongName.equals(getString(R.string.song_killah))) {
            nameDuration.setText(getString(R.string.length_four_minute_forty));
        } else if (selectedSongName.equals(getString(R.string.song_hunnit))) {
            nameDuration.setText(getString(R.string.length_two_minute_forty_three));
        } else if (selectedSongName.equals(R.string.song_between)) {
            nameDuration.setText(getString(R.string.length_four_minute_fifteen));
        } else if (selectedSongName.equals(R.string.song_checc)) {
            nameDuration.setText(getString(R.string.length_four_minute_seven));
        } else if (selectedSongName.equals(getString(R.string.song_right))) {
            nameDuration.setText(getString(R.string.length_four_minute_sixteen));
        } else if (selectedSongName.equals(getString(R.string.song_mornin))) {
            nameDuration.setText(getString(R.string.length_three_minute_twenty));
        } else if (selectedSongName.equals(R.string.song_days)) {
            nameDuration.setText(getString(R.string.length_four_minute_six));
        } else if (selectedSongName.equals(getString(R.string.song_victory))) {
            nameDuration.setText(getString(R.string.length_three_minute_fifty_eigth));
        } else if (selectedSongName.equals(getString(R.string.song_rap))) {
            nameDuration.setText(getString(R.string.length_three_minute_forty_six));
        } else if (selectedSongName.equals(getString(R.string.song_young))) {
            nameDuration.setText(getString(R.string.length_three_minute_fifty_six));
        } else if (selectedSongName.equals(getString(R.string.song_bl2))) {
            nameDuration.setText(getString(R.string.length_four_minute_ten));
        } else {
            nameDuration.setText(getString(R.string.length_six_twenty_two));
        }
        // Locate the ImageButton that will end the current activity and return to the previous one
        ImageButton returnButton = findViewById(R.id.return_button);

        // Create an click listener for the ImageButton
        returnButton.setOnClickListener(new View.OnClickListener() {
            // This code will be ran when the returnButton is clicked
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Locate the ImageButton that will begin the playing of song
        ImageButton songPlayer = findViewById(R.id.play_song);

        // Create the click listener for the ImageButton
        songPlayer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Currently Playing:" + selectedSongName;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
    }
}
