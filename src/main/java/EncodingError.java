import java.util.List;
import java.util.stream.Collectors;

public class EncodingError {

  private final List<Long> data;

  public EncodingError() {
    this.data = Utils.readInput(9).stream().map(Long::parseLong).collect(Collectors.toList());
  }

  public boolean IsSumOfTwo(long idealSum, List<Long> arr) {
    for (int i = 0; i < arr.size(); i++) {
      for (int j = i + 1; j < arr.size(); j++) {
        if (arr.get(i) + arr.get(j) == idealSum) {
          return true;
        }
      }
    }
    return false;
  }

  public long FindFirstNotSum() {
    for (int i = 25; i < this.data.size(); i++) {
      if (!this.IsSumOfTwo(this.data.get(i), this.data.subList(i - 25, i))) {
        return this.data.get(i);
      }
    }
    return -1;
  }

  public long FindEncryptionWeakness() {
    long target = this.FindFirstNotSum();
    int l = 0;
    int r = 1;

    while (this.data.subList(l, r + 1).stream().reduce(0L, Long::sum) != target) {
      if (this.data.subList(l, r + 1).stream().reduce(0L, Long::sum) < target) {
        r += 1;
      } else {
        l += 1;
      }
    }
    return this.data.subList(l, r + 1).stream().min(Long::compare).get() + this.data
        .subList(l, r + 1).stream().max(Long::compare).get();
  }
}
