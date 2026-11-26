class Solution {

    class Flight {
        int toAirport;
        int price;

        Flight(int toAirport, int price) {
            this.toAirport = toAirport;
            this.price = price;
        }

        public int getToAirport() {
            return toAirport;
        }

        public int getPrice() {
            return price;
        }
    }
    
    private int minPrice = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Flight>> flightMap = new HashMap<>();

        for(int[] flight: flights) {

            int fromAirport = flight[0];
            int toAirport = flight[1];
            int price = flight[2];

            flightMap.computeIfAbsent(fromAirport, key -> new ArrayList<>())
                     .add(new Flight(toAirport, price));
        }
        
        dfs(src, dst, k + 1, 0, flightMap);

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    private void dfs(int currentAirport, int destination, int flightsRemaining, int currentPrice, Map<Integer, List<Flight>> flightMap
    ) {

        if (currentPrice >= minPrice) {
            return;
        }

        if (currentAirport == destination) {
            minPrice = Math.min(minPrice, currentPrice);
            return;
        }

        if (flightsRemaining == 0) {
            return;
        }

        List<Flight> possibleFlights = flightMap.getOrDefault(currentAirport, new ArrayList<>());

        for (Flight flight : possibleFlights) {

            dfs(flight.toAirport,destination,flightsRemaining - 1,currentPrice + flight.price,flightMap);
        }
    }
}
