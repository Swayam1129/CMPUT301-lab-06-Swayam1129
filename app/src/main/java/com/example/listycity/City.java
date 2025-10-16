package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


/**
 * This is a class that defines a City.
 */
public class City  implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /**
     * Returns a hash code value for the city.
     * The hash code is computed using both the city name and province,
     * ensuring consistency with the equals method.
     *
     * @return An integer hash code based on the city's name and province.
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    /**
     * Compares this city to another object for equality.
     * Two cities are considered equal if they have the same city name
     * and province name, regardless of being different object instances.
     *
     * @param obj The object to compare with this city.
     * @return true if the given object is a City with the same name and province,
     *         false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }

    /**
     * Compares this city with another city for ordering.
     * <p>
     * The comparison is based on the lexicographical (alphabetical) order
     * of the city names. This method enables {@link java.util.Collections#sort(List)}
     * or other sorting utilities to arrange City objects alphabetically by name.
     * </p>
     *
     * @param o The City object to be compared with this city.
     * @return A negative integer, zero, or a positive integer as this city's
     *         name is lexicographically less than, equal to, or greater than
     *         the specified city's name.
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}

