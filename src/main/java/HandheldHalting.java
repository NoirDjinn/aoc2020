import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HandheldCommand {

  public String command;
  public int argument;

  public HandheldCommand(String c, int a) {
    this.command = c;
    this.argument = a;
  }

}


public class HandheldHalting {

  List<HandheldCommand> data = new ArrayList<>();

  public HandheldHalting() {
    List<String> inp = Utils.readInput(8);
    List<String> parsed;
    String c;
    int a;

    for (String line : inp) {
      parsed = Arrays.asList(line.split(" "));
      c = parsed.get(0).trim();
      a = Integer.parseInt(parsed.get(1).trim());
      this.data.add(new HandheldCommand(c, a));
    }
  }

  public long process(List<HandheldCommand> inp) {
    long accumulator = 0;
    Set<Integer> seen = new HashSet<>();
    int i = 0;

    while (i >= 0 && i < inp.size()) {
      if (seen.contains(i)) {
        return accumulator;
      }

      seen.add(i);

      if ("nop".equals(inp.get(i).command)) {
        i++;
      } else if ("jmp".equals(inp.get(i).command)) {
        i += inp.get(i).argument;
      } else {
        accumulator += inp.get(i).argument;
        i++;
      }
    }

    return accumulator;
  }

  public boolean isNormallyProcessed(List<HandheldCommand> inp) {
    Set<Integer> seen = new HashSet<>();
    int i = 0;

    while (i >= 0 && i < inp.size()) {
      if (seen.contains(i)) {
        return false;
      }

      seen.add(i);

      if ("nop".equals(inp.get(i).command) || "acc".equals(inp.get(i).command)) {
        i++;
      } else if ("jmp".equals(inp.get(i).command)) {
        i += inp.get(i).argument;
      }
    }
    return true;
  }

  public long part2() {
    List<HandheldCommand> hh = new ArrayList<>(this.data);

    for (int i = 0; i < hh.size(); i++) {
      if ("jmp".equals(hh.get(i).command)) {
        hh.get(i).command = "nop";
        if (this.isNormallyProcessed(hh)) {
          return this.process(hh);
        } else {
          hh.get(i).command = "jmp";
        }
      }

      if ("nop".equals(hh.get(i).command)) {
        hh.get(i).command = "jmp";
        if (this.isNormallyProcessed(hh)) {
          return this.process(hh);
        } else {
          hh.get(i).command = "nop";
        }
      }
    }
    return 0;
  }

  public long part1() {
    return this.process(this.data);
  }
}
