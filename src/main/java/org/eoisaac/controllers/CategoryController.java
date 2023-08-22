package org.eoisaac.controllers;

import java.util.List;
import java.util.Optional;
import org.eoisaac.model.dao.CategoryDao;
import org.eoisaac.model.entities.CategoryEntity;

/*
* That class is responsible for controlling the category DAO.
* */

public class CategoryController {

  CategoryDao categoryDao; // Category DAO

  public CategoryController() { // Constructor

    categoryDao = new CategoryDao(); // Initialize category DAO
  }

  public Optional<CategoryEntity> createCategory(String name) { // Create category
    CategoryEntity newCategory = CategoryEntity.builder().name(name).build(); // Create new category
    Optional<CategoryEntity> category = categoryDao.getByName(name); // Get category by name
    return category.isPresent()
        ? category
        : categoryDao.create(newCategory); // Return category if it exists, else create category
  }

  public List<CategoryEntity> getAllCategories() { // Get all categories
    return categoryDao.getAll(); // Return all categories
  }
}
