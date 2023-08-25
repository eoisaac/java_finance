package unit.model.dao;

import org.eoisaac.model.dao.CategoryDao;
import org.eoisaac.model.entities.CategoryEntity;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;

import java.util.Optional;

public class CategoryDaoTest {

  private final CategoryDao categoryDao = new CategoryDao();

  private final String expectedNameA = "category_1";
  private final String expectedNameB = "category_2";

  @BeforeEach
  public void setup() {

  }

  @Test
  public void createCategory() {
    Optional<CategoryEntity> category = categoryDao.create(CategoryEntity.builder().name(expectedNameA).build());

    assertTrue(category.isPresent());
    assertEquals(category.get().getName(), expectedNameA);
  }

  @Test
  public void getCategoryByName() {
    Optional<CategoryEntity> category = categoryDao.getByName(expectedNameA);

    assertTrue(category.isPresent());
    assertEquals("", expectedNameA, category.get().getName());
  }

  @Test
  public void getAllCategories() {
    List<CategoryEntity> categories = categoryDao.getAll();

    assertNotNull(categories);
    assertEquals("", 2, categories.size());
  }
}
