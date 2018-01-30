package tv.videoready.api.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.videoready.api.co.SampleCO;
import tv.videoready.api.dto.ResponseDto;
import tv.videoready.api.entity.Customer;
import tv.videoready.api.enums.SuccessResponse;
import tv.videoready.api.repository.CustomerRepository;
import tv.videoready.api.services.SampleService;
import tv.videoready.api.util.response.PrepareResponseUtil;
import tv.videoready.logger.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * The {@link SampleController}
 * mobile or web facing rest-api's.
 *
 * @author Vikram Jakhar
 */
@RestController
@RequestMapping(value = {"/sample"})
public class SampleController {

    private static final Logger log = LoggerFactory.make();

    @Autowired
    private PrepareResponseUtil responseUtil;
    @Autowired
    private SampleService sampleService;
    @Resource
    CustomerRepository customerRepository;

    /**
     * Your javadoc comment.
     *
     * @param sampleCO is sample command object to bind.
     * @return - response.
     */

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/test")
    public ResponseDto sample(@RequestBody SampleCO sampleCO) {
        Customer cust_1 = new Customer("1", "Peter", "Smith", 20);
        Customer cust_2 = new Customer("2", "Mary", "Taylor", 25);
        Customer cust_3 = new Customer("3", "Peter", "Brown", 30);
        Customer cust_4 = new Customer("4", "Lauren", "Taylor", 20);
        Customer cust_5 = new Customer("5", "Lauren", "Jones", 45);
        Customer cust_6 = new Customer("6", "Peter", "Williams", 20);

        // save customers to ElasticSearch
        System.out.println("===================Save Customers===================");
        customerRepository.save(cust_1);
        customerRepository.save(cust_2);
        customerRepository.save(cust_3);
        customerRepository.save(cust_4);
        customerRepository.save(cust_5);
        customerRepository.save(cust_6);

        // find a Customer by Id
        System.out.println("===================Find a customer by id = 5===================");
        Customer cust_id_5 = customerRepository.findOne("5");
        System.out.println(cust_id_5);

        // findAll
        System.out.println("===================Find All===================");
        Iterable<Customer> customers = customerRepository.findAll();
        customers.forEach(System.out::println);

        // find customers by firstname = Peter
        System.out.println("===================Find by firstname is Peter===================");
        List<Customer> cust_Peters = customerRepository.findByFirstName("Peter");
        cust_Peters.forEach(System.out::println);

        // find a first page customers with size = 2
        System.out.println("===================Find by firstname is Peter with PageRequest(0, 2)================");
        Page<Customer> page_Peters = customerRepository.findByFirstName("Peter", new PageRequest(0, 2));
        page_Peters.forEach(System.out::println);

        // find all customer having age = 20
        System.out.println("===================Find by age = 20===================");
        List<Customer> cust_age_20 = customerRepository.findByAge(20);
        cust_age_20.forEach(System.out::println);

        // delete a customer having age = 20
        System.out.println("===================Delete a Customer having age = 20===================");
        customerRepository.delete(cust_age_20.get(0));

        // again: find all customer with age = 20
        // => result list with size = 2
        System.out.println("===================Find by age = 20===================");
        cust_age_20 = customerRepository.findByAge(20);
        cust_age_20.forEach(System.out::println);
        return responseUtil.prepareSuccessResponse(sampleService.sampleMethod(sampleCO), SuccessResponse.SAMPLE_MESSAGE, null);
    }
}
