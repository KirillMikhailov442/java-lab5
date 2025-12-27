import java.util.*;
import java.util.stream.Collectors;

public class PolylineBuilder {
    public static Polyline buildPolyline(List<Point> points) {
        List<Point> result = points.stream()
                .distinct()
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .distinct()
                .sorted(Comparator.comparingDouble(Point::getX))
                .collect(Collectors.toList());

        return new Polyline(result);
    }

}
