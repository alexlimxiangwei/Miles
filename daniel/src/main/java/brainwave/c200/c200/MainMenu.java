package brainwave.c200.c200;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    Button setting;
    Button play;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        play = findViewById(R.id.start);
        setting = findViewById(R.id.setting);

        ConstraintLayout constraintLayout = findViewById(R.id.menu_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
    public void Setting(View v) {
        startActivity(new Intent(this, MusicSettings.class));

    }
    public void Play(View v) {
        Bundle bundle = getIntent().getExtras();

        startActivity(new Intent(this, StudyMode.class));

        if (bundle.getInt("Focus") == R.raw.focus) {
            Integer choice = bundle.getInt("Focus");
            if (player == null) {
                player = MediaPlayer.create(this, choice);
                player.setLooping(true);
                Toast.makeText(this, "Music: ON", Toast.LENGTH_SHORT).show();
            }
            player.start();
        }
        if (bundle.getInt("Relax") == R.raw.relaxing) {
            Integer choice = bundle.getInt("Relax");
            if (player == null) {
                player = MediaPlayer.create(this, choice);
                player.setLooping(true);
                Toast.makeText(this, "Music: ON", Toast.LENGTH_SHORT).show();
            }
            player.start();
        }
        if (bundle.getInt("Study") == R.raw.study) {
            Integer choice = bundle.getInt("Study");
            if (player == null) {
                player = MediaPlayer.create(this, choice);
                player.setLooping(true);
                Toast.makeText(this, "Music: ON", Toast.LENGTH_SHORT).show();
            }
            player.start();
        }
        if (bundle.getInt("Clear") == R.raw.clear) {
            Integer choice = bundle.getInt("Clear");
            if (player == null) {
                player = MediaPlayer.create(this, choice);
                player.setLooping(true);
                Toast.makeText(this, "Music: ON", Toast.LENGTH_SHORT).show();
            }
            player.start();
        }
    }
}
