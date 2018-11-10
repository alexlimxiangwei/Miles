package brainwave.c200.c200;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicSettings extends AppCompatActivity {
    Button focus;
    Button relax;
    Button study;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_settings);

        focus = findViewById(R.id.focus_btn);
        relax = findViewById(R.id.relax_btn);
        study = findViewById(R.id.study_btn);
        clear = findViewById(R.id.clear_btn);

    }

    public void Focus(View v) {
        if (focus.isEnabled()) {
            focus.setEnabled(false);
            focus.postDelayed(new Runnable() {
                @Override
                public void run() {
                    focus.setEnabled(true);
                }
            }, 10000);
            Toast.makeText(this, "Focus Selected", Toast.LENGTH_SHORT).show();
            Integer choice = R.raw.focus;
            Intent pass_music = new Intent(this, MainMenu.class);
            pass_music.putExtra("Focus", choice);
            startActivity(pass_music);
        }
    }

    public void Relax(View v) {
        if (relax.isEnabled()) {
            relax.setEnabled(false);
            relax.postDelayed(new Runnable() {
                @Override
                public void run() {
                    relax.setEnabled(true);
                }
            }, 10000);
            Toast.makeText(this, "Relax Selected", Toast.LENGTH_SHORT).show();
            Integer choice = R.raw.relaxing;
            Intent pass_music = new Intent(this, MainMenu.class);
            pass_music.putExtra("Relax", choice);
            startActivity(pass_music);
        }
    }

    public void Study(View v) {
        if (study.isEnabled()) {
            study.setEnabled(false);
            study.postDelayed(new Runnable() {
                @Override
                public void run() {
                    study.setEnabled(true);
                }
            }, 10000);
            Toast.makeText(this, "Study Selected", Toast.LENGTH_SHORT).show();
            Integer choice = R.raw.study;
            Intent pass_music = new Intent(this, MainMenu.class);
            pass_music.putExtra("Study", choice);
            startActivity(pass_music);
        }
    }

    public void Clear(View v) {
        if (clear.isEnabled()) {
            clear.setEnabled(false);
            clear.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clear.setEnabled(true);
                }
            }, 10000);
            Toast.makeText(this, "Clear Selected", Toast.LENGTH_SHORT).show();
            Integer choice = R.raw.clear;
            Intent pass_music = new Intent(this, MainMenu.class);
            pass_music.putExtra("Clear", choice);
            startActivity(pass_music);
        }
    }
}

