package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory SessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		//get the current hibernate session
		Session session=SessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> query=session.createQuery("from Customer order by lastName",Customer.class);
		
		//execute the query and get result list
		List<Customer> customers=query.getResultList();
		
		//return the results
		return customers;
	}


	public void saveCustomer(Customer customer) {
		
		//get the current hibernate session
		Session session=SessionFactory.getCurrentSession();
		
		//save the customer
		session.saveOrUpdate(customer);
	}


	public Customer getCustomer(int id) {
		
		//get the current hibernate session
		Session session=SessionFactory.getCurrentSession();
				
		Customer customer=session.get(Customer.class,id);
		return customer;
	}


	@Override
	public void deleteCustomer(int id) {
		
		//get the current hibernate session
		Session session=SessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query query=session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

}
