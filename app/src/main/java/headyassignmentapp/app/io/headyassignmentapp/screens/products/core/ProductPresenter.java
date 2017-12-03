package headyassignmentapp.app.io.headyassignmentapp.screens.products.core;

import android.util.Log;

import java.util.ArrayList;

import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryModel;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryView;
import headyassignmentapp.app.io.headyassignmentapp.utils.UiUtils;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductPresenter {

    ProductView view;
    ProductModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<Product> product = new ArrayList<>();

    public ProductPresenter(RxSchedulers schedulers, ProductModel model, ProductView view, CompositeSubscription sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate(ArrayList<Product> products) {
        Log.d("enter to presenter", "oki");
        this.product = products;
        view.swapAdapter(product);
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoProductDetailActivity(product.get(integer)));
    }
}
