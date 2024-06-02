package datetimestream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		List<String> dateTimeStrings = Arrays.asList("2024-05-01T10:30:00", 
				"2024-05-03T8:05:7",
				"2024-05-02T12:45:00");

		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d'T'H:m:s");
		List<LocalDateTime> dateTimes = dateTimeStrings.stream().map(s -> LocalDateTime.parse(s, formatter)).sorted()
				.collect(Collectors.toList());

		LocalDateTime latestDateTime = dateTimes.get(dateTimes.size() - 1);
		
		
		dateTimes.stream().forEach(System.out::println);
		
		DateTimeFormatter outformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		
		System.out.println("Latest DateTime: " + latestDateTime.format(outformatter));
	}
}
