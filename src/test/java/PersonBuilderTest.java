import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PersonBuilderTest {
    static PersonBuilder personBuilder;
    static Person person;

    @BeforeEach
    public void beforeEach() {
        personBuilder = new PersonBuilder();
    }

    @AfterEach
    public void afterEach(){
        System.out.println(person);
        person = null;
    }

    @ParameterizedTest
    @CsvSource(value = {"Иван, Иванов, 30, Новый Уренгой"})
    public void testPersonBuilder(String name, String family, int age, String city) {
        person = personBuilder
                    .setName(name)
                    .setFamily(family)
                    .setAge(age)
                    .setAddress(city)
                    .build();
    }

    @ParameterizedTest
    @CsvSource(value = {", Иванов, 30, Новый Уренгой"})
    public void testPersonBuilderEmptyName(String name, String family, int age, String city) throws IllegalStateException{
        Assertions.assertThrows(IllegalStateException.class, () ->
                person = personBuilder
                    .setName(name)
                    .setFamily(family)
                    .setAge(age)
                    .setAddress(city)
                    .build());
    }

    @ParameterizedTest
    @CsvSource(value = {"Пётр, , 30, Владивосток"}, ignoreLeadingAndTrailingWhitespace = true)
    public void testPersonBuilderEmptyFamily(String name, String family, int age, String city) throws IllegalStateException{
        Assertions.assertThrows(IllegalStateException.class, () ->
                person = personBuilder
                        .setName(name)
                        .setFamily(family)
                        .setAge(age)
                        .setAddress(city)
                        .build());
    }

    @ParameterizedTest
    @CsvSource(value = {"Пётр, Петров, -30, Владивосток"})
    public void testPersonBuilderBrokenAge(String name, String family, int age, String city) throws IllegalArgumentException{
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                person = personBuilder
                        .setName(name)
                        .setFamily(family)
                        .setAge(age)
                        .setAddress(city)
                        .build());
    }

    @ParameterizedTest
    @CsvSource(value = {"Алёна, Буданова"})
    public void testPersonBuilderShort(String name, String family) {
        person = personBuilder
                .setName(name)
                .setFamily(family)
                .build();
    }
}
