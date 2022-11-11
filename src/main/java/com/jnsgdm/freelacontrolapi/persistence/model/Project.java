package com.jnsgdm.freelacontrolapi.persistence.model;

import com.jnsgdm.freelacontrolapi.service.ProfitServiceImpl;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ref")
    private String ref;

    @Column(name = "description")
    private String description;

    @Column(name = "gross_profit")
    private Double grossProfit;

    @Column(name = "expenses")
    private Double expenses;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "net_profit")
    private Double netProfit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit){
        this.netProfit = netProfit;
    }

    public void applyNetProfit(Project project){
        ProfitServiceImpl value = new ProfitServiceImpl();
        this.netProfit = value.netProfit(project);
    }
}
