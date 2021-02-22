package exam03retake01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MailBox {
    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return Collections.unmodifiableList(mails);
    }

    public List<Mail> findByCriteria(String findIt) {
        if (findIt.toLowerCase().startsWith("from:")) {
            return findFrom(findIt);
        }
        if (findIt.toLowerCase().startsWith("to:")) {
            return findTo(findIt);
        }
        return findSubjectOrBody(findIt);
    }

    private List<Mail> findSubjectOrBody(String findIt) {
        return mails
                .stream()
                .filter(mail -> selectSubjectOrBody(mail, findIt))
                .collect(Collectors.toList());
    }

    private boolean selectSubjectOrBody(Mail mail, String findIt) {
        return mail.getSubject().contains(findIt) || mail.getMessage().contains(findIt);
    }

    private List<Mail> findTo(String findIt) {
        String to = findIt.substring(3);
        return mails
                .stream()
                .filter(mail -> selectAddressee(mail, to))
                .collect(Collectors.toList());
    }

    private boolean selectAddressee(Mail mail, String to) {
        for (Contact contact : mail.getTo()) {
            if (contact.getName().equals(to) || contact.getEmail().equals(to)) {
                return true;
            }
        }
        return false;
    }

    private List<Mail> findFrom(String findIt) {
        String from = findIt.substring(5);
        return mails
                .stream()
                .filter(mail -> selectSender(mail, from))
                .collect(Collectors.toList());
    }

    private boolean selectSender(Mail mail, String from) {
        return mail.getFrom().getEmail().equals(from) || mail.getFrom().getName().equals(from);
    }
}
//Egy levelet egy Mail osztály tárol, a következő attribútumokkal: feladó, címzettek, tárgy és szöveg. A feladót és a
// címzetteket egy Contract tárol, melynek két attribútuma van: viselt név és e-mail cím. A MailBox tárolja a leveleket
// egy Mail listában. Ennek legyen egy findByCriteria() metódusa, mely paraméterként egy keresési feltételt vár, és
// leveleket ad vissza.
//
//A keresési feltételek lehetnek:
//
//    from:John Doe vagy from:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet, ahol a feladó
//      neve vagy e-mail címe pontosan a from: után szereplő szöveg
//    to:John Doe vagy to:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet, ahol a címzettek
//      között szerepel olyan, akinek a neve vagy e-mail címe pontosan a to: után szereplő szöveg
//    egyéb esetben: visszaadja az összes olyan levelet, amiben szerepel a tárgyban vagy üzenetben a megadott szó