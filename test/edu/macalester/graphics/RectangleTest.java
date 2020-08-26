package edu.macalester.graphics;

import static edu.macalester.graphics.testsupport.RenderingTestMode.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.macalester.graphics.testsupport.GraphicsObjectTestSuite;
import edu.macalester.graphics.testsupport.RenderingTest;

public class RectangleTest implements GraphicsObjectTestSuite {

    private Rectangle rect;

    @Override
    public GraphicsObject getGraphicsObject() {
        return rect;
    }
    
    @RenderingTest(modes = { PLAIN, STROKED, FILLED, FILLED_AND_STROKED, HIT_TEST })
    void regularRect() {
        rect = new Rectangle(17, 24.5, 60.5, 30.1);
        assertChangedAtEachStep(
            () -> rect.setCenter(new Point(45, 60)),
            () -> rect.setSize(new Point(56.5, 33.3)),
            () -> rect.moveBy(5, 3)
        );
        assertEquals(new Rectangle(19.75, 47.95, 56.5, 33.3), rect);
    }

    @RenderingTest(modes = { STROKED, FILLED, HIT_TEST })
    void degenerateRect() {
        rect = new Rectangle(10, 20, 30, 0);
    }

    @RenderingTest(modes = { STROKED, FILLED, HIT_TEST })
    void zeroRect() {
        rect = new Rectangle(20, 10, 0, 0);
    }

    @RenderingTest(modes = { STROKED, FILLED, HIT_TEST })
    void negativeSizeRect() {
        rect = new Rectangle(80, 70, -60, -50);
    }
}