package headyassignmentapp.app.io.headyassignmentapp.screens.products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

import javax.inject.Inject;

import headyassignmentapp.app.io.headyassignmentapp.applications.AppController;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.ProductDetailActivity;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.core.ProductPresenter;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.core.ProductView;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.dagger.ProductModule;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.dagger.DaggerProductComponent;

/**
 * Created by manish on 01/12/17.
 */

public class ProductListActivity extends AppCompatActivity {

    @Inject
    ProductView view;
    @Inject
    ProductPresenter presenter;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Category category = (Category) getIntent().getExtras().get("category");

        DaggerProductComponent.builder().appComponent(AppController.getNetComponent()).productModule(new ProductModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate(category.getProducts());
    }

    public void goToProductDetailActivity(Product product) {

        Intent in = new Intent(this, ProductDetailActivity.class);
        in.putExtra("product", (Serializable) product);
        startActivity(in);

    }
}
