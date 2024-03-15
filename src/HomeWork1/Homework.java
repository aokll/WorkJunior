package HomeWork1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {

  Streams streams;

  public Homework() {
    this.streams = new Streams();
  }

  /**
   * Реалзиовать методы, описанные ниже:
   */

  /**
   * Вывести на консоль отсортированные (по алфавиту) имена персонов
   */


  public void printNamesOrdered(List<Streams.Person> persons) {
    persons.stream().sorted((x,y) -> y.getName().compareTo(x.getName())).forEach(System.out::println);
  }

  /**
   * В каждом департаменте найти самого взрослого сотрудника.
   * Вывести на консоль мапипнг department -> personName
   * Map<Department, Person>
   */
  public Map<Streams.Department, Streams.Person> printDepartmentOldestPerson(List<Streams.Person> persons) throws UnsupportedOperationException {
    return persons.stream().collect(Collectors.toMap(Streams.Person::getDepartment, x -> x, (first, second) -> {
      if (first.getAge() > second.getAge()){
        return  first;
      }else {
        return second;
      }
    }));

  }

  /**
   * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
   */
  public List<Streams.Person> findFirstPersons(List<Streams.Person> persons) throws UnsupportedOperationException{
    List<Streams.Person> list = persons.stream().
            filter(x -> x.getAge() < 30).
            filter(x -> x.getSalary() > 50000).
            limit(10).collect(Collectors.toList());
    return list;
  }

  /**
   * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
   */
  public Optional<Streams.Department> findTopDepartment(List<Streams.Person> persons) throws UnsupportedOperationException{
    return persons.stream()
            .collect(Collectors.groupingBy(Streams.Person::getDepartment,Collectors.summingDouble(Streams.Person::getSalary))).
            entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
  }

}
