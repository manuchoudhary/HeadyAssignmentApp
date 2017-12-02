package headyassignmentapp.app.io.headyassignmentapp.screens.main.core;

import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.MainActivity;
import headyassignmentapp.app.io.headyassignmentapp.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by manish on 01/12/17.
 */

public class MainModel {

    private ProductApi api;
    private MainActivity mainContext;

    public MainModel(ProductApi api, MainActivity mainCtx) {
        this.api = api;
        this.mainContext = mainCtx;

    }

    Observable<Category> provideListCategory() {
        return api.getCategory();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(mainContext);
    }


    public void gotoCategoryListActivity() {
        mainContext.showCategoryListActivity();

    }
}
