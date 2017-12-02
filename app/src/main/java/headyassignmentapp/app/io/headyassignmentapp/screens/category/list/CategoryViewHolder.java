package headyassignmentapp.app.io.headyassignmentapp.screens.category.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import rx.subjects.PublishSubject;

/**
 * Created by manishchoudhary on 02/12/17.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.item_category_name)
    TextView categoryName;

    public CategoryViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }

    void bind(Category category) {
        categoryName.setText(TextUtils.isEmpty(category.getCategoryName()) ? "missing text" : category.getCategoryName());
    }

}

