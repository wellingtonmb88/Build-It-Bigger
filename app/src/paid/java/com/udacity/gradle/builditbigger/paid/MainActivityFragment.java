package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import br.com.jokescreen.JokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
        implements EndpointsAsyncTask.EndpointListener, View.OnClickListener {

    private ProgressBar progressBar;

    private EndpointsAsyncTask endpointsAsyncTask;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        final Button tellJokeButton = (Button) root.findViewById(R.id.bt_tell_joke);
        tellJokeButton.setOnClickListener(this);

        progressBar = (ProgressBar) root.findViewById(R.id.progress_bar);

        return root;
    }

    private void tellJoke() {
        progressBar.setVisibility(View.VISIBLE);
        endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.setListener(this);
        endpointsAsyncTask.execute();
    }

    private void openJokeActivity(final String result) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, result);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (endpointsAsyncTask != null) {
            endpointsAsyncTask.cancel(true);
            endpointsAsyncTask.setListener(null);
        }
    }

    @Override
    public void onResultReceived(final String result) {
        progressBar.setVisibility(View.GONE);
        if (result != null) {
            openJokeActivity(result);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_tell_joke:
                tellJoke();
                break;
            default:
                break;
        }
    }
}
