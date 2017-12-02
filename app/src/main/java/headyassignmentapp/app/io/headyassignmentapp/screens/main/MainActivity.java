package headyassignmentapp.app.io.headyassignmentapp.screens.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import javax.inject.Inject;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.core.MainPresenter;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.core.MainView;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.dagger.DaggerMainComponent;
import headyassignmentapp.app.io.headyassignmentapp.screens.main.dagger.MainContextModule;
import headyassignmentapp.app.io.headyassignmentapp.screens.products.ProductListActivity;
import headyassignmentapp.app.io.headyassignmentapp.applications.AppController;

/**
 * Created by manish on 01/12/17.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    MainView view;
    @Inject
    MainPresenter mainPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder().
                appComponent(AppController.getNetComponent()).
                mainContextModule(new MainContextModule(this)).
                build().inject(this);

        setContentView(view.constructView());
        mainPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }

    public void showCategoryListActivity() {
        Log.d("loaded", "ok showed");
        Intent i = new Intent(this, ProductListActivity.class);
        startActivity(i);
    }
}
