package action;

import org.hibernate.Session;
import model.HibernateUtil;
import model.Ide;
import com.opensymphony.xwork2.ActionSupport;

public class InsertAction extends ActionSupport {
		
	private Ide ideBean;	

	@Override
	public String execute() throws Exception {		
		//Saves ideBean from the stack into the database
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(ideBean);
        session.getTransaction().commit();
		
		return SUCCESS;		
	}

	//solved
	//null pointer exception thrown from validate, happens when localhost:8080/devironments/insert.action is called
	//by entering the above url in a new window. 
	//My deduction: ideBean was never put on the new stack by insert.jsp when called this way,
	//if we just check to see if it is null the validate returns no errors. And passes a null
	// ideBean back to insert.jsp, so we just make one and pretend nothing ever happened ಠ_ಠ
	
	public void validate(){	
		if(ideBean == null){
			Ide ideBean = new Ide();
			ideBean.setOs("");
			ideBean.setOs_version("");
			ideBean.setNotes("");
			addFieldError("ideBean.os", "");	
		}
		else{
			if (ideBean.getOs().length() == 0 ){	 
				addFieldError( "ideBean.os", "os is required." );
			}				
			if (ideBean.getOs_version().length() == 0 ){	
				addFieldError( "ideBean.os_version", "os version is required." );
			}	
		}
	}
		
	public Ide getIdeBean() {		
		return ideBean;		
	}
	
	public void setIdeBean(Ide ideBean) {		
		this.ideBean = ideBean;		
	}
}
