package com.studio.dao;

import java.sql.*;
import java.util.*;
import com.studio.bean.Customer;
import com.studio.util.DBUtil;

public class CustomerDAO {

    public Customer findCustomer(String customerID) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "SELECT * FROM CUSTOMER_TBL WHERE CUSTOMER_ID=?");

            ps.setString(1, customerID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getString(1));
                c.setFullName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setMobile(rs.getString(4));
                c.setPreferredPackage(rs.getString(5));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> viewAllCustomers() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            ResultSet rs =
                con.createStatement()
                   .executeQuery("SELECT * FROM CUSTOMER_TBL");

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getString(1));
                c.setFullName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setMobile(rs.getString(4));
                c.setPreferredPackage(rs.getString(5));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertCustomer(Customer c) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "INSERT INTO CUSTOMER_TBL VALUES(?,?,?,?,?)");

            ps.setString(1, c.getCustomerID());
            ps.setString(2, c.getFullName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getMobile());
            ps.setString(5, c.getPreferredPackage());

            boolean result = ps.executeUpdate() > 0;
            con.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(String customerID) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "DELETE FROM CUSTOMER_TBL WHERE CUSTOMER_ID=?");

            ps.setString(1, customerID);
            boolean result = ps.executeUpdate() > 0;
            con.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
