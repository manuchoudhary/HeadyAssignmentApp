package headyassignmentapp.app.io.headyassignmentapp.screens.products.dagger;

import dagger.Module;
import dagger.Provides;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.ProductListActivity;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.core.ProductModel;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.core.ProductPresenter;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.core.ProductView;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by manish on 01/12/17.
 */

@Module
public class ProductModule {

    ProductListActivity productListContext;

    public ProductModule(ProductListActivity context) {
        this.productListContext = context;
    }

    @ProductScope
    @Provides
    ProductView provideView() {
        return new ProductView(productListContext);
    }

    @ProductScope
    @Provides
    ProductPresenter providePresenter(RxSchedulers schedulers, ProductView view, ProductModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new ProductPresenter(schedulers, model, view, subscriptions);
    }

    @ProductScope
    @Provides
    ProductListActivity provideContext() {
        return productListContext;
    }
    @ProductScope
    @Provides
    ProductModel provideModel() {
        return new ProductModel(productListContext);
    }
}
