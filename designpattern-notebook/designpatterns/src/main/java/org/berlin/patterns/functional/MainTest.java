package org.berlin.patterns.functional;

public class MainTest {

	private static final Closure<String> FUNCTOR_DESTOYER;
	static {
		FUNCTOR_DESTOYER = new Closure<String>() {
			@Override
	        public void execute(final String lastMessage) {
				System.out.println("WE ARE READY, DESTROY ALL OF THE APPS :: msg="+lastMessage);
	        }		
		};
	}
	
	public static void main(final String [] args) {		
		destroy(FUNCTOR_DESTOYER);
	}	
	
	public static void destroy(final Closure<String> functor) {
		functor.execute("msg1");
		functor.execute("msg2");
	}
}
