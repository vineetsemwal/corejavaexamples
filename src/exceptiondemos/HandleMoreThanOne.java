package exceptiondemos;


public class HandleMoreThanOne {

    public static void main(String[]args){
        HandleMoreThanOne demo=new HandleMoreThanOne();
        demo.display(6);

    }

    public void display(int index){
        //opened a file
    	try {
            Product store[] = new Product[10];
            store[0] = new Product("p1", "galaxy");
            store[1] = new Product("p2", "nokia");
            Product fetched=store[index];
            String id=fetched.getId();
            String name=fetched.getName();
            System.out.println(id+" "+name);
           
        }
    	
    
        catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("index your provided is out of range, index="+index);   
   
        }
        catch (NullPointerException exception){
        	exception.printStackTrace();
            System.out.println("element does not exist in the store at index="+index);
        }

        catch (Exception e){
            System.out.println("some problem occurred");
        }
        //
       // finally is always executed and is mstly used at places to 
       // close resources like file handles or socket
        finally {
        //closing or releasing resource here because this always be executed
        System.out.println("i will always get executed");	
        }
        
    }
}
