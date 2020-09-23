package com.jurajlazovy.movies.domain;

import com.jurajlazovy.movies.domain.Actor;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link com.jurajlazovy.movies.domain.Actor}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class ActorProperties {

	private ActorProperties() {
	}

	private static final ActorPropertiesImpl<Actor> sharedInstance = new ActorPropertiesImpl<Actor>(Actor.class);

	public static Property<Actor> id() {
		return sharedInstance.id();
	}

	public static Property<Actor> firstName() {
		return sharedInstance.firstName();
	}

	public static Property<Actor> lastName() {
		return sharedInstance.lastName();
	}

	public static Property<Actor> dateOfBirth() {
		return sharedInstance.dateOfBirth();
	}

	public static Property<Actor> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Actor> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Actor> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Actor> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Actor> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Actor> version() {
		return sharedInstance.version();
	}

	public static Property<Actor> gender() {
		return sharedInstance.gender();
	}

	/**
	 * This class is used for references to {@link com.jurajlazovy.movies.domain.Actor}, i.e. nested property.
	 */
	public static class ActorProperty<T> extends ActorPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public ActorProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class ActorPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		ActorPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		ActorPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
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

		public Property<T> gender() {
			return new LeafProperty<T>(getParentPath(), "gender", false, owningClass);
		}
	}
}
