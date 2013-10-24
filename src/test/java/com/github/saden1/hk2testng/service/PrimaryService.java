package com.github.saden1.hk2testng.service;

import org.jvnet.hk2.annotations.Contract;

/**
 *
 * @author saden
 */
@Contract
public interface PrimaryService {

    SecondaryService getSecondaryService();
}
