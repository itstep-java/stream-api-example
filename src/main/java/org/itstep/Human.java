package org.itstep;

public class Human {
    private int age;
    private Gender gender;

    public Human(int age, Gender gender) {
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
            (gender.equals(Gender.MALE) ? "Мужчина" : "Женщина")
            + ", " + age + " " + pluralizeAge(age);
    }

    private String pluralizeAge(int age) {
        if (age > 10 && age < 20) {
            return "лет";
        }

        if (age % 10 == 1) {
            return "год";
        }

        if (age % 10 > 1 && age % 10 < 5) {
            return "года";
        }

        return "лет";
    }

    @Override
    public int hashCode() {
        return age + (gender.equals(Gender.FEMALE) ? 1 : 0) * 200;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Human
            && age == ((Human) obj).getAge()
            && gender.equals(((Human) obj).getGender());
    }
}
