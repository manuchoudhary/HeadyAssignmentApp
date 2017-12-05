package headyassignmentapp.app.io.headyassignmentapp.screens.detail.core;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.models.Variant;
import headyassignmentapp.app.io.headyassignmentapp.screens.detail.ProductDetailActivity;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductDetailView {

    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productVariantColors)
    TextView productVariantColors;
    @BindView(R.id.productVariantSizes)
    TextView productVariantSizes;

    StringBuffer variantColors;
    StringBuffer variantSizes;

    View view;

    public ProductDetailView(ProductDetailActivity activity, Product product)
    {
        FrameLayout layout = new FrameLayout(activity);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(activity).inflate(R.layout.activity_product_detail,layout,true);
        ButterKnife.bind(this,view);

        getSizesAndColors(product.getVariants());
        productName.setText(TextUtils.isEmpty(product.getProductName()) ? "No Name" : product.getProductName());
        productVariantColors.setText(TextUtils.isEmpty(variantColors) ? "No Colors" : variantColors);

        productVariantSizes.setText(TextUtils.isEmpty(variantSizes) ? "No Size" : variantSizes);

    }

    private void getSizesAndColors(ArrayList<Variant> variants){
        variantSizes = new StringBuffer();
        variantColors = new StringBuffer();
        for(Variant item : variants) {
            Integer val = item.getSize();
            if(val != null){
                variantSizes.append("NA ");
            }else{
                variantSizes.append(item.getSize() + " ");
            }
            variantColors.append(item.getColor() + " ");
        }
    }

    public View view()
    {
        return view;
    }
}
