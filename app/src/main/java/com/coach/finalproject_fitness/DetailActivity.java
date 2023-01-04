package com.coach.finalproject_fitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.coach.finalproject_fitness.databinding.ActivityDetailBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Diet>> {

    private RecyclerView.LayoutManager mLayoutManager;
    private CustomRecyclerViewAdapter adapter;
    private RequestQueue mRequestQueue;

    int progressStatus = 0;
    String key;

    // JSON related
    private JSONArray diet;
    private JSONObject dietJSONObject;

    private ArrayList<Diet> mArrayList;

    LoaderManager loaderManager=null;
    ActivityDetailBinding binding;
    private static int TASK_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.progressBar.setMax(100);
        mLayoutManager = new LinearLayoutManager(this);
        binding.recyclerViewBooks.setLayoutManager(mLayoutManager);

        // volley related (https://developer.android.com/training/volley/requestqueue)
        mRequestQueue = Volley.newRequestQueue(this);
    }

    public void onClick(View v) {

        mArrayList = new ArrayList<Diet>();
        key = binding.etKey.getText().toString();

        String BOOKS_URL = "https://api.jsonserve.com/-2aRYX";

        JSONObject objtoSend = new JSONObject(); // how data can be send to web server with the JsonObjectRequest
        try {
            objtoSend.put("findBook", key); //{findbook:two}
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // volley related (https://developer.android.com/training/volley/request)
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.DEPRECATED_GET_OR_POST, BOOKS_URL, objtoSend,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dietJSONObject = response;
                        Log.d("RESPONSE", response.toString());

                        // Call to AsyncTaskLoader to parse JSON
                        if(loaderManager == null) {
                            loaderManager = LoaderManager.getInstance(DetailActivity.this);
                            loaderManager.initLoader(TASK_ID, null, DetailActivity.this).forceLoad();
                        }
                        else {
                            loaderManager.restartLoader(TASK_ID, null, DetailActivity.this).forceLoad();
                            Log.d("ASYNTASKLODER", "Loader restarted");
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Result",
                        "ERROR JSONObject request" + error.toString());
                binding.progressBar.setVisibility(View.INVISIBLE);
            }
        });
        mRequestQueue.getCache().clear();
        mRequestQueue.add(jsonObjectRequest);

    }


    @NonNull
    @Override
    public Loader<ArrayList<Diet>> onCreateLoader(int id, @Nullable Bundle args) {
        Log.d("ASYNTASKLODER", "onCreateLoader");
        return new FetchData(this, dietJSONObject);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Diet>> loader) {
        Log.d("ASYNTASKLODER", "onLoaderReset");
        adapter = new CustomRecyclerViewAdapter(this, DietSys.mArrayList);
        binding.recyclerViewBooks.setAdapter(adapter);
        binding.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Diet>> loader, ArrayList<Diet> data) {
        Log.d("ASYNTASKLODER", "onLoadFinished");
        DietSys.mArrayList = data;
        adapter = new CustomRecyclerViewAdapter(this, DietSys.mArrayList);
        binding.recyclerViewBooks.setAdapter(adapter);
        binding.progressBar.setVisibility(View.INVISIBLE);
        loader.stopLoading();
    }


    private static class FetchData extends AsyncTaskLoader<ArrayList<Diet>> {

        Context context;
        JSONObject dietJSONObject;
        public FetchData(Context context, JSONObject dietJSONObject) {
            super(context);
            this.context = context;
            this.dietJSONObject = dietJSONObject;
            Log.d("ASYNTASKLODER", "FetchData");
        }
        @Override
        public ArrayList<Diet> loadInBackground () {
            Log.d("ASYNTASKLODER", "loadInBackground");
            ArrayList<Diet> tempList = new ArrayList<Diet>();
            if (dietJSONObject != null) {
                try {
                    // Getting JSON Array
                    JSONArray diet = dietJSONObject.getJSONArray(DietSys.TAG_DIET);
                    Log.d("ASYNTASKLODER", diet.toString());

                    // looping through all books
                    for (int i = 0; i < diet.length(); i++) {
                        Log.d("ASYNTASKLODER", "book object "+i);

                        JSONObject jsonObj = diet.getJSONObject(i);

                        Thread.sleep(1000);//This is here only to simulate parsing json takes time so that ProgressBar execution can be displayed better

                        String day = jsonObj.getString(DietSys.TAG_DAY);
                        String meal = jsonObj.getString(DietSys.TAG_MEAL);


                        Diet diet1 = new Diet(day, meal);

                        tempList.add(diet1);
                    }
                } catch (JSONException ee) {
                    ee.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.d("ASYNTASKLODER", "ArrayList: "+tempList.toString());
            return tempList;
        }
    }
}