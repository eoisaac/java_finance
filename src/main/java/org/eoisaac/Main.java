package org.eoisaac;

import org.eoisaac.config.database.DatabaseSession;
import org.eoisaac.model.Transaction;
import org.eoisaac.model.TransactionType;
import org.eoisaac.views.AppFrame;
import org.hibernate.Session;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        try {
            Session session = DatabaseSession.get();
            try {
                if (session != null) {
                    System.out.println(session.isConnected());

                    // Create a new transaction using the builder
                    Transaction newTransaction = Transaction.builder()
                            .name("Sample Transaction")
                            .type(TransactionType.EXPENSE)
                            .value(100.0f)
                            .entryDate(Instant.now())
                            .build();

                    session.beginTransaction();
                    session.save(newTransaction);
                    session.getTransaction().commit();

                    AppFrame appFrame = new AppFrame();
                    appFrame.setVisible(true);
                } else {
                    System.out.println("Session not created");
                }
            } finally {
                DatabaseSession.close(session);
            }
        } finally {
            DatabaseSession.closeSessionFactory();
        }
    }
}
