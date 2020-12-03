// day 2 of 2020 advent of code
// https://adventofcode.com/2020/day/2

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class PasswordPolicy {

  public final int lowestNumber;
  public final int highestNumber;
  public final char character;
  public final String word;

  public PasswordPolicy(char c, int l, int h, String w) {
    this.character = c;
    this.lowestNumber = l;
    this.highestNumber = h;
    this.word = w;
  }

  public int checkPassword() {
    if (this.word == null) {
      return 0;
    }
    long charInPassCount = this.word.chars().filter(ch -> ch == this.character).count();
    if (charInPassCount >= (long) this.lowestNumber
        && charInPassCount <= (long) this.highestNumber) {
      return 1;
    } else {
      return 0;
    }
  }

  public int validatePassword() {
    if (this.word == null) {
      return 0;
    }
    char lowerChar = word.substring(this.lowestNumber - 1, this.lowestNumber).toCharArray()[0];
    char highChar = word.substring(this.highestNumber - 1, this.highestNumber).toCharArray()[0];

    return lowerChar != highChar && (lowerChar == this.character || highChar == this.character)
        ? 1
        : 0;
  }
}

public class PasswordPhilosophy {

  public List<PasswordPolicy> data = new ArrayList<>();

  public PasswordPhilosophy() {
    String inp = new Scanner(PasswordPhilosophy.class.getResourceAsStream("day2_input.txt"),
        StandardCharsets.UTF_8).useDelimiter("\\A").next();
    List<String> policyList = Arrays.stream(inp.split("\n")).collect(Collectors.toList());

    List<String> policyParams;
    Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (.): (\\w*)");
    Matcher matcher;
    int l, h;
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
        : this.data.stream().map(PasswordPolicy::checkPassword).reduce(0, Integer::sum);
  }


  public long countValidPasswords() {
    return this.data == null
        ? 0
        : this.data.stream().map(PasswordPolicy::validatePassword).reduce(0, Integer::sum);
  }
}
