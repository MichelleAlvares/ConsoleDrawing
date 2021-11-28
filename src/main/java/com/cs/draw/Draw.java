package com.cs.draw;

import com.cs.model.Shape2D;

interface Draw {

    boolean draw(Shape2D shape2D, char[][] currentState);

}
