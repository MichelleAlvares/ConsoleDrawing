package com.cs.parse;

import com.cs.draw.BucketFill;
import com.cs.model.Fill;
import com.cs.model.Shape2D;
import com.cs.util.BucketFillUtil;
import com.cs.validation.InputParameterValidation;

import static com.cs.constants.AppConstants.BUCKET_FILL;

public class ParseBucketFillInput {

    private InputParameterValidation inputParameterValidation;
    private BucketFillUtil bucketFillUtil;
    //private ExecuteBucketFill executeBucketFill;
    private BucketFill bucketFill;

    public ParseBucketFillInput() {
        this.inputParameterValidation = new InputParameterValidation();
        this.bucketFillUtil = new BucketFillUtil();
        this.bucketFill = new BucketFill();
    }

    public void parseBucketFillInput(String[] userInputArray, char[][] drawing, Shape2D shape2D) {
        if (inputParameterValidation.isCanvasDrawn(drawing)
                && inputParameterValidation.areCorrectNoOfParametersEntered(BUCKET_FILL, userInputArray)
                && inputParameterValidation.areParameterTypesCorrect(BUCKET_FILL, userInputArray)) {
            Fill b = (Fill) bucketFillUtil.getShape(userInputArray, shape2D);
            bucketFill.draw(b, drawing);
        }
    }
}
