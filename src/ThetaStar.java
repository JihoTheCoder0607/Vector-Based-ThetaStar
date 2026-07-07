import java.awt.*;

import static java.lang.Math.abs;

public class ThetaStar extends AStar {
    public ThetaStar(char[][] grid, Point start, Point goal) {
        super(grid, start, goal);
    }
    private boolean lineOfSight(Node node1, Node node2) {
        int x1 = node1.position.x;
        int y1 = node1.position.y;
        int x2 = node2.position.x;
        int y2 = node2.position.y;

        int dx = abs(x2 - x1);
        int dy = abs(y2 - y1);

        int sx = (x1 < x2) ? (1) : (-1);
        int sy = (y1 < y2) ? (1) : (-1);

        int err = dx - dy;

        while (true) {
            if (grid[x1][y1] == '#') {
                return false;
            }
            if (x1 == x2 && y1 == y2) {
                return true;
            }

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }

    }

}
