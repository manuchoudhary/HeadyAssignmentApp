package headyassignmentapp.app.io.headyassignmentapp.screens.products.dagger;

import dagger.Component;
import headyassignmentapp.app.io.headyassignmentapp.applications.builder.AppComponent;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.ProductListActivity;

/**
 * Created by manish on 01/12/17.
 */

@ProductScope
@Component(dependencies = {AppComponent.class} , modules = {ProductModule.class})
public interface ProductComponent {

    void inject (ProductListActivity productListActivity);
}
