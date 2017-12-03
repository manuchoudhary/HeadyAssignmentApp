package headyassignmentapp.app.io.headyassignmentapp.screens.products.list;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import rx.subjects.PublishSubject;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.item_product_name)
    TextView productName;

    public ProductViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }

    void bind(Product product) {
        productName.setText(TextUtils.isEmpty(product.getProductName()) ? "missing text" : product.getProductName());
    }

}
