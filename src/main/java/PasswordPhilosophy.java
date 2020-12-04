// day 2 of 2020 advent of code
// https://adventofcode.com/2020/day/2

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordPolicy {

  public final long lowestNumber;
  public final long highestNumber;
  public final char character;
  public final String word;

  public PasswordPolicy(char c, long l, long h, String w) {
    this.character = c;
    this.lowestNumber = l;
    this.highestNumber = h;
    this.word = w;
  }

  public long checkPassword() {
    if (this.word == null) {
      return 0;
    }
    long charInPassCount = this.word.chars().filter(ch -> ch == this.character).count();
    return charInPassCount >= this.lowestNumber && charInPassCount <= this.highestNumber
        ? 1
        : 0;
  }

  public long validatePassword() {
    if (this.word == null) {
      return 0;
    }
    char lowerChar = word.substring((int) this.lowestNumber - 1, (int) this.lowestNumber)
        .toCharArray()[0];
    char highChar = word.substring((int) this.highestNumber - 1, (int) this.highestNumber)
        .toCharArray()[0];

    return lowerChar != highChar && (lowerChar == this.character || highChar == this.character)
        ? 1
        : 0;
  }
}

public class PasswordPhilosophy {

  public List<PasswordPolicy> data = new ArrayList<>();

  public PasswordPhilosophy() {
    List<String> policyList = Utils.readInput(2);

    List<String> policyParams;
    Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (.): (\\w*)");
    Matcher matcher;
    long l, h;
    char c;
    String w;

    for (String s : policyList) {
      policyParams = new ArrayList<>();
      matcher = pattern.matcher(s);
      while (matcher.find()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
          policyParams.add(matcher.group(i));
        }
      }
      l = Integer.parseInt(policyParams.get(0));
      h = Integer.parseInt(policyParams.get(1));
      c = policyParams.get(2).toCharArray()[0];
      w = policyParams.get(3);

      this.data.add(new PasswordPolicy(c, l, h, w));
    }
  }

  public long countCorrectPasswords() {
    return this.data == null
        ? 0
        : this.data.stream().map(PasswordPolicy::checkPassword).reduce(0L, Long::sum);
  }


  public long countValidPasswords() {
    return this.data == null
        ? 0
        : this.data.stream().map(PasswordPolicy::validatePassword).reduce(0L, Long::sum);
  }
}
