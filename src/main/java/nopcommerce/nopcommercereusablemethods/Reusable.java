package nopcommerce.nopcommercereusablemethods;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.country.Country;
import nopcommerce.nopcommerceenums.excel.Excel;
import nopcommerce.nopcommerceobjects.Customer;
import nopcommerce.nopcommercerandom.Date;
import org.openqa.selenium.WebElement;
import utility.ExcelReader;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Reusable extends CommonAPI {

    public static String password1 = new Customer().getPassword();

    public static String newPassword = new Customer().getNewPassword();

    public static String weakPassword = new Customer().getWeakPassword();

    public void enterFields(List<String> fields, List<WebElement> elements) {
        for (int i = 0; i < fields.size(); i++) {
            type(elements.get(i), fields.get(i));
        }
    }

    public void selectFields(List<String> fields, List<WebElement> elements) {
        for (int i = 0; i < fields.size(); i++) {
            selectFromDropdown(elements.get(i), fields.get(i));
        }
    }

    public void enterFieldsCustomer(Customer customer, List<String> fields, List<WebElement> elements) {
        for (int i = 0; i < fields.size(); i++) {
            type(elements.get(i), fields.get(i));
        }
    }

    public void firstNameLastName(WebElement firstNameField, WebElement lastNameField) {
        List<String> billingFields = Arrays.asList(new Customer().getFirstName(), new Customer().getLastName());
        List<WebElement> billingFieldsElements = Arrays.asList(firstNameField, lastNameField);
        new Reusable().enterFields(billingFields, billingFieldsElements);
    }

    public void billFirstNameLastName(WebElement firstNameField, WebElement lastNameField) {
        List<String> billingFields = Arrays.asList(new Customer().getFirstName(), new Customer().getLastName());
        List<WebElement> billingFieldsElements = Arrays.asList(firstNameField, lastNameField);
        new Reusable().enterFields(billingFields, billingFieldsElements);
    }

    public void firstNameLastNameEmail(Customer customer, WebElement firstNameField, WebElement lastNameField, WebElement emailField) {
        List<String> billingFields = Arrays.asList(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        List<WebElement> billingFieldsElements = Arrays.asList(firstNameField, lastNameField, emailField);
        new Reusable().enterFieldsCustomer(customer, billingFields, billingFieldsElements);
    }

    public void addressAndPhoneNumber(Customer customer, WebElement cityField, WebElement addressField, WebElement zipCodeField, WebElement phoneNumberField) {
        List<String> billingFields = Arrays.asList(customer.getCity(), customer.getAddress(), customer.getZipCode(), customer.getPhoneNumber());
        List<WebElement> billingFieldsElements = Arrays.asList(cityField, addressField, zipCodeField, phoneNumberField);
        new Reusable().enterFieldsCustomer(customer, billingFields, billingFieldsElements);
    }

    public void birthDateFields(WebElement dateOfBirthDay, WebElement dateOfBirthMonth, WebElement dateOfBirthYear) {
        List<String> birth = Arrays.asList(Date.randomDay(), Date.randomMonth(), Date.randomYear());
        List<WebElement> birthWebElements = Arrays.asList(dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear);
        new Reusable().selectFields(birth, birthWebElements);
    }

    public void emailPasswordFields(String email1, WebElement email, WebElement password, WebElement confirmPassword) {
        List<String> pass = Arrays.asList(email1, password1, password1);
        List<WebElement> passElements = Arrays.asList(email, password, confirmPassword);
        new Reusable().enterFields(pass, passElements);
    }

    public void weakPasswordFields(String email1, WebElement email, WebElement password, WebElement confirmPassword) {
        List<String> pass = Arrays.asList(email1, weakPassword, weakPassword);
        List<WebElement> passElements = Arrays.asList(email, password, confirmPassword);
        new Reusable().enterFields(pass, passElements);
    }

    public void selectCountryAndState(WebElement countryDropDown, WebElement stateDropDown) {
        List<String> countryList = new ExcelReader(Excel.COUNTRY_PATH.getExcel()).getEntireColumnForGivenHeader(Excel.SHEET.getExcel(), Excel.COUNTRY_HEADER.getExcel());
        String randomCountry = countryList.get(new Random().nextInt(countryList.size()));
        selectFromDropdown(countryDropDown, randomCountry);
        if (Country.UNITED_STATES.getCountry().equals(randomCountry) || Country.CANADA.getCountry().equals(randomCountry)) {
            selectFromDropdown(stateDropDown, new Customer().getState());
        }
    }
}
