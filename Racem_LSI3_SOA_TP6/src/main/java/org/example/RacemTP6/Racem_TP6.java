package org.example.RacemTP6;
import org.example.entities.Compte;
import org.example.entities.EtatCompte;
import org.example.entities.TypeCompte;
import org.example.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication

@EnableJpaRepositories(basePackages = "org.example.repositories")
@EntityScan(basePackages = "org.example.entities")
@ComponentScan("org.example")
public class Racem_TP6
{
    public static void main(String[] args)
    {
        SpringApplication.run(Racem_TP6.class,args);
    }
    @Bean
    public CommandLineRunner CLR (CompteRepository compteRepository)

    {
        return (args)->
        {
            compteRepository.save(new Compte(null, 200.0, new Date(), TypeCompte.COURANT, EtatCompte.ACTIVE));
            compteRepository.save(new Compte(null, 400.0, new Date(), TypeCompte.EPARGNE, EtatCompte.CREE));
            compteRepository.save(new Compte(null, 9000.0, new Date(), TypeCompte.EPARGNE, EtatCompte.BLOQUE));
            List<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes)
            {
                System.out.println("Solde du compte " + compte.getId() + ": " + compte.getSolde());
            }
        };
    }
}
