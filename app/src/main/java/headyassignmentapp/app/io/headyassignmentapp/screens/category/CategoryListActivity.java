package headyassignmentapp.app.io.headyassignmentapp.screens.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.Serializable;

import javax.inject.Inject;

import headyassignmentapp.app.io.headyassignmentapp.applications.AppController;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryPresenter;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryView;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.dagger.CategoryModule;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.dagger.DaggerCategoryComponent;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.ProductListActivity;

/**
 * Created by manishchoudhary on 02/12/17.
 */

public class CategoryListActivity extends AppCompatActivity {

    @Inject
    CategoryView view;
    @Inject
    CategoryPresenter presenter;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerCategoryComponent.builder().appComponent(AppController.getNetComponent()).categoryModule(new CategoryModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToProductListActivity(Category category) {

        Intent in = new Intent(this, ProductListActivity.class);
        in.putExtra("category", (Serializable) category);
        if(category.getProducts().size() == 0){
            Toast.makeText(this, "No Products", Toast.LENGTH_LONG).show();
        }else {
            startActivity(in);
        }
    }
}
