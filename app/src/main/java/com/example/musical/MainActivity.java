package com.example.musical;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The activity will use the activity_main.xml file
        setContentView(R.layout.activity_main);

        // The activity will be running in portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Locate the views that will display the songs
        TextView songs = findViewById(R.id.songs);

        // Create the click listener for the view
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsIntent);

            }
        });

        // Locate the views that displays the artist
        TextView artists = findViewById(R.id.artist);

        // Click the on click listener for that view
        artists.setOnClickListener(new View.OnClickListener() {
            // The code will be ran when the artist View is clicked
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);

            }
        });

        // Locate the Views that displays the albums
        TextView albums = findViewById(R.id.albums);

        // Create on click listener for the view
        albums.setOnClickListener(new View.OnClickListener() {
            // The code will be ran once the albums View is clicked
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsIntent);

            }
        });
    }
}
