package headyassignmentapp.app.io.headyassignmentapp.screens.category.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.CategoryListActivity;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.list.CategoryAdapter;
import rx.Observable;

/**
 * Created by manish on 02/12/17.
 */

public class CategoryView {

    @BindView(R.id.activity_category_list_recycleview)
    RecyclerView list;

    View view;

    CategoryAdapter adapter;

    public CategoryView(CategoryListActivity context ) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_category_list, parent, true);
        ButterKnife.bind(this, view);

        adapter = new CategoryAdapter();

        list.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        list.setLayoutManager(mLayoutManager);
    }

    public Observable<Integer> itemClicks()
    {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<Category> category) {
        adapter.swapAdapter(category);
    }
}
