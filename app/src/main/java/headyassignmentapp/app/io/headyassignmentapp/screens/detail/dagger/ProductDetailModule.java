package headyassignmentapp.app.io.headyassignmentapp.screens.detail.dagger;

import dagger.Module;
import dagger.Provides;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.ProductDetailActivity;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.core.ProductDetailView;

/**
 * Created by manishchoudhary on 03/12/17.
 */

@Module
public class ProductDetailModule {

    ProductDetailActivity detailsContext;
    Product product;

    public ProductDetailModule(ProductDetailActivity context, Product product)
    {
        this.detailsContext = context;
        this.product = product;
    }

    @Provides
    ProductDetailView provideView()
    {
        return  new ProductDetailView(detailsContext,product);
    }
}
