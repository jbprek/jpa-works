package org.bagab.orders.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerRepositoryTests {

//


	@Autowired
	CustomerRepository repository;
	Customer user;

	@Before
	public void setUp() {

		user = new Customer();
		user.setUsername("foobar");
		user.setFirstname("firstname");
		user.setLastname("lastname");
	}

	@Test
	public void findSavedCustomerById() {

		user = repository.save(user);

		assertThat(repository.findOne(user.getId()), is(user));
	}

	@Test
	public void findSavedCustomerByLastname() throws Exception {

		user = repository.save(user);

		List<Customer> users = repository.findByLastname("lastname");

		assertThat(users, is(notNullValue()));
		assertThat(users.contains(user), is(true));
	}

	@Test
	public void findByFirstnameOrLastname() throws Exception {

		user = repository.save(user);

		List<Customer> users = repository.findByFirstnameOrLastname("lastname");

		assertThat(users.contains(user), is(true));
	}

	@Test
	public void useOptionalAsReturnAndParameterType() {

		assertThat(repository.findByUsername(Optional.of("foobar1")), is(Optional.empty()));

		repository.save(user);

		assertThat(repository.findByUsername(Optional.of("foobar")).isPresent(), is(true));
	}

	@Test
	public void removeByLastname() {

		// create a 2nd user with the same lastname as user
		Customer user2 = new Customer();
		user2.setLastname(user.getLastname());

		// create a 3rd user as control group
		Customer user3 = new Customer();
		user3.setLastname("no-positive-match");

		repository.save(Arrays.asList(user, user2, user3));

		assertThat(repository.removeByLastname(user.getLastname()), is(2L));
		assertThat(repository.exists(user3.getId()), is(true));
	}

	@Test
	public void useSliceToLoadContent() {

		repository.deleteAll();

		// int repository with some values that can be ordered
		int totalNumberCustomers = 11;
		List<Customer> source = new ArrayList<Customer>(totalNumberCustomers);

		for (int i = 1; i <= totalNumberCustomers; i++) {

			Customer user = new Customer();
			user.setLastname(this.user.getLastname());
			user.setUsername(user.getLastname() + "-" + String.format("%03d", i));
			source.add(user);
		}

		repository.save(source);

		Slice<Customer> users = repository.findByLastnameOrderByUsernameAsc(this.user.getLastname(), new PageRequest(1, 5));

		assertThat(users, contains(source.subList(5, 10).toArray()));
	}

	@Test
	public void findFirst2ByOrderByLastnameAsc() {

		Customer user0 = new Customer();
		user0.setLastname("lastname-0");

		Customer user1 = new Customer();
		user1.setLastname("lastname-1");

		Customer user2 = new Customer();
		user2.setLastname("lastname-2");

		// we deliberatly save the items in reverse
		repository.save(Arrays.asList(user2, user1, user0));

		List<Customer> result = repository.findFirst2ByOrderByLastnameAsc();

		assertThat(result.size(), is(2));
		assertThat(result, hasItems(user0, user1));
	}

	@Test
	public void findTop2ByWithSort() {

		Customer user0 = new Customer();
		user0.setLastname("lastname-0");

		Customer user1 = new Customer();
		user1.setLastname("lastname-1");

		Customer user2 = new Customer();
		user2.setLastname("lastname-2");

		// we deliberately save the items in reverse
		repository.save(Arrays.asList(user2, user1, user0));

		List<Customer> resultAsc = repository.findTop2By(new Sort(ASC, "lastname"));

		assertThat(resultAsc.size(), is(2));
		assertThat(resultAsc, hasItems(user0, user1));

		List<Customer> resultDesc = repository.findTop2By(new Sort(DESC, "lastname"));

		assertThat(resultDesc.size(), is(2));
		assertThat(resultDesc, hasItems(user1, user2));
	}

	@Test
	public void findByFirstnameOrLastnameUsingSpEL() {

		Customer first = new Customer();
		first.setLastname("lastname");

		Customer second = new Customer();
		second.setFirstname("firstname");

		Customer third = new Customer();

		repository.save(Arrays.asList(first, second, third));

		Customer reference = new Customer();
		reference.setFirstname("firstname");
		reference.setLastname("lastname");

		Iterable<Customer> users = repository.findByFirstnameOrLastname(reference);

		assertThat(users, is(iterableWithSize(2)));
		assertThat(users, hasItems(first, second));
	}

}
