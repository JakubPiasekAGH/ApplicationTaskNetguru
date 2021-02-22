package common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileHelper
{
    private FileHelper()
    {
        //Utility classes, which are collections of static members, are not meant to be instantiated. Even abstract
        //utility classes, which can be extended, should not have public constructors.
        //Java adds an implicit public constructor to every class which does not define at least one explicitly.
        //Hence, at least one non-public constructor should be defined.
    }

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
