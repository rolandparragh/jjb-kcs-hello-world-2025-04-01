package functionInterfaceExample;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class App {

	public static void main(String[] args) {
		//Java 8-al került bevezetésre
		//@FunctionalInterface annotáció használható, ezzel egyértelműsíthetjuk a felhasználását

		//1. Lambda - név nélküli fv., segítségével megoldhatjuk, hogy kötelező legyen egységbe foglalni
		//minden egyes funkcionalitást.
		//2. Functions - 
		//public interface Function<T, R> { … }
		// T bemeneti tipus
		// R visszatérés

		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		Integer value = nameMap.computeIfAbsent("John",s->s.length());
		System.out.println(value); // 4
		Integer value2 = nameMap.computeIfAbsent("John",String::length);
		System.out.println(value2); // 4
		
		Function<Integer, Double> half = a ->a/2.0;
		System.out.println(half.apply(20)); //10.0
		
		//  'a' változónév helyett lehet bármi
		// -> arrow operator - lambda jelentése legyen
		half = half.andThen(a->3*a);
		System.out.println(half.apply(20)); //30.0 (20/2=10.0*3 = 30.0
		
		Function<Integer, Double> half2 = a->a/2.0;
		half2 = half2.compose(a->3*a);
		System.out.println(half2.apply(5)); //5/2=2.5*3 = 7.5

	}

}
