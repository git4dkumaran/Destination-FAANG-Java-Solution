package stream.movie;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieManager {

	private class Movie {
		public Set<Actor> getActors() {
			return null;
		}
	}

	private class Actor {
		private final String firstName;
		private final String lastName;

		private Actor(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Actor))
				return false;
			Actor actor = (Actor) o;
			return firstName.equals(actor.firstName) && lastName.equals(actor.lastName);
		}

		@Override
		public int hashCode() {
			return Objects.hash(firstName, lastName);
		}
	}

	final List<Movie> allMovies = Collections.EMPTY_LIST;

	public List<Movie> getMoviesForActor(String firstName, String lastName) {
		Actor actor = new Actor(firstName, lastName);

		List<Movie> result =  allMovies.stream()
				.filter(m -> m.getActors().contains(actor))
				.collect(Collectors.toList());
		
		
		List<Movie> result1 = allMovies.parallelStream()
	    .filter(m -> m.getActors().stream()
	        .anyMatch(
	            a -> a.getFirstName().equalsIgnoreCase(firstName) 
	                && a.getLastName().equalsIgnoreCase(lastName)))
	    .collect(Collectors.toList());
		
		return result;
		
	}

}
