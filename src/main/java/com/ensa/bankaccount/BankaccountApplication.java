package com.ensa.bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.ensa.bankaccount.service.AccountService;
import com.ensa.bankaccount.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BankaccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankaccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService, CustomerService customerService) {
        return args -> {
            try {
                log.info("Données de test chargées avec succès !");
                log.info("Vous pouvez maintenant tester l'application avec les comptes suivants :");
                log.info("1. John Doe (ID: 1) - Solde: 1000.0");
                log.info("2. Jane Smith (ID: 2) - Solde: 2500.0");
                log.info("3. Alice Johnson (ID: 3) - Solde: 500.0");
            } catch (Exception e) {
                log.error("Erreur lors du chargement des données de test : " + e.getMessage());
            }
        };
    }
}
