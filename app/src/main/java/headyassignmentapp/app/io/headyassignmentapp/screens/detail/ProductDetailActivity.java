package headyassignmentapp.app.io.headyassignmentapp.screens.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.core.ProductDetailView;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.dagger.DaggerProductDetailComponent;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.dagger.ProductDetailModule;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductDetailActivity extends AppCompatActivity {

    @Inject
    ProductDetailView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Product product = (Product) getIntent().getExtras().get("product");

        DaggerProductDetailComponent.builder().productDetailModule(new ProductDetailModule(this, product)).build().inject(this);

        setContentView(view.view());

    }
}
