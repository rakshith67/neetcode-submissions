class CountSquares {

    Map<List<Integer>, Integer> pointsCount;
    List<List<Integer>> points;

    public CountSquares() {
        pointsCount = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] p) {
        List<Integer> point = Arrays.asList(p[0], p[1]);
        pointsCount.put(point, pointsCount.getOrDefault(point, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] p) {
        int result = 0;
        int px = p[0];
        int py = p[1];
        for (List<Integer> point: points) {
            int x = point.get(0), y = point.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            // System.out.println(pointsCount.getOrDefault(Arrays.asList(px, y), 0));
            // System.out.println(pointsCount.getOrDefault(Arrays.asList(py, x), 0));
            result += pointsCount.getOrDefault(Arrays.asList(px, y), 0) * pointsCount.getOrDefault(Arrays.asList(x, py), 0);
        }
        return result;
    }
}

private class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Point p = (Point) o;
        System.out.println("reached");
        return x == p.x && y == p.y;
    }
}
