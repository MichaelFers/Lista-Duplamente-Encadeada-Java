package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {

	private No<T> primeiro;
	private int tamanho;

	public ListaDuplamenteEncadeada(){
		tamanho = 0;
		primeiro = null;
	}

	public void add(T item){

		No<T> novoNo = new No();
		novoNo.item = item;
		if(eVazio()){
			
			primeiro = novoNo;
			primeiro.ant = null;
			primeiro.prox = null;
			tamanho++;
			
		}else{

			No<T> aux = primeiro;
			No<T> aux2 = null;
			while(aux !=null){		
				aux2 = aux;
				aux = aux.prox;				
			}
			
			novoNo.ant = aux2;
			aux2.prox = novoNo;
			tamanho++;
		}	
	}

	private boolean eVazio(){

		return primeiro == null;
	}

	public String toString(){
		No<T> aux = primeiro;
		String to_string = "";

		while(aux != null){
			to_string += "<- "+aux.item+" -> ";
			aux = aux.prox;

		}
		return to_string;
	}
	
	public int tamanho(){
		return this.tamanho;
	}
	
	public T remover(int posicao){
		if(posicao > this.tamanho || posicao < 0){
			throw new IllegalArgumentException("Erro: posição informada inválida.");
		}else if(posicao == 1){
			No<T> removido = primeiro;
			primeiro = primeiro.prox;
			tamanho--;
			return removido.item;
		}
		No<T> aux = primeiro;
		No<T> aux2 = null;

		int cont = 1;
		while(cont <= posicao){
			aux2 = aux;
			aux = aux.prox;
			cont++;
		}
		No<T> removido = aux2;

		aux2.ant.prox = aux2.prox;
		
		tamanho--;
		return removido.item;
	}
	
	public T pegar(int index){
		
		if(index > this.tamanho || index < 0){
			throw new IllegalArgumentException("Erro: posição informada inválida.");
		}
		
		No<T> aux = primeiro;
		No<T> aux2 = null;
		
		int cont=1;
		while(cont<=index){
			aux2 = aux;
			aux = aux.prox;
			cont++;
		}
		
		return aux2.item;
	}

}
