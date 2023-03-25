package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * Integration Test to test reports
 */
public class AppIntegrationTest {
    /**Test connection to database
     * Used in all reports
     */
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
        // Connect to database
        app.connect("localhost:33060", 30000);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /** Integration test for extract all world countries
     * Author - AOB
     */
    @Test
    public void testGetAllCountries(){
        ArrayList<Country> country = Country.getAllCountries(app.con);
        assertNotNull(country);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for extract specific continent countries
     * Author - AOB
     */
    @Test
    public void testGetContinentCountries(){
        ArrayList<Country> country = Country.getContinentCountries(app.con);
        assertNotNull(country);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for extract specific region countries
     * Author - AOB
     */
    @Test
    public void testGetRegionCountries() {
        ArrayList<Country> country = Country.getRegionCountries(app.con);
        //validates

        assertNotNull(country);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Test connection to database and to test getting world population
     * Used in additional_info 1 report
     */
    @Test
    public void GetWorldPopulation() {
        Population pop = Population.getPopulation(app.con);
        //validates
        assertNotEquals(0, pop.population );
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Test connection to database and to test getting world population
     * Used in report 8
     */
    @Test
    public void getCityByContinent() {
        ArrayList<City> cities = City.getCityPopulationByContinent("europe", app.con);
        //validates that only selected continent cities are selected.
        boolean allEqual = cities.stream().distinct().count() <= 1;
        assertEquals(true, allEqual);
    }
//--------------------------------------------------------------------------------------------------------------------//
}



