package com.example.foodorderingsystem.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodorderingsystem.Adapter.FrequentlyAskedQuestionAdapter;
import com.example.foodorderingsystem.Model.FrequentlyAskedQuestion;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionsFragment extends Fragment {
    ApiInterface apiInterface;
    List<FrequentlyAskedQuestion> listFrequentlyAskedQuestion;
    RecyclerView frequentlyAskedQuestionRecycler;
    FrequentlyAskedQuestionAdapter frequentlyAskedQuestionAdapter;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_frequently_asked_question, container, false);
        frequentlyAskedQuestionRecycler  = v.findViewById(R.id.frequentlyAskedQuestionRecycler);
        listFrequentlyAskedQuestion = new ArrayList<>();
        listFrequentlyAskedQuestion();
        return v;
    }

    private void listFrequentlyAskedQuestion() {
        apiInterface = Api.getClients();
        Call<List<FrequentlyAskedQuestion>> call = apiInterface.getFrequentlyAskedQuestion();
        call.enqueue(new Callback<List<FrequentlyAskedQuestion>>() {
            @Override
            public void onResponse(Call<List<FrequentlyAskedQuestion>> call, Response<List<FrequentlyAskedQuestion>> response) {
                listFrequentlyAskedQuestion = response.body();
                getFrequentlyAskedQuestionData();
            }

            @Override
            public void onFailure(Call<List<FrequentlyAskedQuestion>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFrequentlyAskedQuestionData() {
        frequentlyAskedQuestionAdapter = new FrequentlyAskedQuestionAdapter(getContext(), listFrequentlyAskedQuestion);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        frequentlyAskedQuestionRecycler.setLayoutManager(layoutManager);
        frequentlyAskedQuestionRecycler.setAdapter(frequentlyAskedQuestionAdapter);
    }

}
