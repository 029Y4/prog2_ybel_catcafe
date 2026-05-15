package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

  @Test
  void addCat_adds_cats_successfully() {
    // given
    CatCafe catcafe = new CatCafe();
    FelineOverLord erna = new FelineOverLord("Erna", 4);

    catcafe.addCat(new FelineOverLord("Magister Paul", 5));
    catcafe.addCat(erna);
    // when
    FelineOverLord res = catcafe.getCatByName("Erna");

    // then
    assertEquals(erna, res);
  }

  @Test
  void addCat_throws_nullPointerException_when_adding_null_cat() {
    // given
    CatCafe catcafe = new CatCafe();

    // when & then
    assertThrows(NullPointerException.class, () -> catcafe.addCat(null));
  }

  @Test
  void addCat_throws_nullPointerException_when_empty_string_is_added() {
      // given
      CatCafe catcafe = new CatCafe();

      // when & then
      assertThrows(NullPointerException.class, () -> catcafe.addCat(""));
  }
}
