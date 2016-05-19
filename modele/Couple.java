package modele;

public class Couple<T,S> {
	private T premier;
	private S deuxieme;
	
	public Couple(T t, S s){
		premier = t;
		deuxieme = s;
	}
	
	public T getPremier(){
		return premier;
	}
	
	public S getDeuxieme(){
		return deuxieme;
	}
	
	@Override
	public boolean equals(Object o){
		boolean rep = false;
		try{
			Couple<T,S> other = (Couple<T,S>)o;
			rep = other.getPremier().equals(premier) && other.getDeuxieme().equals(deuxieme);
		}catch(Exception e){
			
		}
		return rep;
	}
	
	public String toString(){
		return premier+" "+deuxieme;
	}
}
