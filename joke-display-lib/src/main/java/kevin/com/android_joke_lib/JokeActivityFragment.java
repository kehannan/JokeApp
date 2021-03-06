package kevin.com.android_joke_lib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Class to display the the joke received from GCE.
 * It extracts the joke text from the intent and
 * renders it in its view.
 */

public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke_activity, container, false);
        Intent intent = getActivity().getIntent();

        String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);

        TextView jokeTextView = (TextView) root.findViewById(R.id.textview);

        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return root;
    }

}
