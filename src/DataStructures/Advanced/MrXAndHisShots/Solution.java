package DataStructures.Advanced.MrXAndHisShots;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/x-and-his-shots
 */
public class Solution {
    private static boolean LOCAL_TEST = false;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Advanced/MrXAndHisShots/tests/input00"));
        }
        String line[] = sc.nextLine().split(" ");
        int numShots = Integer.parseInt(line[0]), numPlayers = Integer.parseInt(line[1]),
                shotRange1[] = new int[numShots], shotRange2[] = new int[numShots],
        playerRange1[] = new int[numPlayers], playerRange2[] = new int[numPlayers];
        for(int i = 0; i < numShots; i++) {
            line = sc.nextLine().split(" ");
            shotRange1[i] = Integer.parseInt(line[0]);
            shotRange2[i] = Integer.parseInt(line[1]);
        }
        Player[] players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++) {
            line = sc.nextLine().split(" ");
            players[i] = new Player(Integer.parseInt(line[0]), Integer.parseInt(line[1]), i);
        }
        System.out.println("" + strength(shotRange1, shotRange2, players));
    }

    private static int strength(int[] shotRange1, int[] shotRange2, Player[] players) {
        int result = 0;
        HashMap<Player, Integer> playerToStrength = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            playerToStrength.put(players[i], 0);
        }
        for(int i = 0; i < shotRange1.length; i++) {
            for(Player p : playerToStrength.keySet()) {
                if((shotRange1[i] >= p.startRange && shotRange1[i] <= p.endRange)
                        || (shotRange2[i] >= p.startRange && shotRange2[i] <= p.endRange)){
                    playerToStrength.put(p, playerToStrength.get(p) + 1);
                }
            }
        }
        for(Integer v : playerToStrength.values()) {
            result += v;
        }
        return result;
    }

    private static class Player {
        int startRange, endRange, playerNumber;
        private Player(int startRange, int endRange, int playerNumber) {
            this.startRange = startRange;
            this.endRange = endRange;
            this.playerNumber = playerNumber;
        }
        public boolean equals(Object o) {
            if(o.getClass() == this.getClass()) {
                Player oPlayer = (Player)o;
                return ((Player) o).playerNumber == this.playerNumber;
            } else {
                return false;
            }
        }
    }
}
