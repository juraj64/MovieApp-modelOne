package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.ActorProperties.ActorProperty;
import com.jurajlazovy.movies.domain.DirectorProperties.DirectorProperty;
import com.jurajlazovy.movies.domain.Movie;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link com.jurajlazovy.movies.domain.Movie}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class MovieProperties {

	private MovieProperties() {
	}

	private static final MoviePropertiesImpl<Movie> sharedInstance = new MoviePropertiesImpl<Movie>(Movie.class);

	public static Property<Movie> id() {
		return sharedInstance.id();
	}

	public static Property<Movie> movieName() {
		return sharedInstance.movieName();
	}

	public static Property<Movie> movieLength() {
		return sharedInstance.movieLength();
	}

	public static Property<Movie> movieLang() {
		return sharedInstance.movieLang();
	}

	public static Property<Movie> releaseDate() {
		return sharedInstance.releaseDate();
	}

	public static Property<Movie> ageCertificate() {
		return sharedInstance.ageCertificate();
	}

	public static Property<Movie> domesticTakings() {
		return sharedInstance.domesticTakings();
	}

	public static Property<Movie> internationalTakings() {
		return sharedInstance.internationalTakings();
	}

	public static Property<Movie> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Movie> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Movie> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Movie> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Movie> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Movie> version() {
		return sharedInstance.version();
	}

	public static DirectorProperty<Movie> director() {
		return sharedInstance.director();
	}

	public static ActorProperty<Movie> actors() {
		return sharedInstance.actors();
	}

	/**
	 * This class is used for references to {@link com.jurajlazovy.movies.domain.Movie}, i.e. nested property.
	 */
	public static class MovieProperty<T> extends MoviePropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public MovieProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class MoviePropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		MoviePropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		MoviePropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> movieName() {
			return new LeafProperty<T>(getParentPath(), "movieName", false, owningClass);
		}

		public Property<T> movieLength() {
			return new LeafProperty<T>(getParentPath(), "movieLength", false, owningClass);
		}

		public Property<T> movieLang() {
			return new LeafProperty<T>(getParentPath(), "movieLang", false, owningClass);
		}

		public Property<T> releaseDate() {
			return new LeafProperty<T>(getParentPath(), "releaseDate", false, owningClass);
		}

		public Property<T> ageCertificate() {
			return new LeafProperty<T>(getParentPath(), "ageCertificate", false, owningClass);
		}

		public Property<T> domesticTakings() {
			return new LeafProperty<T>(getParentPath(), "domesticTakings", false, owningClass);
		}

		public Property<T> internationalTakings() {
			return new LeafProperty<T>(getParentPath(), "internationalTakings", false, owningClass);
		}

		public Property<T> uuid() {
			return new LeafProperty<T>(getParentPath(), "uuid", false, owningClass);
		}

		public Property<T> createdDate() {
			return new LeafProperty<T>(getParentPath(), "createdDate", false, owningClass);
		}

		public Property<T> createdBy() {
			return new LeafProperty<T>(getParentPath(), "createdBy", false, owningClass);
		}

		public Property<T> lastUpdated() {
			return new LeafProperty<T>(getParentPath(), "lastUpdated", false, owningClass);
		}

		public Property<T> lastUpdatedBy() {
			return new LeafProperty<T>(getParentPath(), "lastUpdatedBy", false, owningClass);
		}

		public Property<T> version() {
			return new LeafProperty<T>(getParentPath(), "version", false, owningClass);
		}

		public DirectorProperty<T> director() {
			return new DirectorProperty<T>(getParentPath(), "director", owningClass);
		}

		public ActorProperty<T> actors() {
			return new ActorProperty<T>(getParentPath(), "actors", owningClass);
		}
	}
}
