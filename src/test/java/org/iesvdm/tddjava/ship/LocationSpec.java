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
        int initialY = location.getY();
        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.WEST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.NORTH);
        // verifica que al girar izquiera nueva direcio es este
        assertTrue(location.getY() < initialY);
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
        // verifica que al girar izquiera nueva direccion es Sur
        assertTrue((location.getY() > initialY));
        // verifica y  ha cambiado
    }

    public void givenDirectionEWhenBackwardThenXDecreases() {

    }

    public void givenDirectionWWhenBackwardThenXIncreases() {

    }

    public void whenTurnLeftThenDirectionIsSet() {

    }

    public void whenTurnRightThenDirectionIsSet() {

    }

    public void givenSameObjectsWhenEqualsThenTrue() {

    }

    public void givenDifferentObjectWhenEqualsThenFalse() {

    }

    public void givenDifferentXWhenEqualsThenFalse() {

    }

    public void givenDifferentYWhenEqualsThenFalse() {

    }

    public void givenDifferentDirectionWhenEqualsThenFalse() {

    }

    public void givenSameXYDirectionWhenEqualsThenTrue() {

    }

    public void whenCopyThenDifferentObject() {
        }

    public void whenCopyThenEquals() {

    }

    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {

    }

    public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {

    }

    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {

    }

    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {

    }

    public void givenObstacleWhenForwardThenReturnFalse() {

    }

    public void givenObstacleWhenBackwardThenReturnFalse() {

    }

}
