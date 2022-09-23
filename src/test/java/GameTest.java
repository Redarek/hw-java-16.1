import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "Leonardo", 500);
    Player player2 = new Player(2, "Raphael", 550);
    Player player3 = new Player(3, "Michelangelo", 300);
    Player player4 = new Player(4, "Donatello", 250);
    Player player5 = new Player(99, "Splinter", 999);
    Player player6 = new Player(100, "Shredder", 999);

    @Test
    public void firstPlayerWinsTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 1;
        int actual = game.round("Splinter", "Raphael");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWinsTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 2;
        int actual = game.round("Michelangelo", "Raphael");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 0;
        int actual = game.round("Splinter", "Shredder");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegisteredTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Splinter", "Krang");
        });
    }

    @Test
    public void secondPlayerNotRegisteredTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Krang", "Splinter");
        });
    }

    @Test
    public void bothPlayersNotRegisteredTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Bebop", "Rocksteady");
        });
    }
}
