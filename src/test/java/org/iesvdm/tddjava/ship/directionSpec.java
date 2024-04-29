package org.iesvdm.tddjava.ship;

import org.testng.annotations.*;
import static org.testng.Assert.*;

@Test
public class directionSpec {

    public void whenGetFromShortNameNThenReturnDirectionN() {
        //When (Cuando)
        char shortName = 'N';

        //Do (Hacer)
        Direction direction = Direction.getFromShortName(shortName);

        //Then (Entonces)
        assertEquals(direction, Direction.NORTH);
        //verifica que la direccion es norte

    }

    public void whenGetFromShortNameWThenReturnDirectionW() {
        //When (Cuando)
        char shortName = 'W';

        //Do (Hacer)
        Direction direction = Direction.getFromShortName(shortName);

        //Then (Entonces)
        assertEquals(direction, Direction.WEST);
        //verifica que la direccion es oeste


    }

    public void whenGetFromShortNameBThenReturnNone() {
        //When (Cuando)
        char shortName = 'X';

        //Do (Hacer)
        Direction direction = Direction.getFromShortName(shortName);

        //Then (Entonces)
        assertEquals(direction, Direction.NONE);
        //verifica que la direccion es ninguna


    }

    public void givenSWhenLeftThenE() {

        //When (cuando)
        // direccion inical
        Direction direction = Direction.EAST;

         //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.EAST.turnLeft();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.NORTH);
        // verifica que al girar izquiera nueva direcioń es Norte
    }

    public void givenNWhenLeftThenW() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.WEST;

        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.WEST.turnLeft();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.SOUTH);
        // verifica que al girar izquiera nueva direcioń es sur
    }

    public void givenSWhenRightThenW() {
        //When (cuando)
        // direccion inical
        Direction direction = Direction.WEST;

        //Do (Hacer)
        // nueva direccion
        Direction Nuevadirection = Direction.WEST.turnRight();

        // Then (Entonces)

        assertEquals(Nuevadirection, Direction.NORTH);
        // verifica que al girar izquiera nueva direcioń es norte
    }

    public void givenWWhenRightThenN() {

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

}
