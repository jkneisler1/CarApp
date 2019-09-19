public class Pair {
    String val1;
    String val2;

    Pair() {
        this.val1 = "";
        this.val2 = "";
    }

    Pair(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public boolean check(String item) {
        boolean test = false;

        if (val1.equalsIgnoreCase(item)) {
            test = true;
        }
        else if (val2.equalsIgnoreCase(item)) {
            test = true;
        }

        return test;
    }

    public String printEach(String str1, String str2) {
        StringBuilder sbd1 = new StringBuilder();
        StringBuilder sbd2 = new StringBuilder();
        String rtnStr;

        sbd1.append("\t");
        sbd1.append(str1);
        sbd1.append(" ");
        sbd1.append(val1);
        sbd1.append(" hp\n\t");

        sbd2.append(str2);
        sbd2.append(" ");
        sbd2.append(val2);
        sbd2.append(" hp");

        rtnStr = sbd1.toString() + sbd2.toString();
        return  rtnStr;
    }

    // Getters and Setters
    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }
}