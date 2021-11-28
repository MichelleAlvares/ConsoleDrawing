package com.cs.parse;

import com.cs.draw.BucketFill;
import com.cs.model.Fill;
import com.cs.model.Shape2D;
import com.cs.util.BucketFillUtil;
import com.cs.validation.InputParameterValidation;

import static com.cs.constants.AppConstants.BUCKET_FILL;

class ParseBucketFillInput {

    private InputParameterValidation inputParameterValidation;
    private BucketFillUtil bucketFillUtil;
    private BucketFill bucketFill;

    ParseBucketFillInput() {
        this.inputParameterValidation = new InputParameterValidation();
        this.bucketFillUtil = new BucketFillUtil();
        this.bucketFill = new BucketFill();
    }

    void parseBucketFillInput(String[] userInputArray, char[][] drawing, Shape2D shape2D) {
        if (inputParameterValidation.valid(BUCKET_FILL, drawing, userInputArray)) {
            Fill b = (Fill) bucketFillUtil.getShape(userInputArray, shape2D);
            bucketFill.draw(b, drawing);
        }
    }
}
