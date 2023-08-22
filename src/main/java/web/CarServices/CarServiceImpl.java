package web.CarServices;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList  = new ArrayList<>();;

    {
        carList.add(new Car("BMW","f30",330));
        carList.add(new Car("AUDI","A6",35));
        carList.add(new Car("MERCEDES","E-SERIES",  400));
        carList.add(new Car("VOLVO","XC",60));
        carList.add(new Car("volkswagen","golf",7));

    }
    @Override
    public List<Car> getCars(int count) {
        if (count > 5) { count = 5; }
        return carList.subList(0,count);
    }

}
