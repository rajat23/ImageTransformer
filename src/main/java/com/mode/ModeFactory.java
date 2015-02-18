package com.mode;

public class ModeFactory {
    public Mode create(String mode) {
        if (mode.equals("limit")) {
            return new LimitMode();
        } else if (mode.equals("fit")) {
            return new FitMode();
        } else if (mode.equals("fill")) {
            return new FillMode();
        } else if (mode.equals("pad")) {
            return new PadMode();
        }
        return new DefaultMode();
    }
}
