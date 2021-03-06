package com.sonika.telemartjson;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.sonika.telemartjson.Adapter.OrderAdapter;
;

import com.sonika.telemartjson.Helper.OrderHelper;
import com.sonika.telemartjson.Pojo.OrderedProducts_pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 9/22/2017.
 */

public class OrderedProducts extends AppCompatActivity {
    //RecyclerView orders_recyclerView;
    ListView lv;
    OrderHelper dbhelper;
    OrderedProducts_pojo orderedProducts;
    List<OrderedProducts_pojo> orderedProductsList = new ArrayList<>();
    TextView totalAmount;
    double total = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordered_products);
        lv = (ListView) findViewById(R.id.ordererd_productList);
        dbhelper = new OrderHelper(OrderedProducts.this);
        totalAmount = (TextView) findViewById(R.id.totalamount);
        total = getTotal(orderedProductsList);
        show();

    }

    private void show() {
        final ArrayList<OrderedProducts_pojo> list = dbhelper.getOrderMessage();
        for (int i = 0; i < list.size(); i++) {
            final OrderedProducts_pojo info = list.get(i);
            final OrderAdapter notifyAdapter = new OrderAdapter(OrderedProducts.this, R.layout.ordered_products_list, list);
            lv.setAdapter(notifyAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }

    private double getTotal(List<OrderedProducts_pojo> pojo) {
        for (int i = 0; i < pojo.size(); i ++)
        {
           pojo.get(i);
            total = Double.parseDouble(total + orderedProducts.getOrderedprice());
            dbhelper = new OrderHelper(getApplicationContext());
            dbhelper.add(String.valueOf(total));
        }

        return 0;
    }
}
//        orders_recyclerView = (RecyclerView) findViewById(R.id.or);
//        //Toast.makeText(this, orderedProducts.getOrderedname(), Toast.LENGTH_SHORT).show();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderedProducts.this);
//        orders_recyclerView.setLayoutManager(linearLayoutManager);
//        orders_recyclerView.setHasFixedSize(true);
//        OrderedProductsAdapter orderAdapter = new OrderedProductsAdapter
//                (getApplicationContext(), orderedProductsList);
//        orders_recyclerView.setAdapter(orderAdapter);




      //  Toast.makeText(this, allProducts.getName(), Toast.LENGTH_SHORT).show();

//adding to cart

//        MySharedPreference mShared = new MySharedPreference(OrderedProducts_pojo.this);
//
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        AllProducts[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(), AllProducts[].class);
//        List<AllProducts> productList = convertObjectArrayToListObject(addCartProducts);

//        OrderedProductsAdapter mAdapter = new OrderedProductsAdapter(getApplicationContext(), productList);
//        orders_recyclerView.setAdapter(mAdapter);
//    }
//
//    private List<AllProducts> convertObjectArrayToListObject(AllProducts[] allProducts){
//       // final AllProducts allProductsa = (AllProducts) getIntent().getSerializableExtra("hello");
//        //List<AllProducts> mProduct = new ArrayList<AllProducts>();
//        AllProducts mProduct =(AllProducts) getIntent().getSerializableExtra("hello");
//        allProductList.add(mProduct);
//        Collections.addAll(allProductList, allProducts);
//        return allProductList;
//   }
//}
