package headyassignmentapp.app.io.headyassignmentapp.screens.products.core;

import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.ProductListActivity;
import headyassignmentapp.app.io.headyassignmentapp.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductModel {

    ProductListActivity context;
    ProductApi api;

    public ProductModel(ProductListActivity context) {
        this.context = context;
    }

    Observable<Category> provideListCategory() {
        return api.getCategory();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    public void gotoProductDetailActivity(Product product) {
        context.goToProductDetailActivity(product);
    }
}
