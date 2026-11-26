class Solution {

    class Flight {
        int toAirport;
        int price;

        Flight(int toAirport, int price) {
            this.toAirport = toAirport;
            this.price = price;
        }
    }

    private int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Flight>> flightMap = new HashMap<>();

        for (int[] flight : flights) {
            flightMap.computeIfAbsent(flight[0], key -> new ArrayList<>())
                     .add(new Flight(flight[1], flight[2]));
        }

        memo = new int[n][k + 2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result = dfs(src, dst, k + 1, flightMap);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(
        int currentAirport, int destination, 
        int flightsRemaining, Map<Integer, List<Flight>> flightMap
    ) {

        if (currentAirport == destination) {
            return 0;
        }

        if (flightsRemaining == 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[currentAirport][flightsRemaining] != -1) {
            return memo[currentAirport][flightsRemaining];
        }

        int minCost = Integer.MAX_VALUE;

        List<Flight> possibleFlights = flightMap.getOrDefault(currentAirport, new ArrayList<>());

        for (Flight flight : possibleFlights) {

            int remainingCost = dfs(flight.toAirport, destination, flightsRemaining - 1, flightMap);

            if (remainingCost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, flight.price + remainingCost );
            }
        }

        memo[currentAirport][flightsRemaining] = minCost;

        return minCost;
    }
}