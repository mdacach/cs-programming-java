public class Clock {
    private int hours;
    private int minutes;

    // Adjusts for minutes and hours overflow.
    private void adjustOverflow() {
        if (this.minutes >= 60) {
            int diffMinutes = this.minutes - 60;
            this.minutes = diffMinutes;
            this.hours++;
        }
        if (this.hours >= 24) {
            this.hours = this.hours % 24;
        }
    }

    // Validates time (throws an exception if time is invalid).
    private void validateTime() {
        if (this.hours < 0 || this.hours > 23)
            throw new IllegalArgumentException("hours must be between 0 and 23");
        if (this.minutes < 0 || this.minutes > 59)
            throw new IllegalArgumentException("minutes must be between 0 and 59");
    }

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        this.hours = h;
        this.minutes = m;
        validateTime();
    }

    // Creates a clock whose initial time is specified as a string, using the format
    // HH:MM.
    public Clock(String s) {
        if (s.length() != 5)
            throw new IllegalArgumentException("string format must be HH:MM");
        if (!s.contains(":"))
            throw new IllegalArgumentException("string format must be HH:MM");
        this.hours = Integer.parseInt(s.substring(0, 2));
        this.minutes = Integer.parseInt(s.substring(3, 5));
        validateTime();

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hoursString;
        if (this.hours < 10)
            hoursString = "0" + Integer.toString(this.hours);
        else
            hoursString = Integer.toString(this.hours);
        String minutesString;
        if (this.minutes < 10)
            minutesString = "0" + Integer.toString(this.minutes);
        else
            minutesString = Integer.toString(this.minutes);

        return hoursString + ":" + minutesString;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) {
            return true;
        } else if (this.hours == that.hours) {
            if (this.minutes < that.minutes)
                return true;
            else
                return false;
        } else
            return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.minutes++;
        adjustOverflow();
    }

    // Adds delta minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("delta must be non-negative");

        int hoursToAdd = (delta / 60) % 24;
        int minutesToAdd = delta % 60;
        this.minutes += minutesToAdd;
        adjustOverflow();
        this.hours += hoursToAdd;
        adjustOverflow();
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock1 = new Clock(12, 0);
        Clock clock2 = new Clock("11:01");
        StdOut.println(clock1);
        StdOut.println(clock2);
        StdOut.println("clock 1 earlier than clock 2  " + clock1.isEarlierThan(clock2));
        StdOut.println("clock 2 earlier than clock 1  " + clock2.isEarlierThan(clock1));

        clock1.tic();
        StdOut.println(clock1);
        clock1.toc(60);
        StdOut.println(clock1);

        Clock clock3 = new Clock("23:59");
        clock3.tic();
        StdOut.println(clock3);
        clock3.toc(59);
        StdOut.println(clock3);
        clock3.toc(157);
        StdOut.println(clock3);
    }

}
