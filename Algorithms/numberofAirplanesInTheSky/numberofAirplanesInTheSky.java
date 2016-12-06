/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Solution {
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Flight> flightList = new ArrayList<Flight>();
        
        for (Interval airplane : airplanes) {
            flightList.add(new Flight(airplane.start, 1));
            flightList.add(new Flight(airplane.end, 0));
        }
        
        Collections.sort(flightList, Flight.flightComparator);
        int count = 0, maxNum = 0;
        
        for (Flight flight : flightList) {
            if (flight.status == 1) {
                count++;
            } else {
                count--;
            }
            
            maxNum = Math.max(maxNum, count);
        }
        
        return maxNum;
    }
}

class Flight {
    public int time;
    public int status;
    
    public Flight(int t, int s) {
        this.time = t;
        this.status = s;
    }
    
    public static Comparator<Flight> flightComparator = new Comparator<Flight>() {
        public int compare(Flight a, Flight b) {
            if (a.time == b.time) {
                return a.status - b.status; // 1 takeoff, 0 landing;
            }
            
            return a.time - b.time;
        }
    };
}