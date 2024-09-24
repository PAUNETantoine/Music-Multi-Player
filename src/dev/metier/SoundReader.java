package dev.metier;


import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;

public class SoundReader
{
    private Player musicPlayer;

    public SoundReader()
    {
        try{
            InputStream fichierAudio = new FileInputStream("src/files/playlists/musics");
            this.musicPlayer = new Player(fichierAudio);

        }catch(Exception error)
        {
            System.out.println("erreur de lecture du fichier audio");
        }
    }
}
