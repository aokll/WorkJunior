package HomeWork1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        Homework homework = new Homework();

        List<Streams.Person> persons = new ArrayList<>();
        List<Streams.Department> departments = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            departments.add(new Streams.Department("Department #" + i));
        }
        for (int i = 0; i < 50; i++) {
            persons.add(new Streams.Person(
                    "Person #" + i,
                    ThreadLocalRandom.current().nextInt(20, 61),
                    ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }

        System.out.println("Вывести на консоль отсортированные (по алфавиту) имена персонов");
        System.out.println();
        homework.printNamesOrdered(persons);
        System.out.println();
        System.out.println("упорядочим по депортаментам для проверки результата ниже");
        System.out.println();
        persons.stream().sorted((x,y)->x.getDepartment().getName().compareTo(y.getDepartment().getName())).forEach(x-> System.out.println(x));
        System.out.println();
        System.out.println( "В каждом департаменте найти самого взрослого сотрудника. " +
                "Вывести на консоль мапипнг department -> personName Map<Department, Person> ");
        System.out.println();
        System.out.println(homework.printDepartmentOldestPerson(persons));
        System.out.println();
        System.out.println("Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000");
        System.out.println();
        homework.findFirstPersons(persons).stream().forEach(x -> System.out.println(x));
        System.out.println();
        homework.findTopDepartment(persons);
        System.out.println();
        System.out.println("Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна");
        System.out.println();
        System.out.println(homework.findTopDepartment(persons));


    }
}