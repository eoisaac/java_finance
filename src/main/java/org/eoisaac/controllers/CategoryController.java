package org.eoisaac.controllers;

import org.eoisaac.model.dao.CategoryDao;
import org.eoisaac.model.entities.CategoryEntity;

public class CategoryController {

  CategoryDao categoryDao;

  public CategoryController() {
    categoryDao = new CategoryDao();
  }

  public CategoryEntity createCategory(String name) {
    CategoryEntity newCategory = CategoryEntity.builder().name(name).build();
    return categoryDao.create(newCategory).orElse(null);
  }
}
