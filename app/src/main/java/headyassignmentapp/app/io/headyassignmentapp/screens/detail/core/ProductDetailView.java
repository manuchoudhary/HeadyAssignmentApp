package headyassignmentapp.app.io.headyassignmentapp.screens.detail.core;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.ProductDetailActivity;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductDetailView {

    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productTaxName)
    TextView productTaxName;

    View view;

    public ProductDetailView(ProductDetailActivity activity, Product product)
    {
        FrameLayout layout = new FrameLayout(activity);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(activity).inflate(R.layout.activity_product_detail,layout,true);
        ButterKnife.bind(this,view);

        productName.setText(TextUtils.isEmpty(product.getProductName()) ? "no name" : product.getProductName());

    }

    public View view()
    {
        return view;
    }
}
