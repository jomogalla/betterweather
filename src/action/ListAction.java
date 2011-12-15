package action;

import org.hibernate.Session;
import model.HibernateUtil;
import model.Ide;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List; 
import java.util.Iterator; 


public class ListAction extends ActionSupport{
	
	private List<Ide> ideBeans;

	//Execute gets all the Ides from the DB and stores them in List ideBeans
	@Override
	public String execute() throws Exception {		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		ideBeans = session.createCriteria(Ide.class).list();
		session.getTransaction().commit();
		
		return SUCCESS;		
	}
	
	public List<Ide> getIdeBeans(){
		return ideBeans;
	}
}
