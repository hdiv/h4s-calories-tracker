package calories.tracker.app.dto;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hdiv.services.SecureIdentifiable;
import org.hdiv.services.TrustAssertion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import calories.tracker.app.dto.serialization.CustomTimeDeserializer;
import calories.tracker.app.dto.serialization.CustomTimeSerializer;
import calories.tracker.app.model.Meal;

/**
 *
 * JSON serializable DTO containing Meal data
 *
 */
public class MealDTO implements SecureIdentifiable<Long> {

	private Long id;

	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "CET")
	private Date date;

	@JsonSerialize(using = CustomTimeSerializer.class)
	@JsonDeserialize(using = CustomTimeDeserializer.class)
	private Time time;

	private String description;

	private Long calories;

	public MealDTO() {
	}

	public MealDTO(final Long id, final Date date, final Time time, final String description, final Long calories) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
		this.calories = calories;
	}

	public static MealDTO mapFromMealEntity(final Meal meal) {
		return new MealDTO(meal.getId(), meal.getDate(), meal.getTime(), meal.getDescription(), meal.getCalories());
	}

	public static List<MealDTO> mapFromMealsEntities(final List<Meal> meals) {
		return meals.stream().map((meal) -> mapFromMealEntity(meal)).collect(Collectors.toList());
	}

	@Override
	@TrustAssertion(idFor = MealDTO.class)
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(final Time time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(final Long calories) {
		this.calories = calories;
	}

}
