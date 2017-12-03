package pl.lbu.selenium.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	private Configuration configuration = new Configuration();
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	HibernateConfig() {
		startSession();
	}

	public Session startSession() {
		configuration.configure("/hibernate/config/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public Session getSession() {
		return session;
	}

	public <T> void addPageToSession(List<Object> objects) {

		for (Object object : objects) {
			session.save(object);
		}

	}

	public void startTransaction() {

		transaction.commit();

		closeSession();
	}

	private void closeSession() {
		session.close();
		sessionFactory.close();
	}

}
