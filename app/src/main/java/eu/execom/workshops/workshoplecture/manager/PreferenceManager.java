package eu.execom.workshops.workshoplecture.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import eu.execom.workshops.workshoplecture.WorkshopLectureApp;
import eu.execom.workshops.workshoplecture.model.User;

/**
 * This singleton is dedicated to saving and loading data saved in {@link SharedPreferences
 * SharedPreferences}. Note that {@link SharedPreferences SharedPreferences} should be used to store
 * small data. For anything larger, use a database.
 * Created by Alex on 10/18/16.
 */
public class PreferenceManager {

    /**
     * Key of this apps {@link SharedPreferences SharedPreferences} store.
     */
    private static final String PREFERENCE_STORE_WORKSHOP_LECTURE = "WorkshopLecture";

    /**
     * Key for the currently logged in {@link User user}.
     */
    private static final String PREFERENCE_USER = "User";

    private static PreferenceManager ourInstance = new PreferenceManager();

    public static PreferenceManager getInstance() {
        return ourInstance;
    }

    private final SharedPreferences sharedPreferences;

    private final Gson gson = new Gson();

    private PreferenceManager() {
        sharedPreferences = WorkshopLectureApp.getAppContext().getSharedPreferences(PREFERENCE_STORE_WORKSHOP_LECTURE, Context.MODE_PRIVATE);
    }

    /**
     * Saves the currently logged in {@link User user}.
     * @param user Currently logged in {@link User user}.
     */
    public void putUser(User user) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFERENCE_USER, gson.toJson(user));
        editor.apply();
    }

    /**
     * Searches for and parses the currently logged in {@link User user}.
     * @return Currently logged in {@link User user} if successful, null otherwise.
     */
    public User getUser() {
        return gson.fromJson(sharedPreferences.getString(PREFERENCE_USER, ""), User.class);
    }
}
