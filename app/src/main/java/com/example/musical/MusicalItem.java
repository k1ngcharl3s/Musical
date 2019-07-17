package com.example.musical;

/**
 * {@link MusicalItem} represents the object that stores the data about the musical object
 */

class MusicalItem {
    /** Title of song */
    private final String mSongName;

    /** Name of the artist of song */
    private final String mArtistName;

    /** Length of song */
    private final String mSongLength;

    /** Name of the album */
    private final String mAlbumName;

    /**
     * Create the object for Song
     *
     * @param songName is the title of song
     * @param artistName is the name of the artist for the song
     * @param songLength is the length of the song
     * @param albumName is the name of the album for the song
     */

    public MusicalItem(String songName, String artistName, String songLength, String albumName) {
        mSongName = songName;
        mArtistName = artistName;
        mSongLength = songLength;
        mAlbumName = albumName;
    }

    /**
     * Get the title of Song
     */
    public String getSongName() {
        return mSongName;
    }
    /**
     * Get the name for the artist
     */
    public String getArtistName () {
        return mArtistName;
    }

    public String getSongLength () {
        return mSongLength;
    }

    /**
     * Get the title of the album
     */
    public String getAlbumName() {
        return mAlbumName;
    }
}
