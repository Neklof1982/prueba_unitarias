package org.iesvdm.tddjava.ship;


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

        assertFalse(location1.equals(location2));
        // verifica que son dos diferentes
    }

    public void givenDifferentXWhenEqualsThenFalse() {
        //When (cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(11, 20), Direction.SOUTH);

        // Do Then

        assertTrue(!location1.equals(location2));
        // verifica que son dos x diferentes
    }

    public void givenDifferentYWhenEqualsThenFalse() {

        //When (Cuando)

        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 =new Location(new Point(10, 21), Direction.NORTH);

        //Do Then

        assertFalse(location1.equals(location2));
    }

    public void givenDifferentDirectionWhenEqualsThenFalse() {

        //When (Cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(10, 21), Direction.SOUTH);
        //Do Then

        assertFalse(location1.equals(location2));
    }

    public void givenSameXYDirectionWhenEqualsThenTrue() {

        //When (Cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);
        Location location2 = new Location(new Point(10, 20), Direction.NORTH);
        //Do Then
        assertTrue(location1.equals(location2));
    }

    public void whenCopyThenDifferentObject() {
        //When (Cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);

        //Do (Hacer
        Location copy = location1.copy();

        //Then (Entonces)

        assertNotSame(location1,copy);
        }

    public void whenCopyThenEquals() {
//When (Cuando)
        Location location1 = new Location(new Point(10, 20), Direction.NORTH);

        //Do (Hacer
        Location copy = location1.copy();

        //Then (Entonces)

        assertNotSame(location1,copy);
        //Verifica que no son copias iguales
    }

    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
        //When (Cuando)
        Location location1 = new Location(new Point(100, 50), Direction.EAST);

        //Do (Hacer)
        location1.forward(new Point(100, 100));

        //Then (Entonces)

        assertEquals(1, location1.getX());

    }

    public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {

        //When (Cuando)
        Location location1 = new Location(new Point(1, 50), Direction.WEST);

        //Do (Hacer)
        location1.forward(new Point(100, 100));

        //Then (Entonces)
        assertEquals(100, location1.getX());
    }

    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {

        //When (Cuando)
        Location location1 = new Location(new Point(50, 1), Direction.NORTH);

        //Do (Hacer)
        location1.forward(new Point(100, 100));

        //Then (Entonces)
        assertEquals(100, location1.getY());

    }

    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {

        //When (Cuando)
        Location location = new Location(new Point(50, 100), Direction.SOUTH);

        //Do (Hacer)
        location.forward(new Point(100, 100));

        //Then (Entonces)
        assertEquals(1, location.getY());
    }

    public void givenObstacleWhenForwardThenReturnFalse() {

    }

    public void givenObstacleWhenBackwardThenReturnFalse() {



    }

}
