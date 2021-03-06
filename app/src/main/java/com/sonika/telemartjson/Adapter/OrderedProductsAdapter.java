package com.sonika.telemartjson.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sonika.telemartjson.OrderedProducts;
import com.sonika.telemartjson.Pojo.AllProducts;
import com.sonika.telemartjson.R;

import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by sonika on 9/22/2017.
 */

public class OrderedProductsAdapter extends RecyclerView.Adapter<OrderedProductHolder> {
    public Context context;
    private List<AllProducts> allProductList;
    AllProducts allProducts = new AllProducts();



    public OrderedProductsAdapter(Context context, List<AllProducts> allproductList) {
        this.context = context;
        this.allProductList = allproductList;
    }
    @Override
    public OrderedProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.ordered_products_list, parent, false);

        return new OrderedProductHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderedProductHolder holder, int position) {
        Log.e("hellllloooo", "khokho");

        holder.ordered_price.setText("getName" );
        holder.ordered_name.setText("hello");
    }

    @Override
    public int getItemCount() {
        return allProductList.size();
    }
}
