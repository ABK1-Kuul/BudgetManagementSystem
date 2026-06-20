package com.smartbudget.services;

import java.util.Map;

import com.smartbudget.exceptions.DatabaseException;

public interface DashboardService {

    double getTotalIncome(int userId) throws DatabaseException;

    double getTotalExpenses(int userId) throws DatabaseException;

    double getNetBalance(int userId) throws DatabaseException;

    Map<String, Double> getExpenseDistributionByCategory(int userId) throws DatabaseException;
}
