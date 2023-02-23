package com.mishura.action;

import com.mishura.service.UniversityService;

public interface Action {

    UniversityService service = UniversityService.getInstance();

    void execute();
}
