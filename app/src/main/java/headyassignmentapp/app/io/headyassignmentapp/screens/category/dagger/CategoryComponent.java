package headyassignmentapp.app.io.headyassignmentapp.screens.category.dagger;

import dagger.Component;
import headyassignmentapp.app.io.headyassignmentapp.applications.builder.AppComponent;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.CategoryListActivity;

/**
 * Created by manishchoudhary on 02/12/17.
 */

@CategoryScope
@Component(dependencies = {AppComponent.class} , modules = {CategoryModule.class})
public interface CategoryComponent {

    void inject (CategoryListActivity heroesActivity);
}
