package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    private Shape triangle = new Triangle(5, 3);
    private Shape triangle1 = new Triangle(4, 2);
    private Shape circle = new Circle(5);

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Testing adding method")
    class TestsForAdding {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = circle;

            //When
            shapeCollector.addFigure(shape);

            //Then
            assertEquals(1, shapeCollector.getShapeList().size());
        }
    }

    @Nested
    @DisplayName("Testing removing method")
    class TestsForRemoving {
        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.getShapeList().add(circle);

            //When
            shapeCollector.removeFigure(circle);
            int expectedSize = 0;
            int resultSize = shapeCollector.getShapeList().size();

            //Then
            assertEquals(resultSize, expectedSize);
        }
    }

    @Nested
    @DisplayName("Testing getting method")
    class TestsForGetting {
        @DisplayName("Testing getFigure method in range")
        @Test
        void testGetFigureIfInRange() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.getShapeList().add(triangle);
            shapeCollector.getShapeList().add(triangle1);
            shapeCollector.getShapeList().add(circle);
            int n = 1;

            //When
            Shape expectedShape = triangle1;
            Shape resultShape = shapeCollector.getFigure(n);

            //Then
            assertEquals(expectedShape, resultShape);
        }

        @DisplayName("Testing getFigure method with the negative index")
        @Test
        void testGetFigureIfNegativeIndex() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            int n = -1;

            //When
            Shape resultShape = shapeCollector.getFigure(n);

            //Then
            assertNull(resultShape);
        }


        @DisplayName("Testing getFigure method index higher than range")
        @Test
        void testGetFigureIfIndexHigherTanRange() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            int n = shapeCollector.getShapeList().size() + 1;

            //When
            Shape resultShape = shapeCollector.getFigure(n);

            //Then
            assertNull(resultShape);
        }
    }

    @Nested
    @DisplayName("Testing displaying method")
    class TestsForDispaly {
        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.getShapeList().add(triangle);
            shapeCollector.getShapeList().add(triangle1);
            shapeCollector.getShapeList().add(circle);

            //When
            String expectedString = "Triangle, Triangle, Circle";
            String resultString = shapeCollector.showFigures();

            //Then
            assertEquals(expectedString, resultString);
        }
    }
}
