package com.cs.parse;

import com.cs.draw.BucketFill;
import com.cs.model.Fill;
import com.cs.model.Point;
import com.cs.util.BucketFillUtil;
import com.cs.validation.InputParameterValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cs.constants.AppConstants.BUCKET_FILL;

@ExtendWith(MockitoExtension.class)
class ParseFillInputTest {

    @Mock
    private InputParameterValidation inputParameterValidation;
    @Mock
    private BucketFillUtil bucketFillUtil;
    @Mock
    private BucketFill bucketFill;
    @InjectMocks
    private ParseBucketFillInput parseBucketFillInput;

    private final char[][] input = {{'-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-'}
    };

    @Test
    void handleBucketFillInput() {
        Mockito.when(inputParameterValidation.valid(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(true);
        Mockito.when(bucketFillUtil.getShape(Mockito.any(), Mockito.any())).thenReturn(new Fill());
        Mockito.doNothing().when(bucketFill).draw(Mockito.any(), Mockito.any());

        parseBucketFillInput.parseBucketFillInput(new String[]{BUCKET_FILL, "1", "2", "o"}, input, new Fill(5, 5, BUCKET_FILL, new Point(1, 2), 'o'));
        Mockito.verify(bucketFill, Mockito.times(1)).draw(Mockito.any(), Mockito.any());
    }

    @Test
    void validationFailed() {
        Mockito.when(inputParameterValidation.valid(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(false);

        parseBucketFillInput.parseBucketFillInput(new String[]{BUCKET_FILL, "1", "2", "o"}, new char[][]{}, new Fill(5, 5, BUCKET_FILL, new Point(1, 2), 'o'));
        Mockito.verify(bucketFill, Mockito.never()).draw(Mockito.any(), Mockito.any());
    }
}
