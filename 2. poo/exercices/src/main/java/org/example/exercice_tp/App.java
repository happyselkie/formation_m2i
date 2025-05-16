package org.example.exercice_tp;

public class App {

    Stylo stylo1 = new Stylo("42GH1", "Bic", 3.3, "bleu");
    Stylo stylo2 = new Stylo("42GH2", "Bic", 3.2, "noir");

    Ramette ramette1 = new Ramette("64JK1", "Ramram", 2.5, 0.5);
    Ramette ramette2 = new Ramette("64JK1", "Ramram", 2.6, 0.6);

    Bulk styloBulk = new Bulk("42SB41", stylo1, 10, 5);
    Bulk rametteBulk = new Bulk("64RB24", ramette1, 10, 5);

    Customer toto = new Customer("Toto");
    Customer tata = new Customer("Tata");
}
