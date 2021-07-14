package com.fundamentalsplatzi.springboot.fundamentals;

import com.fundamentalsplatzi.springboot.fundamentals.bean.MyBean;
import com.fundamentalsplatzi.springboot.fundamentals.bean.MyBeanWithDependency;
import com.fundamentalsplatzi.springboot.fundamentals.bean.MyBeanWithProperties;
import com.fundamentalsplatzi.springboot.fundamentals.component.ComponentDependency;
import com.fundamentalsplatzi.springboot.fundamentals.entity.User;
import com.fundamentalsplatzi.springboot.fundamentals.pojo.UserPojo;
import com.fundamentalsplatzi.springboot.fundamentals.repository.UserRepository;
import com.fundamentalsplatzi.springboot.fundamentals.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentalsApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentalsApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserService userService;

	private UserRepository userRepository;

	public FundamentalsApplication(@Qualifier("componentImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository, UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		//examplesclassbefore();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional1@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1, test2, test3, test4);

		try {
			userService.saveTransactional(users);
		} catch(Exception e) {
			LOGGER.error("This is an exception inside the transactional method" + e);
		}
		userService.getAllUsers().stream().forEach(user -> LOGGER.info("this is a user inside the transactional method " + user));
	}

	private void getInformationJpqlFromUser(){
		/*LOGGER.info("User with method findByUserEmail" +
				userRepository.findByUserEmail("julie@domian.com").orElseThrow(()-> new RuntimeException("User not found")));

		userRepository.findAndSort("user", Sort.by("id").descending()).stream().forEach(user -> LOGGER.info("User with sort method " + user));

		userRepository.findByName("John").stream().forEach(user -> LOGGER.info("User with query method " + user));

		LOGGER.info("User with query method findByEmailAndName" + userRepository.findByEmailAndName("daniela@domian.com", "Daniela").orElseThrow(() -> new RuntimeException("User not found")));

		userRepository.findByNameLike("%u%").stream().forEach(user -> LOGGER.info("User FindByNameLike " + user));

		userRepository.findByNameOrEmail(null, "user10@domian.com").stream().forEach(user -> LOGGER.info("User FindByNameOrEmail " + user));*/

		userRepository.findByBirthDateBetween(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 4,2)).stream().forEach(user -> LOGGER.info("User with date interval: " + user));

		userRepository.findByNameLikeOrderByIdDesc("%user%").stream().forEach(user -> LOGGER.info("User found with like and organized" + user));

		userRepository.findByNameContainingOrderByIdDesc("John").stream().forEach(user -> LOGGER.info("User found with containing and organized" + user));

		LOGGER.info("The user from the named parameter is: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 07, 21), "daniela@domian.com")
				.orElseThrow(() ->new RuntimeException("Didnt find thr user from the named parameter")));

	}

	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domian.com", LocalDate.of(2021, 03, 20));
		User user2 = new User("Julie", "julie@domian.com", LocalDate.of(2021, 05, 21));
		User user3 = new User("Daniela", "daniela@domian.com", LocalDate.of(2021, 07, 21));
		User user4 = new User("user4", "user4@domian.com", LocalDate.of(2021, 07, 7));
		User user5 = new User("user5", "user5@domian.com", LocalDate.of(2021, 11, 11));
		User user6 = new User("user6", "user6@domian.com", LocalDate.of(2021, 2, 25));
		User user7 = new User("user7", "user7@domian.com", LocalDate.of(2021, 3, 11));
		User user8 = new User("user8", "user8@domian.com", LocalDate.of(2021, 4, 12));
		User user9 = new User("user9", "user9@domian.com", LocalDate.of(2021, 5, 22));
		User user10 = new User("user10", "user10@domian.com", LocalDate.of(2021, 8, 3));
		User user11 = new User("user11", "user11@domian.com", LocalDate.of(2021, 1, 12));
		User user12 = new User("user12", "user12@domian.com", LocalDate.of(2021, 2, 2));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		list.stream().forEach(userRepository::save);
	}

	private void examplesclassbefore() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());

		try {
			int value = 10/0;
			LOGGER.debug("My value:" + value);
		} catch (Exception e) {
			LOGGER.error("this is an error dividing by 0" + e.getMessage());
		}
	}
}
