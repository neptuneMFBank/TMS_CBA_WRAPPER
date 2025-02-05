package com.neptune.cbawrapper.BuilderPattern;

import com.neptune.cbawrapper.Models.History;
import com.neptune.cbawrapper.Models.TransactionHistory;

import java.util.List;

public class HistoryBuilder {
    List<TransactionHistory> history;
    private Long totalItems;
    private Long totalPages;
    private Long currentPages;

    public HistoryBuilder setHistory(List<TransactionHistory> history) {
        this.history = history;
        return this;
    }

    public HistoryBuilder setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    public HistoryBuilder setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public HistoryBuilder setCurrentPages(Long currentPages) {
        this.currentPages = currentPages;
        return this;
    }

    public History build(){
        return new History(history, totalItems, totalPages, currentPages);
    }
}
