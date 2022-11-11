package com.jnsgdm.freelacontrolapi.dto;

public class ProjectDto {
    private String ref;

    private String description;

    private Double grossProfit;

    private Double expenses;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Double grossProfit) {
        this.grossProfit = grossProfit;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }
}
