package stream.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Employee> empList = getEmpList();

		System.out.println("\n We will filter the employees list with gender as Female");
		empList.stream().filter(e -> e.getGender().equals("Female")).forEach(e -> System.out.println(e));

		System.out.println("\n We will filter the employees list with newJoiner as True");
		empList.stream().filter(e -> e.getNewJoiner().equals("True")).forEach(e -> System.out.println(e));

		System.out.println("\n We will sort the employee list by rating asc. ");
		empList.stream().sorted(Comparator.comparing(Employee::getRating)).forEach(e -> System.out.println(e));

		System.out.println("\n We will sort the employee list by rating desc. ");
		empList.stream().sorted(Comparator.comparing(Employee::getRating).reversed())
				.forEach(e -> System.out.println(e));

		System.out.println("\n We will sort the employee list by both rating and salary ");
		empList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.sorted(Comparator.comparing(Employee::getRating)).forEach(e -> System.out.println(e));

		System.out.println("\n We will see all employees with salary more than 1000 ");
		boolean isSalary = empList.stream().allMatch(e -> e.getSalary() > 1000);
		System.out.println(isSalary);

		System.out.println("\n We will retrieve employee with max salary ");
		empList.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

		System.out.println("\n We will retrieve employee with max rating ");
		empList.stream().max(Comparator.comparing(Employee::getRating)).ifPresent(System.out::println);

		System.out.println("\n We will retrieve employee with min salary ");
		empList.stream().min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

		System.out.println("\n We will retrieve employee with min rating ");
		empList.stream().min(Comparator.comparing(Employee::getRating)).ifPresent(System.out::println);

		
		System.out.println("\n We will group all our employees by Gender ");
		Map<String, List<Employee>> employeesBygender = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender));
		
		
		employeesBygender.forEach(((g, e) -> {
			System.out.println(g);
			e.forEach(System.out::println);
		}));

	}

	public static List<Employee> getEmpList() {
		return Arrays.asList(
				new Employee("59-385-1088", "Zacharias", "Schwerin", "zchwerin@gmail.com", "Male", "True", 101146, 0),
				new Employee("73-274-6476", "Kyle", "Frudd", "kfrudd1@ovh.net", "Male", "FALSE", 29310, 2),
				new Employee("85-939-9584", "Axe", "Gumb", "agumb2@twitter.com", "Female", "FALSE", 62291, 4),
				new Employee("08-180-8292", "Robinet", "Batterham", "rbatterham3@last.fm", "Male", "FALSE", 142439, 4),
				new Employee("21-825-2623", "Ulick", "Burrel", "uburrel4@google.ru", "Male", "FALSE", 128764, 5),
				new Employee("66-708-5539", "Tailor", "Ridding", "Ridding", "Female", "FALSE", 152924, 4),
				new Employee("81-697-2363", "Joete", "Braybrooke", "jbraybrooke6@prnewswire.com", "Male", "TRUE",
						128907, 0),
				new Employee("63-019-1110", "Elroy", "Baverstock", "ebaverstock7@ehow.com", "Male", "TRUE", 2510, 0));
	}

}
