package business.service;


import  data.entities.Restaurant;
import  data.repositories.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantService {
    @Autowired
    private IRestaurantRepository restaurantRepository  ;

    @SuppressWarnings("unchecked")
    public Restaurant findByMerchantNumber(String merchantNumber) {
        Restaurant output  = restaurantRepository.findByMerchantNumber(merchantNumber);
        return output;
    }

}
