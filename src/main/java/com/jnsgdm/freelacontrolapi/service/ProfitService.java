package com.jnsgdm.freelacontrolapi.service;

import com.jnsgdm.freelacontrolapi.persistence.model.Project;

public interface ProfitService {
    Double netProfit(Project project);
}
