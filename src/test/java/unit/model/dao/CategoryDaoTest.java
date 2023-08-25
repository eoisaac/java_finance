package unit.model.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;
import org.eoisaac.model.dao.CategoryDao;
import org.eoisaac.model.entities.CategoryEntity;
import org.junit.Test;

public class CategoryDaoTest {

  private final CategoryDao categoryDao = new CategoryDao();

  @Test
  public void getCategoryByName() {
    String DEFAULT_CATEGORY_NAME = "OUTROS"; // Based in the resources/data/seed.sql file
    Optional<CategoryEntity> category = categoryDao.getByName(DEFAULT_CATEGORY_NAME);

    assertTrue(category.isPresent());
    assertEquals("Category name should be OUTROS", DEFAULT_CATEGORY_NAME, category.get().getName());
  }
  
  
  @Test
  public void getAllCategories() {
    List<CategoryEntity> categories = categoryDao.getAll();

    assertNotNull("Categories should not be null", categories);
    assertFalse("Categories should not be empty", categories.isEmpty());
    
    int TOTAL_DB_CATEGORIES = 8; // Based in the resources/data/seed.sql file
    assertEquals("Categories size should be 5", TOTAL_DB_CATEGORIES, categories.size());
  }
  
  @Test
  public void createCategory() {
    String NEW_CATEGORY_NAME = "TESTING";
    CategoryEntity newCategory = CategoryEntity.builder().name(NEW_CATEGORY_NAME).build();

    Optional<CategoryEntity> createdCategory = categoryDao.create(newCategory);

    assertTrue(createdCategory.isPresent());
    assertEquals("Category name should be TESTING", NEW_CATEGORY_NAME, createdCategory.get().getName());
  }

}
