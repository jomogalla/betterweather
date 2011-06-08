package action;

import org.hibernate.Session;
import model.HibernateUtil;
import model.Parameters;
import model.City;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class WeatherAction extends ActionSupport {
		
	private Parameters parametersBean;
	private List<City> cityBeans;	

	@Override
	public String execute() throws Exception {		
		//Saves ideBean from the stack into the database
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(ideBean);
//        session.getTransaction().commit();
//		
		return SUCCESS;		
	}

	//solved
	//null pointer exception thrown from validate, happens when localhost:8080/devironments/insert.action is called
	//by entering the above url in a new window. 
	//My deduction: ideBean was never put on the new stack by insert.jsp when called this way,
	//if we just check to see if it is null the validate returns no errors. And passes a null
	// ideBean back to insert.jsp, so we just make one and pretend nothing ever happened ಠ_ಠ
	
	public void validate(){			//validation needs to be fixed
		if (parametersBean.getZipCode() == 0 ){	 
			addFieldError( "parametersBean.zipCode", "zipcode is required." );
		}				
		if (parametersBean.getRadius() == 0 ){	
			addFieldError( "parametersBean.radius", "radius is required." );
		}	
	}
		
	public Parameters getParameters() {		
		return parametersBean;		
	}
	
	public void setParametersBean(Parameters parametersBean) {		
		this.parametersBean = parametersBean;		
	}
}
