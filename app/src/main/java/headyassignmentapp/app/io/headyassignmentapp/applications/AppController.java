package headyassignmentapp.app.io.headyassignmentapp.applications;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import timber.log.BuildConfig;
import timber.log.Timber;
import headyassignmentapp.app.io.headyassignmentapp.applications.builder.AppComponent;
import headyassignmentapp.app.io.headyassignmentapp.applications.builder.AppContextModule;
import headyassignmentapp.app.io.headyassignmentapp.applications.builder.DaggerAppComponent;

/**
 * Created by manish on 01/12/17.
 */

public class AppController extends Application {

    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }


    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }

}
