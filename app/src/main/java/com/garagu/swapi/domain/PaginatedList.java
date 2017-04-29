package com.garagu.swapi.domain;

import java.util.Collections;
import java.util.List;

/**
 * Created by garagu.
 */
public class PaginatedList<T> {

    private List<T> items;
    private boolean hasMore;
    private int page;

    private PaginatedList(List<T> items, boolean hasMore, int page) {
        this.items = items;
        this.hasMore = hasMore;
        this.page = page;
    }

    public static <TT> Builder<TT> builder() {
        return new Builder<>();
    }

    public List<T> getItems() {
        return items;
    }

    public boolean hasMore() {
        return hasMore;
    }

    public int getPage() {
        return page;
    }

    public static class Builder<TT> {

        private List<TT> items = Collections.emptyList();
        private boolean hasMore;
        private int page;

        public PaginatedList.Builder<TT> withItems(List<TT> items) {
            this.items = items;
            return this;
        }

        public PaginatedList.Builder<TT> withHasMore(boolean hasMore) {
            this.hasMore = hasMore;
            return this;
        }

        public PaginatedList.Builder<TT> withPage(int page) {
            this.page = page;
            return this;
        }

        public PaginatedList<TT> build() {
            return new PaginatedList<>(items, hasMore, page);
        }

    }

}