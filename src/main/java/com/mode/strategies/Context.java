package com.mode.strategies;

import com.helper.RequestStructure;

import java.awt.*;

/**
 * Created by akshaysinghyaduvanshi on 2/19/15.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Dimension executeStrategy(Dimension dimension,float aspectRatio){
        return strategy.doOperation(dimension,aspectRatio);
    }
}
