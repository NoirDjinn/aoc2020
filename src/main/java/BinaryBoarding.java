// day 5 of 2020 advent of code
// https://adventofcode.com/2020/day/5

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SeatNumber {

  long row;
  long col;

  public SeatNumber(long x, long y) {
    this.row = x;
    this.col = y;
  }

  public static long FindPlace(String place, long min, long max, char upper, char lower) {
    long mx = max;
    long mn = min;

    for (int i = 0; i < place.length(); i++) {
      if (place.charAt(i) == lower) {
        mx -= Math.round((mx - mn) / 2.0);
      } else if (place.charAt(i) == upper) {
        mn += Math.round((mx - mn) / 2.0);
      }
    }
    return mn;
  }

  public long GetID() {
    return this.row * 8 + this.col;
  }

}

public class BinaryBoarding {

  private final List<SeatNumber> seats = new ArrayList<>();

  public BinaryBoarding() {
    List<String> data = Utils.readInput(5);
    long x;
    long y;

    for (String seat : data) {
      x = SeatNumber.FindPlace(seat.substring(0, 7), 0, 127, 'B', 'F');
      y = SeatNumber.FindPlace(seat.substring(7), 0, 7, 'R', 'L');
      this.seats.add(new SeatNumber(x, y));
    }
  }

  public long GetMaxID() {
    return this.seats.stream().map(SeatNumber::GetID).max(Long::compare).get();
  }

  public long FindMissingID() {
    List<Long> IDs = this.seats.stream().map(SeatNumber::GetID).collect(Collectors.toList());

    long max = IDs.stream().max(Long::compare).get();
    long min = IDs.stream().min(Long::compare).get();

    for (long i = min; i < max; i++) {
      if (!IDs.contains(i) && IDs.contains(i + 1) && IDs.contains(i - 1)) {
        return i;
      }
    }
    return 0;
  }

}
