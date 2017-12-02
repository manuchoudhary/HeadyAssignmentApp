package headyassignmentapp.app.io.headyassignmentapp.applications.builder;

import dagger.Module;
import dagger.Provides;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.*;

/**
 * Created by manish on 01/12/17.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
