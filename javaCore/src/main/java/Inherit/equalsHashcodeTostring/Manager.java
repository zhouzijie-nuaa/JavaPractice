package Inherit.equalsHashcodeTostring;

/**
 * author: zijiezhou
 * Date:   2020/10/5 20:27
 * Description:
 */
public class Manager extends Employee{
    private double bounes;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bounes = 0;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bounes;
    }

    public void setBounes(double bounes) {
        this.bounes = bounes;
    }

    @Override
    public boolean equals(Object obj) {
        if( !super.equals(obj)){
            return false;
        }
        Manager other = (Manager) obj;
        return bounes == other.bounes;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * Double.hashCode(bounes);
    }

    @Override
    public String toString() {
        return super.toString() + "[ bonus = " + bounes + " ]";
    }
}
