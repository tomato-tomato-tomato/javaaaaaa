package utils;

import model.Customer;
import exceptions.InvalidLineException;


public class CustomerDataLoader extends FileLoader<Object>{
    @Override
    protected Object validateLine (String line) throws InvalidLineException {
        String[] data = line.split(",");
        if (data.length != 3) {
            throw new InvalidLineException("Customer is invalid " + line);
        }
        String customerId = data[0];
        String customerName = data[1];
        String customerPassword = data[2];

        return new Customer(customerId, customerName, customerPassword);
    }
}
