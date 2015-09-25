/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.sample;

import com.demo.sample.Customer;
import com.demo.sample.DiscountCode;
import com.demo.sample.MicroMarket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boojongmin
 */
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerId method, of class Customer.
     */
    @org.junit.Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Customer instance = new Customer();
        Integer expResult = null;
        Integer result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerId method, of class Customer.
     */
    @org.junit.Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        Integer customerId = null;
        Customer instance = new Customer();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Customer.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Customer.
     */
    @org.junit.Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Customer instance = new Customer();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressline1 method, of class Customer.
     */
    @org.junit.Test
    public void testGetAddressline1() {
        System.out.println("getAddressline1");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getAddressline1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressline1 method, of class Customer.
     */
    @org.junit.Test
    public void testSetAddressline1() {
        System.out.println("setAddressline1");
        String addressline1 = "";
        Customer instance = new Customer();
        instance.setAddressline1(addressline1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressline2 method, of class Customer.
     */
    @org.junit.Test
    public void testGetAddressline2() {
        System.out.println("getAddressline2");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getAddressline2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressline2 method, of class Customer.
     */
    @org.junit.Test
    public void testSetAddressline2() {
        System.out.println("setAddressline2");
        String addressline2 = "";
        Customer instance = new Customer();
        instance.setAddressline2(addressline2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class Customer.
     */
    @org.junit.Test
    public void testGetCity() {
        System.out.println("getCity");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class Customer.
     */
    @org.junit.Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        Customer instance = new Customer();
        instance.setCity(city);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Customer.
     */
    @org.junit.Test
    public void testGetState() {
        System.out.println("getState");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class Customer.
     */
    @org.junit.Test
    public void testSetState() {
        System.out.println("setState");
        String state = "";
        Customer instance = new Customer();
        instance.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Customer.
     */
    @org.junit.Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Customer.
     */
    @org.junit.Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Customer instance = new Customer();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFax method, of class Customer.
     */
    @org.junit.Test
    public void testGetFax() {
        System.out.println("getFax");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getFax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFax method, of class Customer.
     */
    @org.junit.Test
    public void testSetFax() {
        System.out.println("setFax");
        String fax = "";
        Customer instance = new Customer();
        instance.setFax(fax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @org.junit.Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @org.junit.Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Customer instance = new Customer();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreditLimit method, of class Customer.
     */
    @org.junit.Test
    public void testGetCreditLimit() {
        System.out.println("getCreditLimit");
        Customer instance = new Customer();
        Integer expResult = null;
        Integer result = instance.getCreditLimit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreditLimit method, of class Customer.
     */
    @org.junit.Test
    public void testSetCreditLimit() {
        System.out.println("setCreditLimit");
        Integer creditLimit = null;
        Customer instance = new Customer();
        instance.setCreditLimit(creditLimit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscountCode method, of class Customer.
     */
    @org.junit.Test
    public void testGetDiscountCode() {
        System.out.println("getDiscountCode");
        Customer instance = new Customer();
        DiscountCode expResult = null;
        DiscountCode result = instance.getDiscountCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscountCode method, of class Customer.
     */
    @org.junit.Test
    public void testSetDiscountCode() {
        System.out.println("setDiscountCode");
        DiscountCode discountCode = null;
        Customer instance = new Customer();
        instance.setDiscountCode(discountCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZip method, of class Customer.
     */
    @org.junit.Test
    public void testGetZip() {
        System.out.println("getZip");
        Customer instance = new Customer();
        MicroMarket expResult = null;
        MicroMarket result = instance.getZip();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZip method, of class Customer.
     */
    @org.junit.Test
    public void testSetZip() {
        System.out.println("setZip");
        MicroMarket zip = null;
        Customer instance = new Customer();
        instance.setZip(zip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Customer.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Customer instance = new Customer();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Customer.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Customer instance = new Customer();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Customer.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
