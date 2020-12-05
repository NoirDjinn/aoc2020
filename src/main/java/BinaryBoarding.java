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

  public static long GetX(String x) {
    long min = 0;
    long max = 127;
    for (int i = 0; i < x.length(); i++) {
      if (x.charAt(i) == 'F') {
        max -= Math.round((max - min) / 2.0);
      } else if (x.charAt(i) == 'B') {
        min += Math.round((max - min) / 2.0);
      }
    }
    return min;
  }

  public static long GetY(String y) {
    long min = 0;
    long max = 7;
    for (int i = 0; i < y.length(); i++) {
      if (y.charAt(i) == 'L') {
        max -= Math.round((max - min) / 2.0);
      } else if (y.charAt(i) == 'R') {
        min += Math.round((max - min) / 2.0);
      }
    }
    return min;
  }

  public long GetID() {
    return this.row * 8 + this.col;
  }

}

public class BinaryBoarding {

  private List<SeatNumber> seats = new ArrayList<>();

  public BinaryBoarding() {
    List<String> data = Utils.readInput(5);
    long x;
    long y;

    for (String seat : data) {
      x = SeatNumber.GetX(seat.substring(0, 7));
      y = SeatNumber.GetY(seat.substring(7));
      this.seats.add(new SeatNumber(x, y));
    }
  }

  public long GetMaxID() {
    if (this.seats == null) {
      return 0;
    }
    return this.seats.stream().map(SeatNumber::GetID).max(Long::compare).get();
  }

  public long FindMissingID() {
    if (this.seats == null) {
      return 0;
    }

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
