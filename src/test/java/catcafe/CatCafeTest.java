package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
/*

  @Test
  void addCat_throws_nullPointerException_when_empty_string_is_added() {
      // given
      CatCafe catcafe = new CatCafe();

      // when & then
      assertThrows(NullPointerException.class, () -> catcafe.addCat(""));
  }
*/

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100})
    void getCatCount_returns_correct_number_of_cats(int catCount) {
        // given
        CatCafe catcafe = new CatCafe();
        for (int i = 0; i < catCount; i++) catcafe.addCat(new FelineOverLord("Cat" + i, i + 1));
        // Schlägt fehl wenn weight für alle = 1 ist
        // getCatCount gibt dann immer nur eine Katze zurück

        // when
        long res = catcafe.getCatCount();

        // then
        assertEquals(catCount, res);
    }

    @Test
    void getCatByName_returns_correct_cat_when_one_cat_exists() {
        // given
        String testName = "Erna";
        FelineOverLord testCat = new FelineOverLord(testName, 4);

        CatCafe catcafe = new CatCafe();
        catcafe.addCat(testCat);

        // when

        FelineOverLord res = catcafe.getCatByName(testName);

        // then
        assertEquals(testCat, res);
    }

    @Test
    void getCatByName_returns_correct_cat_when_multiple_cats_exist() {
        // given
        CatCafe catcafe = new CatCafe();

        FelineOverLord targetCat = new FelineOverLord("Erna", 4);
        FelineOverLord paul = new FelineOverLord("Magister Paul", 5);

        catcafe.addCat(targetCat);
        catcafe.addCat(paul);

        // when
        FelineOverLord res = catcafe.getCatByName("Erna");

        // then
        assertEquals(res, targetCat);
    }

    @Test
    void getCatByName_returns_null_when_catcafe_is_empty() {
        // given
        String testName = "Magister Paul";

        CatCafe catcafe = new CatCafe();

        // when
        FelineOverLord res = catcafe.getCatByName(testName);

        // then
        assertNull(res);
    }

    @Test
    void getCatByName_returns_null_when_searching_by_null_name() {
        // given
        CatCafe catcafe = new CatCafe();
        catcafe.addCat(new FelineOverLord("Magister Paul", 5));
        catcafe.addCat(new FelineOverLord("Erna", 4));

        // when
        FelineOverLord res = catcafe.getCatByName(null);

        // then
        assertNull(res);
    }

}
