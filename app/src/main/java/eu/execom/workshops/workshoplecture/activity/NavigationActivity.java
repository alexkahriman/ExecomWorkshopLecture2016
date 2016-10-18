package eu.execom.workshops.workshoplecture.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.execom.workshops.workshoplecture.R;
import eu.execom.workshops.workshoplecture.manager.PreferenceManager;
import eu.execom.workshops.workshoplecture.model.User;

/**
 * Provides navigation.
 * Created by Alex on 10/17/16.
 */
public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        // Attempt to get the logged in user.
        final User user = PreferenceManager.getInstance().getUser();
        if (user == null) {
            // If no user is logged in, go to LoginActivity.
            final Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
