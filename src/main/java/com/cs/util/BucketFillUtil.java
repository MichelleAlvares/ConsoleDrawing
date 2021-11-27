package com.cs.util;

import com.cs.model.Fill;
import com.cs.model.Point;
import com.cs.model.Shape2D;

import java.util.Objects;

import static com.cs.constants.AppConstants.BUCKET_FILL;

public class BucketFillUtil implements GetShape {

    @Override
    public Shape2D getShape(String[] userInputArray, Shape2D shape2D) {
        return new Fill(shape2D.getWidth(), shape2D.getHeight(), BUCKET_FILL, new Point(Integer.parseInt(userInputArray[1]),
                Integer.parseInt(userInputArray[2])), Objects.requireNonNull(userInputArray[3]).toCharArray()[0]);
    }
}
