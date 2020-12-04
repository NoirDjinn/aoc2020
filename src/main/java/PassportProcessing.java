// day 4 of 2020 advent of code
// https://adventofcode.com/2020/day/4

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PassportProcessing {

  public List<String> passports = new ArrayList<>();
  private static final String[] REQUIRED = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
  private static final List<String> EYECOLORS = new ArrayList<>(
      List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

  private static final String hclRegex = "^#[a-f0-9]$";
  private static final String pidRegex = "^(0[0-9]{9}|[0-9])$";

  public PassportProcessing() {
    List<String> data = Utils.readInput(4);
    StringBuilder currentPassport = new StringBuilder();

    for (String line : data) {
      if (line.trim().length() != 0) {
        currentPassport.append(line).append(" ");
      } else {
        this.passports.add(currentPassport.toString().replace("\n", "").trim());
        currentPassport.setLength(0);
      }
    }
    if (!"".equals(currentPassport.toString())) {
      this.passports.add(currentPassport.toString().replace("\n", "").trim());
    }
  }

  public Map<String, String> BreakPassportIntoMap(String passport) {
    if (passport == null) {
      return null;
    }

    String[] parts = passport.split(" ");
    Map<String, String> data = new HashMap<>();
    for (String bit : parts) {
      if (!bit.contains(":")) {
        continue;
      }
      data.put(bit.substring(0, bit.indexOf(":")), bit.substring(bit.indexOf(":") + 1));
    }
    return data;
  }

  long ValidatePassport(String pass) {
    Map<String, String> data = BreakPassportIntoMap(pass);
    if (data == null) {
      return 0;
    }
    for (String req : REQUIRED) {
      if (!data.containsKey(req)) {
        return 0;
      }
    }
    return 1;
  }

  long ValidateDataInPassport(String pass) {
    if (ValidatePassport(pass) == 0) {
      return 0;
    }

    Map<String, String> data = BreakPassportIntoMap(pass);
    int byr = Utils.parseInt(data.get("byr"), -1);
    int iyr = Utils.parseInt(data.get("iyr"), -1);
    int eyr = Utils.parseInt(data.get("eyr"), -1);

    if (byr < 1920 || byr > 2002) {
      return 0;
    }

    if (iyr < 2010 || iyr > 2020) {
      return 0;
    }

    if (eyr < 2020 || eyr > 2030) {
      return 0;
    }

    if (!EYECOLORS.contains(data.get("ecl"))) {
      return 0;
    }

    if (data.get("hcl").length() != 7 && !Pattern.matches(hclRegex, data.get("hcl"))) {
      return 0;
    }

    if (data.get("pid").length() != 9 && !Pattern.matches(pidRegex, data.get("pid"))) {
      return 0;
    }

    boolean heightInInches = data.get("hgt").contains("in");
    if (!heightInInches && !data.get("hgt").contains("cm")) {
      return 0;
    }

    int hgt = Utils.parseInt(data.get("hgt").substring(0,
        heightInInches ? data.get("hgt").indexOf("in") : data.get("hgt").indexOf("cm")), -1);

    if (heightInInches && (hgt < 59 || hgt > 76)) {
      return 0;
    }

    if (!heightInInches && (hgt < 150 || hgt > 193)) {
      return 0;
    }

    return 1;
  }

  public long CountValidPassports() {
    long res = 0;
    for (String passport : this.passports) {
      res += ValidatePassport(passport);
    }
    return res;
  }

  public long CountValidPassportData() {
    long res = 0;
    for (String passport : this.passports) {
      res += ValidateDataInPassport(passport);
    }
    return res;
  }
}
