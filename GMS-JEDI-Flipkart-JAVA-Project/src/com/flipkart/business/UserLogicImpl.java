package com.flipkart.business;

import com.flipkart.DAO.UserDAOImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exceptions.UserNotFoundException;

public class UserLogicImpl implements UserLogic {
    UserDAOImpl userGMSDao = new UserDAOImpl();

    /**
     Registers a customer in the database.
     @param customerData The Customer object representing the customer data
     */
    public void registerCustomer(Customer customerData) {
        userGMSDao.registerCustomer(customerData);
    }

    /**
     Registers a gym owner in the database.
     @param ownerData The GymOwner object representing the gym owner data
     */
    public void registerGymOwner(GymOwner ownerData) throws UserNotFoundException {
        if(ownerData==null){
            throw new UserNotFoundException();
        }
        userGMSDao.registerGymOwner(ownerData);
    }
    /**
     Authenticates a user based on the provided user data.
     @param userData The User object representing the user data
     @return The authenticated User object if authentication is successful, null otherwise
     */
    public User authenticateUser(User userData) {
        try {
            User authenticatedUser = userGMSDao.isAuthenticated(userData);
            return authenticatedUser;
        } catch (Exception e) {
            System.out.println("User Not Found");

        }
        return null;
    }
    /**
     Registers a user in the database.
     @param userData The User object representing the user data
     */
    public void registerUser(User userData) {
        userGMSDao.registerUser(userData);
    }
}


