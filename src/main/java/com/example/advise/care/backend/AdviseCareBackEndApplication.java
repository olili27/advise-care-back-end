package com.example.advise.care.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdviseCareBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdviseCareBackEndApplication.class, args);
	}

}

/*
TODO
0.set up the project structure -------
1.design the data models to be used -----------
2. connect the app to the database ----------
3. design the data transfer objects to be used --------
4. write logic etc
- patient sign up -------------
- user login --------------
- create a post
- get all posts based on field
- forgot password  -> 1. send email ----- -> 2. reset password ------
- edit profile -> name, speciality, picture,
-
-> " messaging <-"
 */
