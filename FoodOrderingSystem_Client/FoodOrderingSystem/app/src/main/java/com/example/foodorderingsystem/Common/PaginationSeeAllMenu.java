package com.example.foodorderingsystem.Common;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public abstract class PaginationSeeAllMenu extends RecyclerView.OnScrollListener{
    private LinearLayoutManager linearLayoutManager;

    public PaginationSeeAllMenu(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = linearLayoutManager.getChildCount();
        int totalItemCount = linearLayoutManager.getItemCount();
        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

        if(isLoading() || isLastPage()) return;

        if(firstVisibleItemPosition >= 0 && (visibleItemCount+firstVisibleItemPosition) >= totalItemCount) loadMoreItems();

    }

    public abstract void loadMoreItems();
    public abstract boolean isLoading();
    public abstract boolean isLastPage();
}
