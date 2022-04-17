public class PersonBuilder {

    private String name;
    private String family;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setFamily(String family) {
        this.family = family;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age <0) {
            throw new IllegalArgumentException("Возраст не должен быть отрицательным.");
        } else {
            this.age = age;
            return this;
        }
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.family == null) {
            throw new IllegalStateException("Нет ФИО.");
        } else {
            return new Person(this.name, this.family, this.age, this.address);
        }
    }
}
