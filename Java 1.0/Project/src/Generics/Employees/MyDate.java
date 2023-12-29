package Generics.Employees;


class MyDate{

    private final int year;
    private final int month;
    private final int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    public int compareTo(MyDate obj) {
        int yearSub = this.year - obj.year;
        if (yearSub != 0) {
            return yearSub;
        }

        int MonthSub = this.month - obj.month;
        if (MonthSub != 0) {
            return yearSub;
        }

        // 如果year和day都相等, 就直接返回
        return this.day - obj.day;
    }
}
