package brainwave.c200.c200;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    EditText regname, regage, regmail, regpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regname = (EditText) findViewById(R.id.regname);
        regage = (EditText) findViewById(R.id.regage);
        regmail = (EditText) findViewById(R.id.regmail);
        regpass = (EditText) findViewById(R.id.regpass);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.register).setOnClickListener(this);

        ConstraintLayout constraintLayout = findViewById(R.id.register_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
    }

    private void registerUser() {
        String name = regname.getText().toString().trim();
        String age = regage.getText().toString().trim();
        String mail = regmail.getText().toString().trim();
        String password = regpass.getText().toString().trim();

        if(mail.isEmpty()){
            regmail.setError("Email is required!");
            regmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            regmail.setError("Please enter a valid E-mail address!");
            regmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            regpass.setError("Password is required!");
            regpass.requestFocus();
            return;
        }
        if(password.length() < 6){
            regpass.setError("Minimum length of password should be 6!");
            regpass.requestFocus();
            return;
        }
        if(age.isEmpty()){
            regage.setError("Age is required!");
            regage.requestFocus();
            return;
        }
        if(age.isEmpty()){
            regage.setError("Age is required!");
            regage.requestFocus();
            return;
        }
        if(name.isEmpty()){
            regname.setError("Name is required!");
            regname.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }else {
                    progressBar.setVisibility(View.GONE);
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register:
                registerUser();
                break;
        }
    }

}
