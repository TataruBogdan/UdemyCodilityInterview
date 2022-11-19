import java.util.Arrays;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {

        System.out.println(new NumberOfDiscIntersections().solution(new int[] {1, 5, 2, 1, 4, 0}));

    }

    public  int solution(int A[]) {

        int len = A.length;
        // create an array called discHistory which will contain our disc logs
        // we allocate enough space for this to contain a start and an end for each disc
        DiscLog[] discHistory = new DiscLog[len * 2];

        // This integer will be used as a pointer to our disc history so we can populate it
        int j = 0;

        // We start a loop
        for (int i = 0; i < len; i++) {
            // we need to assign our two events of each disc, the start and the end.
            // the first disc log that we create we assign it at position j.
            // the first log that we add to this history is the one indicating the start of the disc.
            // This is at position center minus radius. - i is our center
            discHistory[j++] = new DiscLog(i - (long) A[i], 1);
            discHistory[j++] = new DiscLog(i + (long) A[i], -1);
        }

        // we just need to sort this disc event log.
        Arrays.sort(discHistory);

        int intersection = 0; // will contain our results.
        int activeIntersection = 0; // cumulative variable of our event log.

        for (DiscLog log: discHistory) {
            // we modify the active intersection variable by simply adding to it the start and end variable of that log.
            // this variable represents the chart
            activeIntersection += log.startEnd;
            /* update the intersections variable.
            * We only update it if our log is indicating that there is a start of a disc. */
            if (log.startEnd > 0) {
                // we update the intersections by adding the active intersections - 1
                // because it's a pair it will always have to be minus one.
                intersection += activeIntersection - 1;
            }
            if (intersection > 10000000) {
                return -1;
            }
        }
        return intersection;
    }

    class DiscLog implements Comparable<DiscLog>{

        final long x;
        final int startEnd;

        public DiscLog(long x, int startEnd) {
            this.x = x;
            this.startEnd = startEnd;
        }

        @Override
        public int compareTo(DiscLog b) {
            return this.x != b.x ? Long.compare(this.x, b.x) : Integer.compare(b.startEnd, this.startEnd);
        }
    }






}
