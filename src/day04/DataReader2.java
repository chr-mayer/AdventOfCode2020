package day04;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader2 {
    private final String pathString = "src/day04/input.txt";
    private final FileReader fileReader = new FileReader();

    public int read() {
        List<String> lines = fileReader.read(pathString);
        List<String> lines2 = new ArrayList<>();
        lines2.add(lines.get(0));
        for (int i = 1; i < lines.size(); i++) {
            if (!lines.get(i).isEmpty()) {
                int len2 = lines2.size();
                lines2.set(len2 - 1, lines2.get(len2 - 1).concat(" ").concat(lines.get(i)));
            } else {
                lines2.add("");
            }
        }

        for (int i = 0; i < lines2.size(); i++) {
            lines2.set(i, lines2.get(i).trim());
        }

        List<List<String>> passports = new ArrayList<>();
        for (String line : lines2) {
            passports.add(List.of(line.split(" ")));

        }

        List<Passport> passportList = new ArrayList<>();
        for (List<String> passport : passports) {
            Passport pp = new Passport(null, null, null, null,
                    null, null, null, null);
            for (String entry : passport) {
                List<String> keyValue = List.of(entry.split(":"));
                switch (keyValue.get(0)) {
                    case "byr":
                        pp.setByr(keyValue.get(1));
                        break;
                    case "iyr":
                        pp.setIyr(keyValue.get(1));
                        break;
                    case "eyr":
                        pp.setEyr(keyValue.get(1));
                        break;
                    case "hgt":
                        pp.setHgt(keyValue.get(1));
                        break;
                    case "hcl":
                        pp.setHcl(keyValue.get(1));
                        break;
                    case "ecl":
                        pp.setEcl(keyValue.get(1));
                        break;
                    case "pid":
                        pp.setPid(keyValue.get(1));
                        break;
                    case "cid":
                        pp.setCid(keyValue.get(1));
                        break;
                }
            }
            passportList.add(pp);
        }

        int count = 0;
        for (Passport passport : passportList) {
            if (
                    isValidByr(passport) &&
                            isValidIyr(passport) &&
                            isValidEyr(passport) &&
                            isValidHgt(passport) &&
                            isValidHcl(passport) &&
                            isValidEcl(passport) &&
                            isValidPid(passport)
            ) {
                count++;
            }

        }


        return count;

    }


    boolean isValidByr(Passport passport) {
        if (passport.getByr() == null) {
            return false;
        }
        if (passport.getByr().length() != 4) {
            return false;
        }
        int year = 0;
        try {
            year = Integer.parseInt(passport.getByr());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return year >= 1920 && year <= 2002;
    }

    boolean isValidIyr(Passport passport) {
        if (passport.getIyr() == null) {
            return false;
        }
        if (passport.getIyr().length() != 4) {
            return false;
        }
        int year = 0;
        try {
            year = Integer.parseInt(passport.getIyr());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return year >= 2010 && year <= 2020;
    }

    boolean isValidEyr(Passport passport) {
        if (passport.getEyr() == null) {
            return false;
        }
        if (passport.getEyr().length() != 4) {
            return false;
        }
        int year = 0;
        try {
            year = Integer.parseInt(passport.getEyr());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return year >= 2020 && year <= 2030;
    }

    boolean isValidHgt(Passport passport) {
        if (passport.getHgt() == null) {
            return false;
        }
        if (!passport.getHgt().endsWith("cm") && !passport.getHgt().endsWith("in")) {
            return false;
        }
        if (passport.getHgt().endsWith("cm")) {
            int cm = Integer.parseInt(passport.getHgt().replace("cm", ""));
            if (cm < 150 || cm > 193) {
                return false;
            }
        }
        if (passport.getHgt().endsWith("in")) {
            int in = Integer.parseInt(passport.getHgt().replace("in", ""));
            return in >= 59 && in <= 76;
        }
        return true;
    }

    boolean isValidHcl(Passport passport) {
        if (passport.getHcl() == null) {
            return false;
        }
        if (passport.getHcl().length() != 7) {
            return false;
        }
        if (!passport.getHcl().startsWith("#")) {
            return false;
        }
        Pattern pattern = Pattern.compile("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
        Matcher matcher = pattern.matcher(passport.getHcl());
        return matcher.matches();
    }

    boolean isValidEcl(Passport passport) {
        if (passport.getEcl() == null) {
            return false;
        }
        List<String> validColors = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        return validColors.contains(passport.getEcl());
    }

    boolean isValidPid(Passport passport) {
        if (passport.getPid() == null) {
            return false;
        }
        if (passport.getPid().length() != 9) {
            return false;
        }


        Pattern pattern = Pattern.compile("0{0,}[0-9]{1,9}");
        Matcher matcher = pattern.matcher(passport.getPid());
        return matcher.matches();
    }


}






















































