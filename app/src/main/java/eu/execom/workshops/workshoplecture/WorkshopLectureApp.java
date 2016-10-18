package eu.execom.workshops.workshoplecture;

import android.app.Application;
import android.content.Context;

/**
 * Holds the global application context and responds to application scope events.
 * This is a singleton.
 * Created by Alex on 10/18/16.
 */

public class WorkshopLectureApp extends Application {

    private static WorkshopLectureApp workshopLectureApp;

    /**
     * Provides the {@link Application application} {@link Context context}.
     * @return {@link Application Application} {@link Context context}.
     */
    public static Context getAppContext() {
        return workshopLectureApp.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        workshopLectureApp = this;
    }
}
