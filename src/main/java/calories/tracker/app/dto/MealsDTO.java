package calories.tracker.app.dto;

import java.util.List;

import org.hdiv.services.SecureIdContainer;

/**
 *
 * JSON serializable DTO containing data concerning a meal search request.
 *
 */
public class MealsDTO implements SecureIdContainer{

    private long currentPage;
    private long totalPages;
    List<MealDTO> meals;

    public MealsDTO(long currentPage, long totalPages, List<MealDTO> meals) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.meals = meals;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<MealDTO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDTO> meals) {
        this.meals = meals;
    }
}
