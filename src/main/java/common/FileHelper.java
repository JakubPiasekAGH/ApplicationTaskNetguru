package common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileHelper
{
    public static InputStream getFileFromResourcesAsInputStreamByName(String name)
    {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(name);
    }

    public static File getFileFromResourcesByName(String name)
    {
        return new File(ClassLoader.getSystemResource(name).getFile());
    }

    public static BufferedImage getImageFromResources(String name) throws IOException
    {
        return ImageIO.read(getFileFromResourcesByName(name));
    }
}
