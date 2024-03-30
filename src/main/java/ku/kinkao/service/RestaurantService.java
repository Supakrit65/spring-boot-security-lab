package ku.kinkao.service;


import ku.kinkao.dto.RestaurantRequest;
import ku.kinkao.entity.Restaurant;
import ku.kinkao.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository repository;


    @Autowired
    private ModelMapper modelMapper;


    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }


    public Restaurant getOneRestaurant(UUID id) {
        // implement with null object pattern
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        throw new NoSuchElementException("No restaurant with specified id");
    }


    public void createRestaurant(RestaurantRequest dto) {
        // get dto and map it to dao
        Restaurant dao = modelMapper.map(dto, Restaurant.class);
        dao.setCreatedAt(Instant.now());

        repository.save(dao);
    }
}
