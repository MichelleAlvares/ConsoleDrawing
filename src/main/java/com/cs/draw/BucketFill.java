package com.cs.draw;

import com.cs.model.Fill;
import com.cs.model.Shape2D;
import com.cs.validation.BorderValidation;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static com.cs.constants.AppConstants.*;

public class BucketFill implements Draw {

    private BorderValidation borderValidation;

    public BucketFill() {
        this.borderValidation = new BorderValidation();
    }

    @Override
    public void draw(Shape2D fill, char[][] drawing) {
        Fill bucketFill = (Fill) fill;
        int x = bucketFill.getFillStartPoint().getX();
        int y = bucketFill.getFillStartPoint().getY();
        int h = bucketFill.getHeight();
        int w = bucketFill.getWidth();
        char colour = bucketFill.getNewColour();

        if (BUCKET_FILL.equals(bucketFill.getType()) && borderValidation.withinBorder(x, y, w, h)) {
            Queue<List<Integer>> adjacentPoints = new ArrayDeque<>();
            adjacentPoints.add(List.of(x, y));
            bucketFill.setOldColour(drawing[y][x]);
            List<Integer> l;

            while (!adjacentPoints.isEmpty()) {
                l = adjacentPoints.poll();
                x = l.get(0);
                y = l.get(1);
                if (drawing[y][x] == bucketFill.getOldColour()) {
                    drawing[y][x] = colour;
                }
                addAdjacent(bucketFill, x, y, adjacentPoints, drawing);
            }
        } else borderValidation.printInvalidInputMessage();
    }

    private void addAdjacent(Fill bucketFill, int x, int y, Queue<List<Integer>> q, char[][] list) {
        addToQueue(bucketFill, x, moveUp(y), q, list);
        addToQueue(bucketFill, x, moveDown(y), q, list);
        addToQueue(bucketFill, moveRight(x), y, q, list);
        addToQueue(bucketFill, moveLeft(x), y, q, list);
    }

    private void addToQueue(Fill bucketFill, int x, int y, Queue<List<Integer>> q, char[][] currentState) {
        if (borderValidation.withinBorder(x, y, bucketFill.getWidth(), bucketFill.getHeight())) {
            char currentChar = currentState[y][x];

            if (!(currentChar == (PIPE) || currentChar == (DASH) || currentChar == (bucketFill.getNewColour())) && currentChar == bucketFill.getOldColour()) {

                q.add(List.of(x, y));
                currentState[y][x] = bucketFill.getNewColour();
            }
        }
    }

    private int moveUp(int y) {
        return y - 1;
    }

    private int moveDown(int y) {
        return y + 1;
    }

    private int moveRight(int x) {
        return x + 1;
    }

    private int moveLeft(int x) {
        return x - 1;
    }
}
