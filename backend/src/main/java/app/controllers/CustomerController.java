package app.controllers;

import app.entity.Customer;
import app.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private long nextId = 0;

    final private CustomerService customerService;

    @GetMapping("{id}")
    public Customer getOne(@PathVariable("id") Integer id) {
        return customerService.getOne(id).get();
    }


    @GetMapping
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer c) {
        c.setId(null);
        c.setId(++nextId);
        Customer saved = customerService.save(c);
        return ResponseEntity.status(201)
                .body(customerService.getOne(saved.getId()).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> update(@PathVariable("id") Integer id, @RequestBody Customer c) {
        Customer updated = customerService.update(c);
        return ResponseEntity.status(203)
                .body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean isDeleted = customerService.deleteById(id);

        return isDeleted ? ResponseEntity.notFound().build() :
                ResponseEntity.ok().build();
    }


}
