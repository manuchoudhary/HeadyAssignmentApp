package headyassignmentapp.app.io.headyassignmentapp.screens.main.dagger;

import dagger.Component;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.MainActivity;
import headyassignmentapp.app.io.headyassignmentapp.applications.builder.AppComponent;

/**
 * Created by manish on 01/12/17.
 */

@MainScope
@Component(modules = {MainContextModule.class, MainModule.class}, dependencies = {AppComponent.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
