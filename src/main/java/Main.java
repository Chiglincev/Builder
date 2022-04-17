public class Main {

    public static void main(String[] args) {
        Person parent = new PersonBuilder()
                .setName("Антон")
                .setFamily("Кузнецов")
                .setAge(33)
                .setAddress("Москва")
                .build();

        Person child = parent.newChildBuilder()
                        .setName("Владимир")
                        .build();

        System.out.println(parent + " Имеет ребёнка: " + child);
    }

}
