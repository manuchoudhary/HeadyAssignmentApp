package headyassignmentapp.app.io.headyassignmentapp.screens.category.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by manishchoudhary on 02/12/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Category> listCategory = new ArrayList<>();


    public void swapAdapter(ArrayList<Category> category)
    {
        this.listCategory.clear();
        this.listCategory.addAll(category);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view ,itemClicks);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        Category category = listCategory.get(position);
        holder.bind(category);

    }


    @Override
    public int getItemCount() {
        if (listCategory != null && listCategory.size() > 0) {
            return listCategory.size();
        } else {
            return 0;
        }
    }
}
