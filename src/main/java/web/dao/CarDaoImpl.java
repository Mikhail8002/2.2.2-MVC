package web.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.entity.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("MERS", 2025, 600));
        cars.add(new Car("ZHIGA", 2025, 700));
        cars.add(new Car("LADA", 2025, 400));
        cars.add(new Car("NIVA", 2025, 500));
        cars.add(new Car("JEEP", 2025, 900));
    }

    public List<Car> index(int count) {
        if (count == 0) {
            return cars;
        }

        return cars.stream().limit(count).collect(Collectors.toList());
    }
}

