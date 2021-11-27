package com.cs.draw;

import com.cs.model.Fill;
import com.cs.model.Point;
import com.cs.validation.BorderValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;

@ExtendWith(MockitoExtension.class)
class ExecuteFillTest {

    @Mock
    private BorderValidation borderValidation;
    @InjectMocks
    private BucketFill bucketFill;

    @Test
    void testBucketFill() {
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenCallRealMethod();

        char[][] input = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', 'x', 'x', 'x', ' ', ' ', ' ', 'x', ' ', 'x', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        char[][] expectedOutput = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', 'o', 'o', 'o', 'o', 'x', ' ', 'x', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'o', '|'},
                {'|', 'x', 'x', 'x', 'o', 'o', 'o', 'x', ' ', 'x', 'o', '|'},
                {'|', ' ', ' ', 'x', 'o', 'o', 'o', 'x', 'x', 'x', 'o', '|'},
                {'|', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        bucketFill.draw(new Fill(10, 8, "B", new Point(4, 4), 'o'), input);
        Assertions.assertArrayEquals(expectedOutput, input);
    }

    @Test
    void xOutsideBorder() {
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        //x is outside border
        bucketFill.draw(new Fill(10, 8, "B", new Point(11, 4), 'o'), new char[][]{});
        Mockito.verify(borderValidation, Mockito.times(1)).withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void yOutsideBorder(){
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        //x is outside border
        bucketFill.draw(new Fill(10, 8, "B", new Point(10, 9), 'o'), new char[][]{});
        Mockito.verify(borderValidation, Mockito.times(1)).withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void xIsZeroBorder(){
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        //x is outside border
        bucketFill.draw(new Fill(10, 8, "B", new Point(0, 8), 'o'), new char[][]{});
        Mockito.verify(borderValidation, Mockito.times(1)).withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void yIsZeroBorder(){
        Mockito.when(borderValidation.withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        //x is outside border
        bucketFill.draw(new Fill(10, 8, "B", new Point(10, 0), 'o'), new char[][]{});
        Mockito.verify(borderValidation, Mockito.times(1)).withinBorder(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void testMoveUp() throws Exception {
        Method method = BucketFill.class.getDeclaredMethod("moveUp", int.class);
        method.setAccessible(true);
        Assertions.assertEquals(3, method.invoke(bucketFill, 4));
    }

    @Test
    void testMoveDown() throws Exception {
        Method method = BucketFill.class.getDeclaredMethod("moveDown", int.class);
        method.setAccessible(true);
        Assertions.assertEquals(5, method.invoke(bucketFill, 4));
    }

    @Test
    void testMoveLeft() throws Exception {
        Method method = BucketFill.class.getDeclaredMethod("moveDown", int.class);
        method.setAccessible(true);
        Assertions.assertEquals(5, method.invoke(bucketFill, 4));
    }

    @Test
    void testMoveRight() throws Exception {
        Method method = BucketFill.class.getDeclaredMethod("moveUp", int.class);
        method.setAccessible(true);
        Assertions.assertEquals(3, method.invoke(bucketFill, 4));
    }
}
