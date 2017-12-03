package headyassignmentapp.app.io.headyassignmentapp.screens.detail.dagger;

import dagger.Component;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.ProductDetailActivity;

/**
 * Created by manishchoudhary on 03/12/17.
 */

@Component(modules = {ProductDetailModule.class})
public interface ProductDetailComponent {
    void inject(ProductDetailActivity context);
}
