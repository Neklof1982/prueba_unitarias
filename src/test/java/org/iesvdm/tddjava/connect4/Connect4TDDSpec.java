package org.iesvdm.tddjava.connect4;


import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class Connect4TDDSpec {

    private Connect4TDD tested;

    private OutputStream output;

    @BeforeEach
    public void beforeEachTest() {
        output = new ByteArrayOutputStream();

        //Se instancia el juego modificado para acceder a la salida de consola
        tested = new Connect4TDD(new PrintStream(output));
    }

    /*
     * The board is composed by 7 horizontal and 6 vertical empty positions
     */

    @Test
    public void whenTheGameStartsTheBoardIsEmpty() {

       assertThat(tested.getNumberOfDiscs()).isEqualTo(0);

    }

    /*
     * Players introduce discs on the top of the columns.
     * Introduced disc drops down the board if the column is empty.
     * Future discs introduced in the same column will stack over previous ones
     */

    @Test
    public void whenDiscOutsideBoardThenRuntimeException() {

        assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Invalid column");
        });
        // esto no es lo correcto, comentado en clase

        assertThatThrownBy(() -> tested.putDiscInColumn(8))
                .isInstanceOf(RuntimeException.class).hasMessageContaining("Invalid column 8");

        // esto si es visto en clase

        assertThatThrownBy(() -> {
            for (int i = 0; i < 8; i++) {
                tested.putDiscInColumn(3);
            }
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("No more room in column 3");

    }
    @Test
    public void whenFirstDiscInsertedInColumnThenPositionIsZero() {

        for (int i = 0; i < 7; i++) {

            assertThat(tested.putDiscInColumn(i)).isEqualTo(0);
        }
       //assertThat(tested.putDiscInColumn(0)).isEqualTo(0);


    }

    @Test
    public void whenSecondDiscInsertedInColumnThenPositionIsOne() {

        for (int i = 0; i < 7; i++) {

            assertThat(tested.putDiscInColumn(i)).isEqualTo(0);
        }
    }

    @Test
    public void whenDiscInsertedThenNumberOfDiscsIncreases() {

    //assertThat(tested.getNumberOfDiscs()).isEqualTo(1);

        int discosIniciales=0;
        tested.putDiscInColumn(3);
        assertThat(tested.getNumberOfDiscs()).isEqualTo(discosIniciales+1);

    }

    @Test
    public void whenNoMoreRoomInColumnThenRuntimeException() {

    assertThat(tested.putDiscInColumn(0)).isEqualTo(0);

    }

    /*
     * It is a two-person game so there is one colour for each player.
     * One player uses red ('R'), the other one uses green ('G').
     * Players alternate turns, inserting one disc every time
     */

    @Test
    public void whenFirstPlayerPlaysThenDiscColorIsRed() {

        assertThat(tested.getCurrentPlayer()).isEqualTo("R");
    }

    @Test
    public void whenSecondPlayerPlaysThenDiscColorIsGreen() {

        assertThat(tested.getCurrentPlayer()).doesNotContain("G");
    }

    /*
     * We want feedback when either, event or error occur within the game.
     * The output shows the status of the board on every move
     */

    @Test
    public void whenAskedForCurrentPlayerTheOutputNotice() {

    assertThat(tested.getCurrentPlayer()).isEqualTo("R");

    }

    @Test
    public void whenADiscIsIntroducedTheBoardIsPrinted() {

        assertThat(tested.putDiscInColumn(0)).isEqualTo(0);
    }
    /*
     * When no more discs can be inserted, the game finishes and it is considered a draw
     */

    @Test
    public void whenTheGameStartsItIsNotFinished() {
        assertThat(tested.getWinner()).doesNotContain("Win");
    }

    @Test
    public void whenNoDiscCanBeIntroducedTheGamesIsFinished() {

        //assertThat(tested.isFinished());
    }

    /*
     * If a player inserts a disc and connects more than 3 discs of his colour
     * in a straight vertical line then that player wins
     */

    @Test
    public void when4VerticalDiscsAreConnectedThenThatPlayerWins() {

    }

    /*
     * If a player inserts a disc and connects more than 3 discs of his colour
     * in a straight horizontal line then that player wins
     */

    @Test
    public void when4HorizontalDiscsAreConnectedThenThatPlayerWins() {

    }

    /*
     * If a player inserts a disc and connects more than 3 discs of his colour
     * in a straight diagonal line then that player wins
     */

    @Test
    public void when4Diagonal1DiscsAreConnectedThenThatPlayerWins() {

    }

    @Test
    public void when4Diagonal2DiscsAreConnectedThenThatPlayerWins() {

    }
}
