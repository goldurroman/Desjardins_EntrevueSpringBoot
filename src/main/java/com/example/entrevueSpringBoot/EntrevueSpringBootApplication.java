package com.example.entrevueSpringBoot;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import java.util.Arrays;
import java.util.List;
import org.hibernate.mapping.Array;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.example.entrevueSpringBoot.repository.FilmRepository;

//@ComponentScan("repository")
//@SpringBootApplication(scanBasePackages = "repository")
@SpringBootApplication()
public class EntrevueSpringBootApplication {

	public static void main(String[] args) {
           // ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(EntrevueSpringBootApplication.class, args);
                
//            FilmRepository filmRepository =configurableApplicationContext.getBean(FilmRepository.class);
//            
//            Film film2 = new Film(new Long(2), "Titanic", "Le film est basé sur le récit du naufrage du RMS Titanic");
//            Acteur leo = new Acteur(new Long(3), "Leonardo", "DiCaprio", film2);
//            Acteur kate = new Acteur(new Long(4),"Kate", "Winslet", film2);
//            List<Acteur> acteurs = Arrays.asList(leo, kate);
//            film2.setActeurs(acteurs);
//            filmRepository.save(film2);
	}

}
