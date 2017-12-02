package headyassignmentapp.app.io.headyassignmentapp.screens.main.core;

import android.util.Log;

import rx.Subscription;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;
import headyassignmentapp.app.io.headyassignmentapp.utils.UiUtils;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by manish on 01/12/17.
 */

public class MainPresenter {

    private MainModel model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscriptions;


    public MainPresenter(MainModel model, RxSchedulers schedulers, CompositeSubscription subscriptions) {
        this.model = model;
        this.rxSchedulers = schedulers;
        this.subscriptions = subscriptions;
    }


    public void onCreate() {
        subscriptions.add(getCategoryList());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription getCategoryList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connection");
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.isNetworkAvailable()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(aBoolean -> model.gotoCategoryListActivity(), throwable -> UiUtils.handleThrowable(throwable));
    }

}
