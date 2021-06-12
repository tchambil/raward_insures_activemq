package  data.repositories;

import  data.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Long> {
    /**
     * Load a Restaurant entity by its merchant number.
     * @param merchantNumber the merchant number
     * @return the restaurant
     */
   @Query(value = "SELECT r.id,r.number,r.name,r.benefit_percentage,r.benefit_availability_policy from t_restaurant r where r.number = :merchantNumber",nativeQuery = true)
   Restaurant findByMerchantNumber(String merchantNumber);
}
