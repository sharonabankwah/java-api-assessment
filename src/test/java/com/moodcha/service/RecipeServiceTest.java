package com.moodcha.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.moodcha.exception.RecipeNotFoundException;
import com.moodcha.model.BaseRecipe;
import com.moodcha.model.MilkBasedRecipe;
import com.moodcha.repository.MilkBasedRepository;
import com.moodcha.repository.JuiceBasedRepository;
import com.moodcha.repository.WaterBasedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import java.util.UUID;

/* Unit test for RecipeService
 * Tests getRecipeById(UUID) for both a successful fetch from MilkBasedRepository
 * In the scenario where the recipe is not found it throws a custom exception
 */
class RecipeServiceTest {

    @Mock
    private MilkBasedRepository milkRepo;

    @Mock
    private WaterBasedRepository waterRepo;

    @Mock
    private JuiceBasedRepository juiceRepo;

    @InjectMocks
    private RecipeService recipeService;

    private UUID testId;
    private BaseRecipe testRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testId = UUID.randomUUID();
        testRecipe = mock(BaseRecipe.class);
    }

    @Test
    void testGetRecipeByIdInMilkRepo() {
        MilkBasedRecipe milkRecipe = mock(MilkBasedRecipe.class); 
        when(milkRepo.findById(testId)).thenReturn(Optional.of(milkRecipe));
        when(waterRepo.findById(testId)).thenReturn(Optional.empty());
        when(juiceRepo.findById(testId)).thenReturn(Optional.empty());

        BaseRecipe result = recipeService.getRecipeById(testId);

        assertNotNull(result);
        assertEquals(milkRecipe, result);

        verify(milkRepo).findById(testId);
        verify(waterRepo).findById(testId);
        verify(juiceRepo).findById(testId);
    }

    @Test
    void testGetRecipeByIdNotFound_throwsException() {
        // Arrange
        when(milkRepo.findById(testId)).thenReturn(Optional.empty());
        when(waterRepo.findById(testId)).thenReturn(Optional.empty());
        when(juiceRepo.findById(testId)).thenReturn(Optional.empty());

        assertThrows(RecipeNotFoundException.class, () -> recipeService.getRecipeById(testId));
    }
}