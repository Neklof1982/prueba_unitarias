package org.iesvdm.tddjava.asserts;


//HYA VARIAS VERSIONES DE JUNIT: 3, 4, 5

// VAMOS A ESTAR TRABAJANDO EN EN VERSION JUNIT 5 -> VERSION JUPITER
// TIENE SOPORTE PARA JAVA 08 FUNDAMENTALMENTE LAMBDAS

import org.junit.jupiter.api.Test;
import org.testng.IObjectFactory2;

import java.util.*;

//IMPORT STACIC  ¿qué hace>?
// no hace falta instaciar un objeto para poder ejecutarlo
// tiene una naturalez global
// en este caso se esta trayendo el codigo estatico de la clase Assertions
import static org.junit.jupiter.api.Assertions.*;
// manteniendo crtl ensima de asertions se abre la navegación
// tenemos que pulsar download resoruces
// tenemos dos modelos reader y flecha

/**
<p>
 Assert Descripción
 </p>
 <p>
 <b>fail</b> Falla una prueba con un mensaje y/o excepción determinados
 </p> <p>
 <b>assertTrue</b> Afirma que una condición proporcionada es verdadera
 </p> <p>
 <b>assertFalse</b> Afirma que una condición proporcionada es falsa
 </p> <p>
 <b>assertNull</b> Afirma que un objeto proporcionado es nulo
 </p> <p>
 <b>assertNotNull</b> Afirma que un objeto proporcionado no es nulo
 </p> <p>
 <b>assertEquals</b>Afirma que dos objetos suministrados son iguales
 </p> <p>
 <b>assertArrayEquals</b> Afirma que dos matrices suministradas son iguales
 </p> <p>
 <b>assertIterableEquals</b> Afirma que dos objetos iterables son profundamente iguales
 </p> <p>
 <b>assertLinesMatch</b> Afirma que dos listas de cadenas son iguales
 </p> <p>
 <b>assertNotEquals</b> Afirma que dos objetos suministrados no son iguales
 </p> <p>
 <b>assertSame</b> Afirma que dos objetos son iguales, comparados con ==
 </p> <p>
 <b>assertNotSame</b> Afirma que dos objetos son diferentes, comparados con !=
 </p>

 */



// Existe la convección de que las clases se llaman con el sufijo test
// NombreCosaBajoTesteoTest, *Test

public class AssertTest {

    //La clase de test tiene una sería de métodos que implementa pruebas parciales
    // de interes
    // es fundamental que el método esté anotado conla anotacion  @Test
    @Test
    void whenBooleanIsTrue() {

        //El assert es una afirmarción que ddebe cumplirse para que este test sea valido
        assertTrue(1 == 1);
    }
// pulsando el boton play podemos ver que funciona, si cambiamos datos dara error y te dice
    // lo que se espera y en el estado en que esta
    @Test
    void whenBooleanIsFalse() {
        boolean flag =false;
        //comprueba que sea igual al flag
        assertFalse(flag);
    }

    @Test
    void whenObjectIsNull() {
        Object nullObj = null;
        //comprueba que la referencia apunta a null
        assertNull(nullObj);

    }

    @Test
    void whenObjectIsNotNull() {
        Object obj = new Object();
        //comprueba que la referencia no apunta a null
        assertNotNull(obj);

    }


    @Test
    void shouldBeEqual() {
        final Integer ACTUAL = 9;
        final Integer EXPECTED = 9;
        //integer es una clase imutable, las dos referencia apuntan al mismo sitio
        //siempre que quiero comparar igualdad de objeto (usar siempre Equals)
        //no tipo primito (solo objetos) no puede ser con igualdad
        // ejemplo: Boolean esIgual = ACTUAL == EXPECTED; esto es erroneo
        // si fuera String  "hola" Sería igual, pero "HOLA" Y "hola", son diferentes.

        assertEquals(EXPECTED, ACTUAL);

    }

    @Test
    void shouldReferToSameObject() {
        final Object ACTUAL = 9;
        final Object EXPECTED = ACTUAL;
        // compara las dos "REFERENCIAS"
        assertSame(EXPECTED, ACTUAL);

    }

    @Test
    void shouldNotReferToSameObject() {
        final Object ACTUAL = 9;
        final Object EXPECTED = ACTUAL;

        assertNotSame(EXPECTED, new Object());

    }

    final int[] ACTUAL = new int[]{2, 5, 7};
    final int[] EXPECTED = new int[]{2, 5, 7};

    @Test
    void shouldContainSameIntegers() {
        final int[] ACTUAL = new int[]{2, 5, 7};
        final int[] EXPECTED = new int[]{2, 5, 7};
        //compara los Arrays posición a posición que sean iguales
        assertArrayEquals(EXPECTED, ACTUAL);

    }

    @Test
    void shouldContainTwoElements() {
        Object first = new Object();
        Object second = new Object();

        List list = Arrays.asList(first, second);
        //verifica que el tamaño sea de 2
        assertEquals(list.size(), 2);

    }

    @Test
    void shouldNotContainAnyElement() {

        List list = Arrays.asList();

        assertEquals(list.size(), 0);

    }

    @Test
    void shouldContainCorrectElementsInGivenOrder() {
        Object first = new Object();
        Object second = new Object();

        List list = Arrays.asList(first, second);
        //colecciones tienen que ser iterables, es decir comparar posición a posición
        assertIterableEquals(list, Arrays.asList(first, second));
    }


    @Test
    void shouldContainCorrectElementsInAnyOrder() {
        Object first = new Object();
        Object second = new Object();

        List list = Arrays.asList(first, second);

        List list2 = Arrays.asList(second, first);


        assertTrue(list.size() == list2.size());
        assertTrue(list.containsAll(list2));
        assertTrue(list2.containsAll(list));

    }

    @Test
    void shouldContainCorrectElementOnce() {

        Object first = new Object();
        Object second = new Object();

        List list = Arrays.asList(first, second);

        assertTrue(list.indexOf(first) != -1
                && list.indexOf(first) == list.lastIndexOf(first));

    }

    @Test
    void shouldNotContainIncorrectElement() {

        Object first = new Object();
        Object second = new Object();

        List list = Arrays.asList(first, second);

        assertTrue( !list.contains(new Object()) );

    }

    @Test
    void shouldContainCorrectKey() {
        final String KEY = "key";
        final String VALUE = "value";

        final Map map = new HashMap<>();
        map.put(KEY, VALUE);

        assertTrue(map.containsKey(KEY));
    }

    @Test
    void shouldNotContainCorrectKey() {
        final String INCORRECT_KEY = "incorrect_key";
        final String KEY = "key";
        final String VALUE = "value";


        final Map map = new HashMap<>();
        map.put(KEY, VALUE);

        assertFalse(map.containsKey(INCORRECT_KEY));
    }

    @Test
    void shouldContainGivenEntry() {

        final String INCORRECT_KEY = "incorrect_key";
        final String KEY = "key";
        final String VALUE = "value";

        final Map<String, String> map = new HashMap<>();
        map.put(KEY, VALUE);

        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>(KEY, VALUE);
        assertTrue(map.entrySet().contains(entry));

    }

    @Test
    void shouldNotContainGivenEntry() {

        final String INCORRECT_KEY = "incorrect_key";
        final String KEY = "key";
        final String VALUE = "value";

        final Map<String, String> map = new HashMap<>();
        map.put(KEY, VALUE);

        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>(INCORRECT_KEY, VALUE);
        assertFalse(map.entrySet().contains(entry));

    }

}
