package headyassignmentapp.app.io.headyassignmentapp.screens.products.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import headyassignmentapp.app.io.headyassignmentapp.R;
import headyassignmentapp.app.io.headyassignmentapp.models.Category;
import headyassignmentapp.app.io.headyassignmentapp.models.Product;
import headyassignmentapp.app.io.headyassignmentapp.screens.category.list.CategoryViewHolder;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by manishchoudhary on 03/12/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Product> listProduct = new ArrayList<>();


    public void swapAdapter(ArrayList<Product> product)
    {
        this.listProduct.clear();
        this.listProduct.addAll(product);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view ,itemClicks);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Product product = listProduct.get(position);
        holder.bind(product);

    }


    @Override
    public int getItemCount() {
        if (listProduct != null && listProduct.size() > 0) {
            return listProduct.size();
        } else {
            return 0;
        }
    }
}

