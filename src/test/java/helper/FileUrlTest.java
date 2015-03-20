package helper;

import helper.FileUrl;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileUrlTest {

    @Test
    public void testGetFileExtension() throws Exception {
        FileUrl fileUrl=new FileUrl();
        String url="http://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg";

        String extension=fileUrl.getFileExtension(url);

        assertEquals(extension,"jpg");
    }
}