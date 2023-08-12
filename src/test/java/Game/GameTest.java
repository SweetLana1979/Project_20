package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void  testWhenFirstPlayerWins() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Петя", "Вася");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  testWhenSecondPlayerWins() {
        Player vasya = new Player(1, "Вася", 120);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Петя", "Вася");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  testWhenNoPlayerWins() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Петя", "Вася");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  testWithFirstPlayerNotExisted() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Вася")
        );
    }

        @Test
        public void  testWithSecondPlayerNotExisted() {
            Player vasya = new Player(1, "Вася", 100);
            Player petya = new Player(2, "Петя", 120);
            Game game = new Game();

            game.register(vasya);
            game.register(petya);
            Assertions.assertThrows(NotRegisteredException.class,
                    () -> game.round("Петя", "Миша")
            );
        }
    @Test
    public void  testWithBothPlayersNotExisted() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Ваня")
        );


    }
}
