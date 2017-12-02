package headyassignmentapp.app.io.headyassignmentapp.applications.builder;

import dagger.Component;
import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;

/**
 * Created by manish on 01/12/17.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, CategoryApiServiceModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();
    ProductApi apiService();
}
