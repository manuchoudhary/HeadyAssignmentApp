package headyassignmentapp.app.io.headyassignmentapp.screens.main.dagger;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.MainActivity;
import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.core.*;

/**
 * Created by manish on 01/12/17.
 */

@Module
public class MainModule {

    @MainScope
    @Provides
    MainPresenter providePresenter(RxSchedulers schedulers, MainModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new MainPresenter(model, schedulers, compositeSubscription);
    }


    @MainScope
    @Provides
    MainView provideMainView(MainActivity context) {
        return new MainView(context);
    }


    @MainScope
    @Provides
    MainModel provideMainModel(ProductApi api, MainActivity ctx) {
        return new MainModel(api, ctx);
    }
}
