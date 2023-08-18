package org.eoisaac;


import org.eoisaac.database.DatabaseSession;
import org.eoisaac.views.AppFrame;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        try {
            Session session = DatabaseSession.get();
            try {
                if (session != null) {
                    System.out.println(session.isConnected());

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
