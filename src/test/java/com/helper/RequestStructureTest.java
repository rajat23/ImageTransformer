package com.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestStructureTest {

    @Test
    public void testGetProportionalHeight() throws Exception {
        RequestStructure requestStructure=new RequestStructure();
        int height=requestStructure.getProportionalHeight(600, 1.5f);
        assertEquals(height,400);

    }

    @Test
    public void testGetProportionalWidth() throws Exception {
        RequestStructure requestStructure=new RequestStructure();
        int width=requestStructure.getProportionalWidth(600, 1.5f);
        assertEquals(width,900);

    }

    @Test
    public void testGetAspectRatio() throws Exception {
        RequestStructure requestStructure=new RequestStructure();
        float aspectRatio=requestStructure.getAspectRatio(900,600);
        assertEquals(aspectRatio,1.5f,0.0f);
    }
}