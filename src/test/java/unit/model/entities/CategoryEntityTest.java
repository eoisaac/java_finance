package unit.model.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eoisaac.model.entities.CategoryEntity;
import org.junit.Test;

public class CategoryEntityTest {
  @Test
  public void createCategoryEntity() {
    CategoryEntity category = new CategoryEntity();

    assertNotNull("Category should not be null", category);
  }

  @Test
  public void createCategoryEntityBuilder() {
    String name = "Test category";
    CategoryEntity category = CategoryEntity.builder().name(name).build();

    assertNotNull("Category should not be null", category);
    assertEquals(
        "Category name should be the same as the one passed to the builder",
        name,
        category.getName());
  }
}
