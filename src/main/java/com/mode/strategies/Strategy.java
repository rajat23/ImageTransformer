package com.mode.strategies;

import com.helper.RequestStructure;

import java.awt.*;

/**
 * Created by akshaysinghyaduvanshi on 2/19/15.
 */
public interface Strategy {
    public Dimension doOperation(RequestStructure requestStructure);
}
