package week12.d04;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Clients {
    private Map<String, Client> clients;

    public Clients(Map<String, Client> clients) {
        this.clients = new TreeMap<>(clients);
    }

    public Client findByRegNumber(String regNumber) {
        if (regNumber == null || regNumber.isBlank()) {
            throw new IllegalArgumentException("Registration number is a must!");
        }

        Client result = clients.get(regNumber);
        if (result == null) {
            throw new IllegalArgumentException("There is no this regnumber: " + regNumber);
        }
        return result;
    }

    public List<Client> findByName(String namePart) {
        return clients
                .entrySet()
                .stream()
                .filter(a -> a.getValue() != null)
                .filter(a -> a.getValue().getName().contains(namePart))
                .map(a -> a.getValue())
                .collect(Collectors.toList());
    }
}
//A Client osztály reprezentál egy ügyfelet name és regNumber attribútummal (String). Az második a regisztrációs száma,
// mely egyedileg azonosít egy ügyfelet.  Írj egy Clients osztályt, mely az ügyfeleket tartja nyilván.
// Regisztrációs szám alapján le kell tudni kérdezni egy ügyfelet a findByRegNumber(String) metódussal.
// Dobjon IllegalArgumentException-t, ha nincs. Fontos, hogy nagyon gyors legyen a lekérdezés a regisztrációs szám alapján!
//
// Ezen kívül legyen benne egy List<Client> findByName(String) metódus is, ami pedig névtöredék alapján keres! Ez lehet lassabb.