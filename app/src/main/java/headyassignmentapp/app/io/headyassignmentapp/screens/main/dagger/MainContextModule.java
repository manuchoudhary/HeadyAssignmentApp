package headyassignmentapp.app.io.headyassignmentapp.screens.main.dagger;

import dagger.Module;
import dagger.Provides;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.MainActivity;

/**
 * Created by manish on 01/12/17.
 */

@Module
public class MainContextModule {

    MainActivity mainContext;

    public MainContextModule(MainActivity context) {
        this.mainContext = context;
    }

    @MainScope
    @Provides
    MainActivity provideSplashContext() {
        return mainContext;
    }
}
