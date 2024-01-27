package in.co.sunrays.proj4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.proj4.bean.SubjectBean;
import in.co.sunrays.proj4.exception.ApplicationException;
import in.co.sunrays.proj4.exception.DuplicateRecordException;

import in.co.sunrays.proj4.model.SubjectModel;

public class SubjectModelTest {
	 /**
     * Model object to test
     */

    public static SubjectModel model = new SubjectModel();

    /**
     * Main method to call test methods.
     *
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        //testAdd();
          //testDelete();
         //testUpdate();
        //testFindByPK();
        //testSearch();
       
        testList();
       

    }

    /**
     * Tests add a User
     * @throws Exception 
     */
    public static void testAdd() throws Exception {

        try {
        	SubjectBean bean = new SubjectBean();
           // SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");

             //bean.setId(1L);
    
            bean.setName("Maths");
            
            bean.setDescription("Mathemetics");
            bean.setCourseId(4L);
            bean.setCreatedBy("Admin");
        
            long pk = model.add(bean);
            SubjectBean addedbean = model.findByPK(pk);
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
        	SubjectBean bean = new SubjectBean();
            long pk = 3L;
            bean.setId(pk);
            model.delete(bean);
            System.out.println("Test Delete succ" + bean.getId());
            SubjectBean deletedbean = model.findByPK(pk);
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
        	SubjectBean bean = model.findByPK(1L);
           
            bean.setDescription("proJH");
            bean.setName("MSC");
            


            model.update(bean);

            SubjectBean updatedbean = model.findByPK(1L);
          
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
        	SubjectBean bean = new SubjectBean();
            long pk = 2L;
            bean = model.findByPK(pk);
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getName());
          
            System.out.println(bean.getDescription());

        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
    
    public static void testFindByName() throws Exception {
        try {
        	SubjectBean bean = new SubjectBean();
            String name="BCA";
            bean = model.findByName(name);
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getName());
           
            System.out.println(bean.getDescription());

        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }



    /**
     * Tests get Search
     */
    public static void testSearch() {

        try {
        	SubjectBean bean = new SubjectBean();
            List list = new ArrayList();
            //bean.setName("Physics");
            bean.setName("Physics");
           // bean.setId(2L);
            list = model.search(bean, 0, 0);
            if (list.size() < 0) {
                System.out.println("Test Search fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (SubjectBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getDescription());
               
                System.out.println(bean.getName());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getModifiedBy());
              
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
        	SubjectBean bean = new SubjectBean();
            List list = new ArrayList();
            list = model.list(1, 4);
            if (list.size() < 0) {
                System.out.println("Test list fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (SubjectBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getDescription());
                
                System.out.println(bean.getName());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getModifiedBy());

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
