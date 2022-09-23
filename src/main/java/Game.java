import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {

        if (players.contains(findByName(playerName1)) && players.contains(findByName(playerName2))) {

            int strength1 = findByName(playerName1).getStrength();
            int strength2 = findByName(playerName2).getStrength();

            if (strength1 > strength2) {
                return 1;
            } else if (strength1 < strength2) {
                return 2;
            } else {
                return 0;
            }
        }
        else {
            throw new NotRegisteredException("Игрок не прошел регистрацию" );
        }
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> findAll() {
        return players;
    }
}