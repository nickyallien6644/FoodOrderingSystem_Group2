package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodorderingsystem.Model.FrequentlyAskedQuestion;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FrequentlyAskedQuestionAdapter extends RecyclerView.Adapter<FrequentlyAskedQuestionAdapter.FrequentlyAskedQuestionViewHolder> {
    private Context context;
    private List<FrequentlyAskedQuestion> frequentlyAskedQuestionList;

    public FrequentlyAskedQuestionAdapter(Context context, List<FrequentlyAskedQuestion> frequentlyAskedQuestionList) {
        this.context = context;
        this.frequentlyAskedQuestionList = frequentlyAskedQuestionList;
    }

    @NonNull
    @NotNull
    @Override
    public FrequentlyAskedQuestionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.frequently_asked_question_items, parent, false);
        return new FrequentlyAskedQuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FrequentlyAskedQuestionViewHolder holder, int position) {
        holder.faqQuestion.setText(frequentlyAskedQuestionList.get(position).getFaqQuestion());
        holder.faqAnswer.setText(frequentlyAskedQuestionList.get(position).getFaqAnswer());
    }

    @Override
    public int getItemCount() {
        return frequentlyAskedQuestionList.size();
    }

    public static class FrequentlyAskedQuestionViewHolder extends RecyclerView.ViewHolder {
        TextView faqQuestion, faqAnswer;

        public FrequentlyAskedQuestionViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            faqQuestion = itemView.findViewById(R.id.frequentlyAskedQuestion_Question);
            faqAnswer = itemView.findViewById(R.id.frequentlyAskedQuestion_Answer);
        }
    }
}
