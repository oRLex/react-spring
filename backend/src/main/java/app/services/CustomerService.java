package app.services;

import app.dao.DAO;
import app.entity.Account;
import app.entity.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomerService implements DAO<Customer> {
    HashMap<Long, Customer> customers = new HashMap<>();

    @Override
    public Customer save(Customer obj) {
        if (customers.containsKey(obj.getId())) {
        }
        customers.put(obj.getId(), obj);
        return customers.get(obj.getId());
    }

    @Override
    public boolean delete(Customer obj) {
        if (customers.containsKey(obj.getId())) {
            customers.remove(obj.getId());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        entities.forEach(customers::remove);

    }

    @Override
    public void saveAll(List<Customer> entities) {
        entities.forEach(e -> customers.put(e.getId(), e));

    }

    @Override
    public List<Customer> findAll() {
        return customers.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(long id) {
        if (customers.containsKey(id)) {
            customers.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Customer> getOne(long id) {
        return Optional.of(customers.get(id));
    }

    public Customer update(Customer c) {
        return customers.put(c.getId(), c);
    }
}
