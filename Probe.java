import java.lang.reflect.*;
import java.util.Scanner;
class Probe
{
    static Scanner sc;
    static Value V =new Value();
    public static void main(String a[])
    {   
        a[0]=a[0].replace(".class","");
        a[0]=a[0].replace(".java","");
        try 
        {
                 Class cls = Class.forName(a[0]);
        
              
                 /* returns the array of Method objects representing the public 
                    methods of this class */
                 Method m[] = cls.getDeclaredMethods();
                 Field f[] = cls.getDeclaredFields();
                Constructor c[] = cls.getDeclaredConstructors();
                Parameter p[];
                        
                 
               
        
                 System.out.println("===============================\n-Fields- \n------");
                 for(int i = 0; i < f.length; i++) 
                    System.out.println(f[i]);
        
                 System.out.println("[press any key]");
                 System.in.read();        

                 System.out.println("=================================\n-Constructors\n------------");
                 for(int i = 0; i < c.length; i++) 
                 {
                    System.out.println(c[i]);
                    p=c[i].getParameters();
                    for(int j=0;j< p.length;j++)
                        System.out.println("  \t\t"+ p[j].getName()+" ("+p[j].getType()+")");
                 }

                 System.out.println("[press any key]");
                 System.in.read();        

                 System.out.println("================================\n-Methods-\n------- ");
                 for(int i = 0; i < m.length; i++) 
                 {
                    System.out.println("\n*"+m[i]+": ");
                    System.out.println("\tReturn Type: "+m[i].getReturnType()+"\n\tFunction Name: "+m[i].getName()+"\n\t[Parameters: ]");
                    p=m[i].getParameters();
                    for(int j=0;j< p.length;j++)
                        System.out.println("  \t\t"+ p[j].getName()+" ("+p[j].getType()+")");
                }
                     System.out.println("\n***************************************************************************");

                 System.out.println("[press any key]");
                 System.in.read();        

                sc= new Scanner(System.in);
                char s;int C;

                Object MODclass = c[0].newInstance();                    
                while(true)
                {
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    for(int i = 0; i < m.length; i++) 
                    {   
                        System.out.print("\n("+i+"):"+" "+m[i].getName()+" ( ");
                        p=m[i].getParameters();
                        for(int j=0;j< p.length;j++)
                            System.out.print(p[j].getType()+" "+ p[j].getName()+", ");
                        System.out.print(" )");
                     }
                     System.out.println("\n(x): [exit]");

                    
                    System.out.print("\n\nSelect method (no.): ");
                    s=sc.next().charAt(0);
                    if(s=='x') break;
                    C=(int)s-48;
                    p=m[C].getParameters();
                    
                    switch(p.length)
                    {
                        case 0: System.out.println("--OUTPUT---------------------------------");
                                System.out.println(m[C].invoke(MODclass));
                                break;
                        case 1: 
                                System.out.print("\nEnter "+p[0].getName()+": ");
                                get(p[0].getType().toString(),0);
                                System.out.println("--OUTPUT---------------------------------");
                                System.out.println( (m[C].invoke(MODclass,V.a)) );
                                break;
                        case 2: 
                                System.out.print("\nEnter "+p[0].getName()+": ");
                                get(p[0].getType().toString(),0);

                                System.out.print("\nEnter "+p[1].getName()+": ");
                                get(p[1].getType().toString(),1);

                                System.out.println("--OUTPUT---------------------------------");
                                System.out.println( (m[C].invoke(MODclass,V.a,V.b)) );
                                break;
                        case 3: 
                                System.out.print("\nEnter "+p[0].getName()+": ");
                                get(p[0].getType().toString(),0);

                                System.out.print("\nEnter "+p[1].getName()+": ");
                                get(p[1].getType().toString(),1);

                                System.out.print("\nEnter "+p[2].getName()+": ");
                                get(p[2].getType().toString(),2);

                                System.out.println("--OUTPUT---------------------------------");
                                System.out.println( (m[C].invoke(MODclass,V.a,V.b,V.c)) );
                                break;
                        case 4: 
                                System.out.print("\nEnter "+p[0].getName()+": ");
                                get(p[0].getType().toString(),0);

                                System.out.print("\nEnter "+p[1].getName()+": ");
                                get(p[1].getType().toString(),1);

                                System.out.print("\nEnter "+p[2].getName()+": ");
                                get(p[2].getType().toString(),2);

                                System.out.print("\nEnter "+p[3].getName()+": ");
                                get(p[3].getType().toString(),3);

                                System.out.println("--OUTPUT---------------------------------");
                                System.out.println( (m[C].invoke(MODclass,V.a,V.b,V.c,V.d)) );
                                break;
                    }
                    System.out.println("-----------------------------------------\n[press any key]");
                    System.in.read();

                }



            
         } 
         catch (Exception e) 
         {       System.out.println("Exception: " + e);      }
    }

    static void get(String type,int index)
    {
            switch(type)
            {
                case "int": switch(index)
                           {
                                case 0: V.a=Integer.parseInt(sc.next()); break;
                                case 1: V.b=Integer.parseInt(sc.next()); break;
                                case 2: V.c=Integer.parseInt(sc.next()); break;
                                case 3: V.d=Integer.parseInt(sc.next()); break;
                           }
                            break;
                case "float": switch(index)
                              {
                                case 0: V.a=Float.parseFloat(sc.next()); break;
                                case 1: V.b=Float.parseFloat(sc.next()); break;
                                case 2: V.c=Float.parseFloat(sc.next()); break;
                                case 3: V.d=Float.parseFloat(sc.next()); break;
                              }
                            break;
                case "double": switch(index)
                               {
                                case 0: V.a=Double.parseDouble(sc.next()); break;
                                case 1: V.b=Double.parseDouble(sc.next()); break;
                                case 2: V.c=Double.parseDouble(sc.next()); break;
                                case 3: V.d=Double.parseDouble(sc.next()); break;
                               }
                            break;
                case "class java.lang.String":
    
                                        switch(index)
                                         {
                                            case 0: V.a=(sc.next()); break;
                                            case 1: V.b=(sc.next()); break;
                                            case 2: V.c=(sc.next()); break;
                                            case 3: V.d=(sc.next()); break;
                                         }
                            break;
            }
    }


}





 class Value<T>
{   
     T a,b,c,d;
     
    
}