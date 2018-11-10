package brainwave.c200.c200;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudyMode extends AppCompatActivity {
    Button stop;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_mode);

        stop = findViewById(R.id.stop);
    }

    public void Stop(View v){
        stopPlayer();
        startActivity(new Intent(this, MainMenu.class));
    }

    public void stopPlayer() {

        if (player != null ) {
            player.release();
            player = null;
            Toast.makeText(this, "Music: OFF", Toast.LENGTH_SHORT).show();
        }
    }
}
