package headyassignmentapp.app.io.headyassignmentapp.screens.category.dagger;

import dagger.Module;
import dagger.Provides;
import headyassignmentapp.app.io.headyassignmentapp.api.ProductApi;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.CategoryListActivity;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryModel;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryPresenter;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.core.CategoryView;
import headyassignmentapp.app.io.headyassignmentapp.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by manishchoudhary on 02/12/17.
 */

@Module
public class CategoryModule {

    CategoryListActivity categoryListContext;

    public CategoryModule(CategoryListActivity context) {
        this.categoryListContext = context;
    }



    @CategoryScope
    @Provides
    CategoryView provideView() {
        return new CategoryView(categoryListContext);
    }

    @CategoryScope
    @Provides
    CategoryPresenter providePresenter(RxSchedulers schedulers, CategoryView view, CategoryModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new CategoryPresenter(schedulers, model, view, subscriptions);
    }



    @CategoryScope
    @Provides
    CategoryListActivity provideContext() {
        return categoryListContext;
    }
    @CategoryScope
    @Provides
    CategoryModel provideModel(ProductApi api) {
        return new CategoryModel(categoryListContext, api);
    }
}
