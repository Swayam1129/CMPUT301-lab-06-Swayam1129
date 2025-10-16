package com.example.listycity;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }


    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Calgary", "Alberta");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList list = new CityList();
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));

        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Toronto", "Ontario")));
    }

    @Test
    public void testDeleteCity() {
        CityList list = new CityList();
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));

        City city = new City("Edmonton", "Alberta");
        list.delete(city);

        assertFalse(list.hasCity(city));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteException() {
        CityList list = new CityList();
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));

        list.delete(new City("Vancouver", "British Columbia"));
    }

    @Test
    public void testCountCities() {
        CityList list = new CityList();
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));

        assertEquals(2, list.countCities());

        list.delete(new City("Calgary", "Alberta"));

        assertEquals(1, list.countCities());
    }

}
