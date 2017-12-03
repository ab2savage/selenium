package pl.lbu.selenium.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import pl.lbu.selenium.script.GoogleLogic;
import pl.lbu.selenium.selenium.script.Script;

public class HibernateTest extends Script {

	GoogleLogic googleLogic = new GoogleLogic();

	@Test
	public void testHibernate() {

		// insert
		HibernateConfig config = new HibernateConfig();
		config.startSession();

		GoogleHibernatePage googleHibernatePage = new GoogleHibernatePage("Lukasz", "B");
		GoogleHibernatePage googleHibernatePage2 = new GoogleHibernatePage("Wojtek", "S");

		List<Object> objects = new ArrayList<Object>();
		objects.add(googleHibernatePage);
		objects.add(googleHibernatePage2);

		config.addPageToSession(objects);
		config.startTransaction();

		// select
		HibernateConfig config2 = new HibernateConfig();

		Session s = config2.getSession();
		List<?> googleTable = s.createQuery("from GoogleHibernatePage").list();
		for (Iterator<?> iterator = googleTable.iterator(); iterator.hasNext();) {
			GoogleHibernatePage googleHibernatePage3 = (GoogleHibernatePage) iterator.next();
			System.out.print("First Name: " + googleHibernatePage3.getName().toString());
			System.out.print("  Last Name: " + googleHibernatePage3.getSurname().toString());
			googleLogic.searchTextInGoogle(googleHibernatePage3.getSurname().toString());
			break;
		}

	}

}
