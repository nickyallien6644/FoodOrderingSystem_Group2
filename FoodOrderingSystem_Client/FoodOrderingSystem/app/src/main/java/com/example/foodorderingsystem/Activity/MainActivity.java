package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;

//import android.view.MenuItem;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.AllMenuAdapter;
import com.example.foodorderingsystem.Adapter.PopularAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedAdapter;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.fragment.HomeFragment;
import com.example.foodorderingsystem.fragment.NotificationFragment;
import com.example.foodorderingsystem.fragment.PrivacyFragment;
import com.example.foodorderingsystem.fragment.ProfileFragment;
import com.example.foodorderingsystem.fragment.QuestionsFragment;
import com.example.foodorderingsystem.fragment.SupportFragment;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    List<Product> listProducts ;

    RecyclerView popularRecyclerView;
    PopularAdapter popularAdapter;

    RecyclerView recommendedRecyclerView;
    RecommendedAdapter recommendedAdapter;

    RecyclerView allMenuRecyclerView;
    AllMenuAdapter allMenuAdapter;

    //Global Declaration
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);
        listProducts = new ArrayList<>();
        listProducts();

        initation();


    }

    public void listProducts() {
        apiInterface = Api.getClients();

        Call<List<Product>> call = apiInterface.getProducts ();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProducts = response.body();
               getPopularData();
               getRecommendedData();
               getAllMenuData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPopularData() {
        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);
    }

    private void getRecommendedData() {
        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this, listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);
    }

    private void getAllMenuData() {
        allMenuRecyclerView = findViewById(R.id.allMenu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
    }

    private void initation(){


        //Inside onCreate()

        sNavigationDrawer = findViewById(R.id.navigationDrawer);

        //Creating a list of menu Items

        List<MenuItem> menuItems = new ArrayList<>();

        //Use the MenuItem given by this library and not the default one.
        //First parameter is the title of the menu item and then the second parameter is the image which will be the background of the menu item.

        menuItems.add(new MenuItem("Home",R.drawable.food_bg));
        menuItems.add(new MenuItem("My profile",R.drawable.profile_bg));
        menuItems.add(new MenuItem("Notification",R.drawable.noti_bg));
        menuItems.add(new MenuItem("Frequently asked questions",R.drawable.ques_bg));
        menuItems.add(new MenuItem("Privacy Policy",R.drawable.security_bg));
        menuItems.add(new MenuItem("Support",R.drawable.supppor_bg));
        menuItems.add(new MenuItem("Sign out",R.drawable.exit_bg));

        //then add them to navigation drawer

        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  HomeFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }



        //Listener to handle the menu item click. It returns the position of the menu item clicked. Based on that you can switch between the fragments.

        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position){
                    case 0:{
                        fragmentClass = HomeFragment.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = ProfileFragment.class;
                        break;
                    }
                    case 2:{
                        fragmentClass = NotificationFragment.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = QuestionsFragment.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = PrivacyFragment.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = SupportFragment.class;
                        break;
                    }
                    case 6:{
                        signout();
                        break;
                    }

                }

                //Listener for drawer events such as opening and closing.
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });

    }

    public void signout(){
        SessionManagement sessionManagement = new SessionManagement (MainActivity.this);
        sessionManagement.removeSession ();
        Intent intent =new Intent(MainActivity.this, SignInActivity.class);
        startActivity(intent);
        overridePendingTransition (R.anim.slide_in_right,R.anim.slide_out_left);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keyCode, event);
    }

}