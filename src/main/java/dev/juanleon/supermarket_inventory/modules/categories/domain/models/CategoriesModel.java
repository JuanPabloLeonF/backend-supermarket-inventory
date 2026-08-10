package dev.juanleon.supermarket_inventory.modules.categories.domain.models;

import java.util.UUID;

public class CategoriesModel {
    private UUID id;
    private String name;
    private String description;

    private CategoriesModel(CategoriesModelBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public static CategoriesModelBuilder builder() {
        return new CategoriesModelBuilder();
    }

    public static class CategoriesModelBuilder {
        public UUID id;
        public String name;
        public String description;

        public CategoriesModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public CategoriesModelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoriesModelBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoriesModel build( ) {
            return new CategoriesModel(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoriesModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
