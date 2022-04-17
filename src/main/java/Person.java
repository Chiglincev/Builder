public class Person {
    protected final String name;
    protected final String family;
    protected int age = -1;
    protected String address;

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Person(String name, String family, int age) {
        this.name = name;
        this.family = family;
        this.age = age;
    }

    public Person(String name, String family, int age, String address) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.address = address;
    }


    public void happyBirthday() {
        this.age = age++;
    }

    public boolean hasAge() {
        return age == -1 ? false : true;
    }

    public boolean hasAddress() {
        return address == null ? false : true;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = hasAge() == true ? this.age : age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setFamily(this.family)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return String.format("%s %s. Лет: %s, город: %s.", name, family,
                hasAge() == true ? age : "нет данных", hasAddress() == true ? address : "нет данных");
    }
}
