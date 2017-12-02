package headyassignmentapp.app.io.headyassignmentapp.screens.category.core;

import android.util.Log;

import java.util.ArrayList;

import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.utils.UiUtils;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by manish on 02/12/17.
 */

public class CategoryPresenter {

    CategoryView view;
    CategoryModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<Category> categories = new ArrayList<>();

    public CategoryPresenter(RxSchedulers schedulers, CategoryModel model, CategoryView view, CompositeSubscription sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate() {

        Log.d("enter to presenter", "oki");
        subscriptions.add(getHeroesList());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoProductListActivity(categories.get(integer)));
    }


    private Subscription getHeroesList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
                // UiUtils.showSnackbar();
                // Show Snackbar can't use app
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.provideListCategory()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(category -> {
                    Log.d("ok loaded", "cccc");
                    view.swapAdapter((ArrayList<Category>) category.getElements());
                    categories = (ArrayList<Category>) category.getElements();
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                }
        );

    }
}
