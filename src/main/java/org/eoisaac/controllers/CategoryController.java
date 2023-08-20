package org.eoisaac.controllers;

import org.eoisaac.model.dao.CategoryDao;
import org.eoisaac.model.entities.CategoryEntity;

import java.util.List;
import java.util.Optional;

public class CategoryController {

  CategoryDao categoryDao;

  public CategoryController() {
    categoryDao = new CategoryDao();
  }

  public Optional<CategoryEntity> createCategory(String name) {
    CategoryEntity newCategory = CategoryEntity.builder().name(name).build();
    return categoryDao.create(newCategory);
  }

  public List<CategoryEntity> getAllCategories() {
    return categoryDao.getAll();
  }
}
