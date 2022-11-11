package com.jnsgdm.freelacontrolapi.service;

import com.jnsgdm.freelacontrolapi.persistence.model.Project;
import org.springframework.stereotype.Service;

@Service
public class ProfitServiceImpl implements ProfitService{
    @Override
    public Double netProfit(Project project) {
        return (project.getGrossProfit()-project.getExpenses());
    }
}
