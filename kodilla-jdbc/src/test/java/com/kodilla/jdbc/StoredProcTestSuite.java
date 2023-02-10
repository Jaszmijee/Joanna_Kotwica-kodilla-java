package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement2.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String setAlBestsellersToFalse = "UPDATE BOOKS SET BESTSELLER = FALSE";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(setAlBestsellersToFalse);

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String callUpdateBestsellers = "CALL UpdateBestSellers";
        statement2.executeUpdate(callUpdateBestsellers);

        Statement statement3 = dbManager.getConnection().createStatement();
        String calculateBestseller = "SELECT COUNT(*) AS NO_OF_BESTSELLSERS FROM BOOKS WHERE BESTSELLER = TRUE";
        ResultSet resultSet = statement3.executeQuery(calculateBestseller);

        //Then
        int noOfBestSellers = -1;
        if (resultSet.next()) {
            noOfBestSellers = resultSet.getInt("NO_OF_BESTSELLSERS");
        }
        assertEquals(1, noOfBestSellers);
        resultSet.close();
        statement.close();
        statement2.close();
        statement3.close();
    }

}