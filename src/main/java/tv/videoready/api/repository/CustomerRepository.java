package tv.videoready.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import tv.videoready.api.entity.Customer;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{

    List<Customer> findByFirstName(String firstName);

    Page<Customer> findByFirstName(String firstName, Pageable pageable);

    List<Customer> findByAge(int age);
}
