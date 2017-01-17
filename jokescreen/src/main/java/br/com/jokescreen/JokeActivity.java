package br.com.jokescreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "br.com.jokescreen.JokeActivity.JOKE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        TextView jokeMessage = (TextView) findViewById(R.id.tv_joke_message);

        if (getIntent().hasExtra(JOKE_EXTRA)) {
            String jokeExtra = getIntent().getStringExtra(JOKE_EXTRA);
            jokeMessage.setText(jokeExtra);
        }
    }
}
