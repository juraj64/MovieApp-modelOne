package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Director;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link com.jurajlazovy.movies.domain.Director}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class DirectorProperties {

	private DirectorProperties() {
	}

	private static final DirectorPropertiesImpl<Director> sharedInstance = new DirectorPropertiesImpl<Director>(Director.class);

	public static Property<Director> id() {
		return sharedInstance.id();
	}

	public static Property<Director> firstName() {
		return sharedInstance.firstName();
	}

	public static Property<Director> lastName() {
		return sharedInstance.lastName();
	}

	public static Property<Director> dateOfBirth() {
		return sharedInstance.dateOfBirth();
	}

	public static Property<Director> nationality() {
		return sharedInstance.nationality();
	}

	public static Property<Director> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Director> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Director> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Director> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Director> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Director> version() {
		return sharedInstance.version();
	}

	/**
	 * This class is used for references to {@link com.jurajlazovy.movies.domain.Director}, i.e. nested property.
	 */
	public static class DirectorProperty<T> extends DirectorPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public DirectorProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class DirectorPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		DirectorPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		DirectorPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> firstName() {
			return new LeafProperty<T>(getParentPath(), "firstName", false, owningClass);
		}

		public Property<T> lastName() {
			return new LeafProperty<T>(getParentPath(), "lastName", false, owningClass);
		}

		public Property<T> dateOfBirth() {
			return new LeafProperty<T>(getParentPath(), "dateOfBirth", false, owningClass);
		}

		public Property<T> nationality() {
			return new LeafProperty<T>(getParentPath(), "nationality", false, owningClass);
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
	}
}
