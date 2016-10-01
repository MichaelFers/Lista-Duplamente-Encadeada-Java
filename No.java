package ListaDuplamenteEncadeada;

public class No<T> {
	
	protected No<T> prox;
	protected No<T> ant;
	T item;
	
	public No(){
		this.prox = this.ant = null;
		this.item = null;
	}
	
	public No(T item){
		this.item = item;
		this.prox = this.ant = null;
	}

}
