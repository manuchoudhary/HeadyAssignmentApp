package headyassignmentapp.app.io.headyassignmentapp.applications.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by manish on 01/12/17.
 */

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }
}
