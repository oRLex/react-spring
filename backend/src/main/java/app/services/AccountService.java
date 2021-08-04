package app.services;

import app.dao.DAO;
import app.entity.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountService implements DAO<Account> {
    HashMap<Long, Account> accounts = new HashMap<>();

    @Override
    public Account save(Account obj) {
        if (accounts.containsKey(obj.getId())) {
        }
        accounts.put(obj.getId(), obj);
        return accounts.get(obj.getId());
    }

    @Override
    public boolean delete(Account obj) {
        if (accounts.containsKey(obj.getId())) {
            accounts.remove(obj.getId());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Account> entities) {
        entities.forEach(accounts::remove);
    }

    @Override
    public void saveAll(List<Account> entities) {
        entities.forEach(e -> accounts.put(e.getId(), e));
    }

    @Override
    public List<Account> findAll() {
        return accounts.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(long id) {
        if (accounts.containsKey(id)) {
            accounts.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Account> getOne(long id) {
        return Optional.of(accounts.get(id));
    }
}
