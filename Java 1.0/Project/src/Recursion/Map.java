package Recursion;

public class Map {
    public static boolean findWay(int[][] map, int i, int j) {
        //在处理数组时,先检查边界条件是一个很好的做法,它可以避免因越界而引发的异常,保证程序的稳定性

        if (i < 0 || j < 0 || i >= map.length || j >= map[i].length ||
                map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3) {
            return false;
        }

        if (map[i][j] == 4) {
            return true;
        }

        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (findWay(map, i + 1, j) || findWay(map, i, j + 1) ||
                    findWay(map, i - 1, j) || findWay(map, i, j - 1)) {
                return true;
            }

            map[i][j] = 3;
            return false;
        }

        return false;       // 其实可以不带,但是不带编译器会报错
    }
}


/**
 * 0表示可以走, 1表示障碍物, 2表示走过, 3表示不能走, 4表示终点
 */

class Maze {
    public static void main(String[] args) {

        int[][] map = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 4},
        };

        System.out.println("====当前地图====");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j< map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        Map.findWay(map, 0, 0 );
        System.out.println("\n====findWay地图====");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j< map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}