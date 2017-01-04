package springfaces;

import javax.faces.view.ViewScoped;

import mvc.model.Customer;
import mvc.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customerHome")
@ViewScoped
public class CustomerHome
{

    @Autowired
    CustomerService customerService;

    private Customer customer;

    public Customer getCustomer()
    {
        if (customer == null)
            customer = new Customer();
        return customer;
    }

    public String register()
    {
        //update at second call
        customerService.persist(getCustomer());
        return "persisted";
    }

}
