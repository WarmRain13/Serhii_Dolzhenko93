import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    Line[] line;
    Station[][] station;

    StationIndex testStationIndex;
    RouteCalculator testCalculator;
    List<Station> testRoute;

    @Override
    protected void setUp() {

        line = new Line[3];
        station = new Station[3][3];

        testStationIndex = new StationIndex();
        testCalculator = new RouteCalculator(testStationIndex);
        testRoute = new ArrayList<>();

        for (int l = 0; l < 3; l++) {

            line[l] = new Line(l + 1, "Линия " + (l + 1));
            testStationIndex.addLine(line[l]);

            for (int s = 0; s < 3; s++) {

                station[l][s] = new Station("Станция " + (s + 1) + " на линии " + (l + 1), line[l]);
                line[l].addStation(station[l][s]);
                testStationIndex.addStation(station[l][s]);
            }
        }

        testStationIndex.addConnection(new ArrayList<>(Arrays.asList(station[0][1], station[1][0])));
        testStationIndex.addConnection(new ArrayList<>(Arrays.asList(station[1][2], station[2][1])));
    }

    public void testCalculateDuration() {


        testRoute.add(testStationIndex.getStation("Станция 1 на линии 1"));
        testRoute.add(testStationIndex.getStation("Станция 2 на линии 1"));
        testRoute.add(testStationIndex.getStation("Станция 1 на линии 2"));
        testRoute.add(testStationIndex.getStation("Станция 2 на линии 2"));
        testRoute.add(testStationIndex.getStation("Станция 3 на линии 2"));
        testRoute.add(testStationIndex.getStation("Станция 2 на линии 3"));
        testRoute.add(testStationIndex.getStation("Станция 3 на линии 3"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 17.0;

        assertEquals(expected, actual);
    }

    public void testTimeOfRouteOnTheLine() throws NullPointerException {

        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Станция 1 на линии 1"),
                testStationIndex.getStation("Станция 3 на линии 1"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * 2.5;

        assertEquals(expected, actual);
    }

    public void testTimeOfRouteWithOneConnections() throws NullPointerException {

        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Станция 1 на линии 1"),
                testStationIndex.getStation("Станция 2 на линии 2"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * 2.5 + 3.5;

        assertEquals(expected, actual);
    }

    public void testTimeOfRouteWithTwoConnections() throws NullPointerException {

        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Станция 1 на линии 1"),
                testStationIndex.getStation("Станция 2 на линии 3"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 3 * 2.5 + 2 * 3.5;

        assertEquals(expected, actual);
    }

    public void testGetShortestRouteShouldNoNull() throws NullPointerException {

        assertNotNull(testCalculator.getShortestRoute(
                testStationIndex.getStation("Станция 1 на линии 1"),
                testStationIndex.getStation("Станция 3 на линии 3")));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        Line[] line = null;
        Station[][] station = null;

        StationIndex testStationIndex = null;
        RouteCalculator testCalculator = null;
        List<Station> testRoute = null;
    }

}
