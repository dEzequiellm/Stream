import java.util.*;

public class OptionalStream {
    public static void main(String[] args) {
        // Crear una lista de personas con edad opcional
        List<Person> people = Arrays.asList(
                new Person("Alice", Optional.of(25)),
                new Person("Bob", Optional.empty()),
                new Person("Charlie", Optional.of(30)),
                new Person("David", Optional.of(22))
        );

        // Filtrar personas con edad presente y mostrar sus nombres y edades
        people.stream()
                .filter(person -> person.getAge().isPresent())
                .forEach(person -> System.out.println("Nombre: " + person.getName() + ", Edad: " + person.getAge().get()));

        // Obtener la edad promedio de las personas que tienen edad presente
        double edadPromedio = people.stream()
                .filter(person -> person.getAge().isPresent())
                .mapToInt(person -> person.getAge().orElse(0)) // Se usa orElse para manejar el caso de Optional.empty()
                .average()
                .orElse(0);

        System.out.println("Edad promedio de personas con edad presente: " + edadPromedio);
    }
}

class Person {
    private String name;
    private Optional<Integer> age;

    public Person(String name, Optional<Integer> age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Optional<Integer> getAge() {
        return age;
    }
}

