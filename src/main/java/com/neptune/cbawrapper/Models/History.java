package com.neptune.cbawrapper.Models;

import java.util.List;

public class History {

    List<TransactionHistory> history;
    private Long totalItems;
    private Long totalPages;
    private Long currentPages;

    public List<TransactionHistory> getHistory() {
        return history;
    }

    public void setHistory(List<TransactionHistory> history) {
        this.history = history;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(Long currentPages) {
        this.currentPages = currentPages;
    }

    public History(List<TransactionHistory> history, Long totalItems, Long currentPages, Long totalPages) {
        this.history = history;
        this.totalItems = totalItems;
        this.currentPages = currentPages;
        this.totalPages = totalPages;
    }
}
