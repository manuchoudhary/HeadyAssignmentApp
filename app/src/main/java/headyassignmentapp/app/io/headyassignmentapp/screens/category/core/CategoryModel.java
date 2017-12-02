package headyassignmentapp.app.io.headyassignmentapp.screens.category.core;

import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.CategoryListActivity;
import headyassignmentapp.app.io.headyassignmentapp.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by manish on 02/12/17.
 */

public class CategoryModel {

    CategoryListActivity context;
    ProductApi api;

    public CategoryModel(CategoryListActivity context, ProductApi api) {
        this.api = api;
        this.context = context;
    }


    Observable<Category> provideListCategory() {
        return api.getCategory();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }



    public void gotoProductListActivity(Category category) {
        context.goToProductListActivity(category);
    }
}
