package com.mode;

public class ModeFactory {
    public Mode create(String mode) {
        if(mode.equals("limit")) {
            return new LimitMode();
        }
        else if(mode.equals("fit")) {
            return new FitMode();
        }

    }
}
