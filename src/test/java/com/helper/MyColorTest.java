package com.helper;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MyColorTest {

    @Test
    public void testToHex() throws Exception {
        String color="#123456";
        String returnedColor=MyColor.toHex(color);
        assertEquals(returnedColor,"0x123456");
    }

    @Test
    public void testGetColor() throws Exception {
        String color="#123456";
        Color returnedColor=MyColor.getColor(color);
        assertEquals(returnedColor,Color.decode("0x123456"));

    }
}