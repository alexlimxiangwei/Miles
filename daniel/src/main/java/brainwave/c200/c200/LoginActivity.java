package brainwave.c200.c200;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBar;
    FirebaseAuth mAuth;
    EditText acc,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        acc = (EditText)findViewById(R.id.acc);
        pass= (EditText)findViewById(R.id.pass);


        final RelativeLayout Login = (RelativeLayout)findViewById(R.id.login);
        Login.setOnClickListener(this);
        final TextView Register = (TextView)findViewById(R.id.goregister);
        Register.setOnClickListener(this);

        RelativeLayout relativeLayout = findViewById(R.id.login_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        progressBar = (ProgressBar)findViewById(R.id.progressbar);

    }

    private void userLogin(){
        String account = acc.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if (account.isEmpty()) {
            acc.setError("Account is required");
            acc.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(account).matches()) {
            acc.setError("Please enter a valid email");
            acc.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            pass.setError("Password is required");
            pass.requestFocus();
            return;
        }

        if (password.length() < 6) {
            pass.setError("Minimum lenght of password should be 6");
            pass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(account, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Login Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainMenu.class));
                } else {
                    progressBar.setVisibility(View.GONE);
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Invalid account or password!")
                            .setNegativeButton("Retry",null)
                            .create()
                            .show();
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.goregister:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.login:
                userLogin();
                break;
        }

    }
}
