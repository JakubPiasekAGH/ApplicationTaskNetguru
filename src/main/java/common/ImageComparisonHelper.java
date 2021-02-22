package common;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class ImageComparisonHelper
{
    private ImageComparisonHelper()
    {
        //Utility classes, which are collections of static members, are not meant to be instantiated. Even abstract
        //utility classes, which can be extended, should not have public constructors.
        //Java adds an implicit public constructor to every class which does not define at least one explicitly.
        //Hence, at least one non-public constructor should be defined.
    }

    /**
     * Compares image pixel by pixel and returns comparison success rate in %
     *
     * @param imageToCompare - image to compare passed as BufferedImage
     * @param referenceImage - reference image passed as BufferedImage
     * @return double value from 0.0-1.0 where 1.0 means 100% pixel to pixel equality and 0.0 means no equality
     */
    public static double compareImage(BufferedImage imageToCompare, BufferedImage referenceImage)
    {
        var imageToCompareDataBuffer = imageToCompare.getData().getDataBuffer();
        var referenceImageDataBuffer = referenceImage.getData().getDataBuffer();
        var imageToCompareSize = imageToCompareDataBuffer.getSize();
        return imageToCompareSize == referenceImageDataBuffer.getSize() ? (double) IntStream.range(0,
                imageToCompareSize)
                .filter(i -> imageToCompareDataBuffer.getElem(i) == referenceImageDataBuffer.getElem(i))
                .count() / (double) imageToCompareSize : 0;
    }
}