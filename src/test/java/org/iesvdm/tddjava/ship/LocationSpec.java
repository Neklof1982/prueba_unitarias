package org.iesvdm.tddjava.ship;

import jdk.javadoc.doclet.Taglet;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

@Test
public class LocationSpec {

    private final int x = 12;
    private final int y = 32;
    private final Direction direction = Direction.NORTH;
    private Point max;
    private Location location;
    private List<Point> obstacles;

    @BeforeMethod
    public void beforeTest() {
        max = new Point(50, 50);
        location = new Location(new Point(x, y), direction);
        obstacles = new ArrayList<Point>();
    }

    public void whenInstantiatedThenXIsStored() {

        assertEquals(x, location.getX());
        assertTrue(obstacles.isEmpty());
        assertTrue(location.getDirection().describeConstable().isPresent());

    }

    public void whenInstantiatedThenYIsStored() {
        assertEquals(y, location.getY());
        assertTrue(obstacles.isEmpty());
        assertTrue(location.getDirection().describeConstable().isPresent());

    }

    public void whenInstantiatedThenDirectionIsStored() {

        //When (cuando)
        // direccion inical
        Direction direction = Direction.NORTH;

        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.NORTH.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.EAST);
        // verifica que al girar izquiera nueva direcioń es este

    }

    public void givenDirectionNWhenForwardThenYDecreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.WEST;
        int initialY = location.getY() -1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.WEST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.NORTH);
        // verifica que al girar izquiera nueva direcio es este
        assertTrue(location.getY()> initialY);
    }

    public void givenDirectionSWhenForwardThenYIncreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.EAST;
        int initialY = location.getY()+1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.EAST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.SOUTH);
        // verifica que al girar izquiera nueva direccion es Sur
        assertTrue((location.getY() < initialY));
        // verifica y  ha cambiado
    }

    public void givenDirectionEWhenForwardThenXIncreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.WEST;
        int initialX = location.getX() + 1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.WEST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.NORTH);
        // verifica que al girar izquiera nueva direccion es norte
        assertTrue(location.getX() < initialX);
        // verifica x  ha cambiado
    }

    public void givenDirectionWWhenForwardThenXDecreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.NORTH;
        int initialX = location.getX() - 1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.NORTH.turnLeft();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.WEST);
        // verifica que al girar izquiera nueva direccion es oeste
        assertTrue(location.getX() > initialX);
        // verifica x  ha cambiado
    }

    public void givenDirectionNWhenBackwardThenYIncreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.WEST;
        int initialY = location.getY()+1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.WEST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.NORTH);
        // verifica que al girar izquiera nueva direccion es Sur
        assertTrue((location.getY() < initialY));
        // verifica y  ha cambiado
    }

    public void givenDirectionSWhenBackwardThenYDecreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.EAST;
        int initialY = location.getY()-1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.EAST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.SOUTH);
        // verifica que al girar izquiera nueva direccion es sur
        assertTrue((location.getY() > initialY));
        // verifica y  ha cambiado
    }

    public void givenDirectionEWhenBackwardThenXDecreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.NORTH;
        int initialX = location.getX() - 1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.NORTH.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.EAST);
        // verifica que al girar izquiera nueva direccion es este
        assertTrue(location.getX() > initialX);
        // verifica x  ha cambiado
    }

    public void givenDirectionWWhenBackwardThenXIncreases() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.SOUTH;
        int initialX = location.getX() + 1;
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.SOUTH.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.WEST);
        // verifica que al girar izquiera nueva direccion es oeste
        assertTrue(location.getX() < initialX);
        // verifica x  ha cambiado
    }

    public void whenTurnLeftThenDirectionIsSet() {
        //When (cuando)
        // direccion inical
        Direction direction =Direction.SOUTH;

        //Do (Hacer)
        direction = direction.turnLeft();

        // Then (Entonces)
        assertEquals(direction, Direction.EAST);
        // verifica que al girar izquiera nueva direccion es este
    }

    public void whenTurnRightThenDirectionIsSet() {
        //When (cuando)
        // direccion inical
        Direction direction =Direction.SOUTH;

        //Do (Hacer)
        direction = direction.turnRight();

        // Then (Entonces)
        assertEquals(direction, Direction.WEST);
        // verifica que al girar izquiera nueva direccion es Oeste
    }

    public void givenSameObjectsWhenEqualsThenTrue() {
        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(10, 20), Direction.NORTH);

        // Do Then

        assertTrue(location1.equals(location2));
        // verifica que son dos iguales
    }

    public void givenDifferentObjectWhenEqualsThenFalse() {
      //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(30, 40), Direction.SOUTH);

        // Do Then

        assertTrue(!location1.equals(location2));
        // verifica que son dos diferentes
    }

    public void givenDifferentXWhenEqualsThenFalse() {
        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(30, 40), Direction.SOUTH);

        // Do Then

        assertTrue(!location1.equals(location2));
        // verifica que son dos x diferentes
    }

    public void givenDifferentYWhenEqualsThenFalse() {

        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(30, 40), Direction.SOUTH);

        // Do Then

        assertTrue(!location1.equals(location2));
        // verifica que son dos x diferentes

    }

    public void givenDifferentDirectionWhenEqualsThenFalse() {

        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(30, 40), Direction.SOUTH);

        // Do Then

        assertTrue(!location1.equals(location2));
        // verifica que son dos x diferentes
    }

    public void givenSameXYDirectionWhenEqualsThenTrue() {
        //When (cuando)
        Location location1 = new Location(new Point(10, 30), Direction.NORTH);
        Location location2 = new Location(new Point(10, 30), Direction.NORTH);

        // Do Then

        assertTrue(location1.equals(location2));
        // verifica que son dos x diferentes
    }

    public void whenCopyThenDifferentObject() {

        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(10, 20), Direction.NORTH);
        // Do Then
        assertTrue(location1.equals(location2));

        }

    public void whenCopyThenEquals() {

        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(10, 20), Direction.NORTH);

        // Do Then
        assertTrue(location1.equals(location2));

    }

    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {

        //When (cuando)
        Direction direction = Direction.EAST;
        int initialX = location.getX() + 1;

        //Do (Hacer)
        Direction Nuevadirection = Direction.EAST.turnRight();

        // Then (Entonces)
        assertEquals(Nuevadirection, Direction.SOUTH);
        assertTrue(location.getX() < initialX);

    }

    public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {

        //When (cuando)
        Direction direction = Direction.NORTH;
        int initialX = location.getX() + 1;

        //Do (Hacer)
        Direction Nuevadirection = Direction.NORTH.turnLeft();

        // Then (Entonces)
        assertEquals(Nuevadirection, Direction.WEST);
        assertTrue(location.getX() < initialX);


    }

    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {

        //When (cuando)
        Direction direction = Direction.WEST;
        int initialY = location.getY() + 1;

        //Do (Hacer)
        Direction Nuevadirection = Direction.WEST.turnRight();

        //Then (Entonces)
        assertEquals(Nuevadirection, Direction.NORTH);
        assertTrue(location.getY() < initialY);

    }

    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {

        //When (cuando)
        Direction direction = Direction.SOUTH;
        int initialY = location.getY() + 1;

        //Do (Hacer)
        Direction Nuevadirection = Direction.SOUTH.turnLeft();

        //Then (Entonces)
        assertEquals(Nuevadirection, Direction.EAST);
        assertTrue(location.getY() < initialY);


    }

    public void givenObstacleWhenForwardThenReturnFalse() {

        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        location1.forward();
        assertFalse(location1.equals(obstacles));

    }

    public void givenObstacleWhenBackwardThenReturnFalse() {

        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        location1.backward();
        assertFalse(location1.equals(obstacles));

    }
}
