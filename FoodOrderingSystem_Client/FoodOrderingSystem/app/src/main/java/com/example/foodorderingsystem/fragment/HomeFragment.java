package com.example.foodorderingsystem.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.foodorderingsystem.Activity.AllProduct;
import com.example.foodorderingsystem.Activity.AllProductForRecommended;
import com.example.foodorderingsystem.Activity.CartActivity;
import com.example.foodorderingsystem.Activity.SearchActivity;
import com.example.foodorderingsystem.Adapter.AllMenuAdapter;
import com.example.foodorderingsystem.Adapter.CategoryAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedAdapter;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Category;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ApiInterface apiInterface;
    List<Product> listProducts ;
    List<Product> listProductForRecommended;
    List<Category> listCategory;
    List<Product> listProductSearch;
    RecyclerView categoryRecyclerView;
    CategoryAdapter categoryAdapter;
    private MeowBottomNavigation bnv_Home;
    RecyclerView recommendedRecyclerView;
    RecommendedAdapter recommendedAdapter;
    SearchView txtSearchProduct;

    RecyclerView allMenuRecyclerView;
    AllMenuAdapter allMenuAdapter;

    TextView seeAllProductForRecommended, seeAllProduct;

    ImageView shoppingCart;

    public HomeFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main,container,false);
        categoryRecyclerView = v.findViewById(R.id.category_recycler);
        recommendedRecyclerView = v.findViewById(R.id.recommended_recycler);
        allMenuRecyclerView = v.findViewById(R.id.allMenu_recycler);

        bnv_Home = v.findViewById(R.id.bnv_Main);
        bnv_Home.add(new MeowBottomNavigation.Model(1, R.drawable.outline_paid_24));
        bnv_Home.add(new MeowBottomNavigation.Model(2, R.drawable.home));
        bnv_Home.add(new MeowBottomNavigation.Model(3, R.drawable.outline_history_24));
        bnv_Home.show(2, true);
        txtSearchProduct = (SearchView) v.findViewById(R.id.txtSearchProducts);
        searchProduct();

        seeAllProductForRecommended = v.findViewById(R.id.txtSeeAllRecommended);
        seeAllProductForRecommended.setOnClickListener(seeAllProductForRecommended());

        seeAllProduct = v.findViewById(R.id.txtSeeAllProduct);
        seeAllProduct.setOnClickListener(seeAllProduct());

        shoppingCart = v.findViewById(R.id.shoppingCart);
        shoppingCart.setOnClickListener(displayCart());

        setUpNav();
        listCategory = new ArrayList<>();
        listCategory();
        listProducts = new ArrayList<>();
        listProducts();
        listProductForRecommended = new ArrayList<>();
        listProductForRecommended();

        // Inflate the layout for this fragment
        return v;
    }

    public void listProducts() {
        apiInterface = Api.getClients();

        Call<List<Product>> call = apiInterface.getProductAllProduct ();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProducts = response.body();
                getAllMenuData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listCategory() {
        apiInterface = Api.getClients();

        Call<List<Category>> call = apiInterface.getCategory ();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                listCategory = response.body();
                getCategoryData();
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listProductForRecommended() {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProductForRecommended();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProductForRecommended = response.body();
                getRecommendedData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCategoryData() {
        categoryAdapter = new CategoryAdapter(getContext(), listCategory);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void getRecommendedData() {
        recommendedAdapter = new RecommendedAdapter(getContext(), listProductForRecommended);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);
    }

    private void getAllMenuData() {
        allMenuAdapter = new AllMenuAdapter(getContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
    }
    public void setUpNav(){
        bnv_Home.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new BcoinsFragment());
                        break;

                    case 2:
                        replace(new HomeFragment());

                        break;

                    case 3:
                        replace(new HistoryFragment());
                        break;
                }
                return null;
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.hearder1,fragment);
        transaction.commit();
    }

    public void searchProduct() {
        txtSearchProduct.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getActivity().getBaseContext(), SearchActivity.class);
                intent.putExtra("search", query);
                getActivity().startActivity(intent);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private View.OnClickListener displayCart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CartActivity.class));
            }
        };
    }

    private View.OnClickListener seeAllProductForRecommended() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllProductForRecommended.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener seeAllProduct() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllProduct.class);
                startActivity(intent);
            }
        };
    }

}
