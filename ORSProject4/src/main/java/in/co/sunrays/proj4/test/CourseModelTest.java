package in.co.sunrays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.proj4.bean.CourseBean;
import in.co.sunrays.proj4.bean.UserBean;
import in.co.sunrays.proj4.exception.ApplicationException;
import in.co.sunrays.proj4.exception.DuplicateRecordException;
import in.co.sunrays.proj4.exception.RecordNotFoundException;
import in.co.sunrays.proj4.model.CourseModel;


public class CourseModelTest {


	    /**
	     * Model object to test
	     */

	    public static CourseModel model = new CourseModel();

	    /**
	     * Main method to call test methods.
	     *
	     * @param args
	     * @throws Exception 
	     */
	    public static void main(String[] args) throws Exception {
	        // testAdd();
	        //   testDelete();
	         //testUpdate();
	        //testFindByPK();
	      // testSearch();
	       
	        testList();
	       

	    }

	    /**
	     * Tests add a User
	     * @throws Exception 
	     */
	    public static void testAdd() throws Exception {

	        try {
	            CourseBean bean = new CourseBean();
	           // SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");

	             bean.setId(1L);
	     //       bean.setFirstName("shreee");
	       //     bean.setLastName("kumawati1");
	         //   bean.setLogin("abhi1234@g.com");
	          //  bean.setPassword("pass1234");
	          //  bean.setDob(sdf.parse("01-12-1990"));
	          //  bean.setRoleId(1L);
//	            bean.setUnSuccessfulLogin(2);
//	            bean.setGender("Male");
//	            bean.setLastLogin(new Timestamp(new Date().getTime()));
//	            bean.setLock("Yes");
//	            bean.setConfirmPassword("pass1234");
                bean.setName("Btech");
	            bean.setDuration("4 yr");
	            bean.setDescription("p44");
	        
	            long pk = model.add(bean);
	            CourseBean addedbean = model.findByPK(pk);
            System.out.println("Test add succ");
	      
	      
	            if (addedbean == null) {
	                System.out.println("Test add fail");
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }

	    }

	    /**
	     * Tests delete a User
	     */
	    public static void testDelete() {

	        try {
	            CourseBean bean = new CourseBean();
	            long pk = 0L;
	            bean.setId(pk);
	            model.delete(bean);
	            System.out.println("Test Delete succ" + bean.getId());
	            CourseBean deletedbean = model.findByPK(pk);
	            if (deletedbean == null) {
	                System.out.println("Test Delete fail");
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Tests update a User
	     * @throws Exception 
	     */
	    public static void testUpdate() throws Exception {

	        try {
	            CourseBean bean = model.findByPK(1L);
	            bean.setDuration("1 yr");
	            bean.setDescription("proJH");
	            bean.setName("MSC");
	            
//	            bean.setFirstName("cmc limited");
//	            bean.setLastName("pvt ltd");
//	            bean.setLogin("ranjitchoudhary210@gmail.com");
//	            bean.setPassword("658986");

	            model.update(bean);

	            CourseBean updatedbean = model.findByPK(1L);
	          
	                System.out.println("Test Update SUCESS");
	            
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        } catch (DuplicateRecordException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Tests find a User by PK.
	     */
	    public static void testFindByPK() {
	        try {
	            CourseBean bean = new CourseBean();
	            long pk = 2L;
	            bean = model.findByPK(pk);
	            if (bean == null) {
	                System.out.println("Test Find By PK fail");
	            }
	            System.out.println(bean.getId());
	            System.out.println(bean.getName());
	            System.out.println(bean.getDuration());
	            System.out.println(bean.getDescription());
//	            System.out.println(bean.getPassword());
//	            System.out.println(bean.getDob());
//	            System.out.println(bean.getRoleId());
//	            System.out.println(bean.getUnSuccessfulLogin());
//	            System.out.println(bean.getGender());
//	            System.out.println(bean.getLastLogin());
//	            System.out.println(bean.getLock());
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }

	    }
	    
	    public static void testFindByName() throws Exception {
	        try {
	            CourseBean bean = new CourseBean();
	            String name="BCA";
	            bean = model.findByName(name);
	            if (bean == null) {
	                System.out.println("Test Find By PK fail");
	            }
	            System.out.println(bean.getId());
	            System.out.println(bean.getName());
	            System.out.println(bean.getDuration());
	            System.out.println(bean.getDescription());
//	            System.out.println(bean.getPassword());
//	            System.out.println(bean.getDob());
//	            System.out.println(bean.getRoleId());
//	            System.out.println(bean.getUnSuccessfulLogin());
//	            System.out.println(bean.getGender());
//	            System.out.println(bean.getLastLogin());
//	            System.out.println(bean.getLock());
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }

	    }



	    /**
	     * Tests get Search
	     */
	    public static void testSearch() {

	        try {
	            CourseBean bean = new CourseBean();
	            List list = new ArrayList();
	            bean.setName("BE");
	            list = model.search(bean, 0, 0);
	            if (list.size() < 0) {
	                System.out.println("Test Search fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (CourseBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getDescription());
	                System.out.println(bean.getDuration());
	                System.out.println(bean.getName());
	                System.out.println(bean.getCreatedBy());
	                System.out.println(bean.getModifiedBy());
//	                System.out.println(bean.getFirstName());
//	                System.out.println(bean.getLastName());
//	                System.out.println(bean.getLogin());
//	                System.out.println(bean.getPassword());
//	                System.out.println(bean.getDob());
//	                System.out.println(bean.getRoleId());
//	                System.out.println(bean.getUnSuccessfulLogin());
//	                System.out.println(bean.getGender());
//	                System.out.println(bean.getLastLogin());
//	                System.out.println(bean.getLock());
	            }

	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }

	    }

	    /**
	     * Tests get List.
	     */
	    public static void testList() {

	        try {
	            CourseBean bean = new CourseBean();
	            List list = new ArrayList();
	            list = model.list(1, 4);
	            if (list.size() < 0) {
	                System.out.println("Test list fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (CourseBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getDescription());
	                System.out.println(bean.getDuration());
	                System.out.println(bean.getName());
	                System.out.println(bean.getCreatedBy());
	                System.out.println(bean.getModifiedBy());
//	                System.out.println(bean.getFirstName());
//	                System.out.println(bean.getLastName());
//	                System.out.println(bean.getLogin());
//	                System.out.println(bean.getPassword());
//	                System.out.println(bean.getDob());
//	                System.out.println(bean.getRoleId());
//	                System.out.println(bean.getUnSuccessfulLogin());
//	                System.out.println(bean.getGender());
//	                System.out.println(bean.getLastLogin());
//	                System.out.println(bean.getLock());
//	                System.out.println(bean.getMobileNo());
	                System.out.println(bean.getCreatedBy());
	                System.out.println(bean.getModifiedBy());
	                System.out.println(bean.getCreatedDatetime());
	                System.out.println(bean.getModifiedDatetime());
	            }

	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }

}
	
	

	


	
	
	
	





