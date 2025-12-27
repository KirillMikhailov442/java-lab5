import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}