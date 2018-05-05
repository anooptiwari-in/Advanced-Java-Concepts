import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestAnnotation {

	@MyAnnotation(str="aaa", val=123)
	public void myMethod(){
		
	}
	
	public static void main(String[] args) {
		TestAnnotation ta = new TestAnnotation();
		
		Class c = ta.getClass();

		Constructor[] constrct = c.getConstructors();  // Reflection. RTTI
		
		Method[] methods = c.getMethods();
		for(Method mtd : methods){
			System.out.println(mtd.getName());
		}
		
		Annotation[] annot = methods[1].getAnnotations();
		for(Annotation a : annot){
			System.out.println(a.annotationType().getName());
		}
	}
}
