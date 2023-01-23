package it.siav.SpringSOAPws;

import it.siav.SpringSOAPws.gs_producing_web_service.Country;
import it.siav.SpringSOAPws.gs_producing_web_service.Currency;
import it.siav.SpringSOAPws.gs_producing_web_service.InsertCountryRequest;
import jakarta.annotation.PostConstruct;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;



@Repository
public class CountryRepository {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void initData() {
    }


    public void createTable(){
        String sql = "CREATE TABLE countries (name VARCHAR(255), capital VARCHAR(255), currency VARCHAR(255), population INTEGER)";
        try(Connection connection = dataSource.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertCountry(InsertCountryRequest country){
        String sql = "INSERT INTO countries (name, capital, currency, population) VALUES (?, ?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getCapital());
            preparedStatement.setString(3, country.getCurrency().toString());
            preparedStatement.setObject(4, country.getPopulation());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public Country getCountryByName(String name) {
        String sql = "SELECT * FROM countries WHERE name = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            // ResultSet è un'interfaccia JDBC che serve a rappresentare un risultato di una query, eseguita su un DB.
            if (resultSet.next()) {
                Country country = new Country();
                country.setName(resultSet.getString("name"));
                country.setCapital(resultSet.getString("capital"));
                country.setCurrency(Currency.valueOf(resultSet.getString("currency")));
                country.setPopulation(resultSet.getInt("population"));
                return country;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
