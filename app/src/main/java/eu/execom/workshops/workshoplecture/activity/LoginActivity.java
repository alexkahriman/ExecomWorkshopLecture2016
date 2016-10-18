package eu.execom.workshops.workshoplecture.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eu.execom.workshops.workshoplecture.R;
import eu.execom.workshops.workshoplecture.api.ApiService;
import eu.execom.workshops.workshoplecture.manager.PreferenceManager;
import eu.execom.workshops.workshoplecture.model.User;

/**
 * {@link AppCompatActivity Activity} which handles user login.
 * Created by Alex on 10/17/16.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Used for logging purposes.
     */
    // This is always a good idea, because you can follow your apps flow by watching logs.
    // If the workflow is complicated, you can see where the problem is and debug there, instead
    // of going step by step in the debugger.
    private static final String TAG = LoginActivity.class.getSimpleName();

    /**
     * Username input {@link EditText EditText}.
     */
    private EditText username;

    /**
     * Password input {@link EditText EditText}.
     */
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Once you set the content view, your layout will inflate and then you can get
        // references to the views inside it.
        initViewReferences();
    }

    /**
     * Initiates view references and sets listeners.
     */
    private void initViewReferences() {
        // Note that findViewById returns a View, so a cast is needed.
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        // Note that login button doesn't have to be a member (global) field since it is only
        // referenced from this function.
        final Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This body of code executes when ever the login button is tapped.
                handleLoginAttempt();
            }
        });
    }

    /**
     * Handles user authentication and persistence logic.
     */
    private void handleLoginAttempt() {
        Log.i(TAG, "Attempting to log in!");
        final ApiService apiService = new ApiService();
        // Attempt to get the user who's credentials match the current input field values.
        final User user = apiService.authenticate(username.getText().toString(), password.getText().toString());
        // Inquire weather the user exists.
        if (user != null) {
            // Save the currently logged user.
            PreferenceManager.getInstance().putUser(user);
            Log.i(TAG, "Login successful!");
            // Exit this activity.
            finish();
        } else {
            Log.i(TAG, "Login unsuccessful, wrong credentials!");
            // Show error for wrong credentials.
            username.setError(getString(R.string.invalid_credentials));
        }
    }

    @Override
    public void onBackPressed() {
        // By overriding this method, we prevent the user to go back to NavigationActivity by
        // pressing the back button. Note that a way to exit the app should be implemented here.
    }
}
