package com.github.saden1.hk2testng.service.impl;

import com.github.saden1.hk2testng.service.PrimaryService;
import com.github.saden1.hk2testng.service.SecondaryService;
import javax.inject.Inject;
import org.jvnet.hk2.annotations.Service;

@Service
public class PrimaryServiceImpl implements PrimaryService {

    private final SecondaryService secondaryService;

    @Inject
    PrimaryServiceImpl(SecondaryService secondaryService) {
        this.secondaryService = secondaryService;
    }

    public SecondaryService getSecondaryService() {
        return secondaryService;
    }

}
