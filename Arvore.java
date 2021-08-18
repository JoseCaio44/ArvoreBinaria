package arvore;

public class Arvore {

	private Elemento elemento;
	private Arvore direita;
	private Arvore esquerda;
	

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Arvore getDireita() {
		return direita;
	}

	public void setDireita(Arvore dir) {
		this.direita = dir;
	}

	public Arvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Arvore esq) {
		this.esquerda = esq;
	}
	
	public boolean isEmpty() {
		return (this.elemento == null);
	}
	
	public Arvore() {
		super();
		this.elemento = null;
		this.direita = null;
		this.esquerda = null;
	}
	
	public Arvore(Elemento elemento) {
		super();
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		
	}
	
	public void preOrdem() {
		if(!isEmpty()) {
			System.out.println(this.elemento.getValor() + "  ");
			if(this.esquerda != null) {
				this.esquerda.preOrdem();
			}
			if(this.direita != null) {
				this.direita.preOrdem();
			}
		}
	}
	
	public void posOrdem() {
		if(!isEmpty()) {
			if(this.direita != null) {
				this.direita.posOrdem();
			}
			if(this.esquerda != null) {
				this.esquerda.posOrdem();
			}
			System.out.println(this.elemento.getValor() + "  ");
		}
	}
	
	public void emOrdem() {
		if(!isEmpty()) {
			if(this.esquerda != null) {
				this.esquerda.emOrdem();
			}
			System.out.println(this.elemento.getValor() + "  ");
			if(this.direita != null) {
				this.direita.emOrdem();
			}
		}
	}
	
	public void inserir(Elemento novo) {
		if(isEmpty()) {
			this.elemento = novo;
		}else {
			Arvore novaArvore = new Arvore(novo);
			if ( novo.getValor() < this.elemento.getValor()) { 
				if(this.esquerda == null) {  
					this.esquerda = novaArvore;
					
				}else {
					this.esquerda.inserir(novo);
				}
			}else if ( novo.getValor() > this.elemento.getValor()) { 
				if(this.direita == null) {  
					this.direita = novaArvore;
				}else {
					this.direita.inserir(novo);

				}
			}
		}
	}
	
	public boolean busca(int valor) {

		if(isEmpty()) {
			return false;
		}
		if(this.elemento.getValor() == valor){
			return true;
		}else {
			if(valor < this.elemento.getValor()) {
				if(this.esquerda == null) {
					return false;
				}else {
					return this.esquerda.busca(valor);
				}
			}else if(valor > this.elemento.getValor()) {
				if(this.direita == null) {
					return false;
				}else {
					return this.direita.busca(valor);
		}
			}
		}
		return true;
	}
	
		public Arvore remover(Elemento elemento){
		
			if (this.elemento.getValor() == elemento.getValor()){
			
				if (this.direita == null && this.esquerda == null){
					return null;
				}
				else{
				
					if (this.esquerda != null && this.direita == null){
					    return this.esquerda;	
					}
					else if (this.direita != null && this.esquerda == null){
						return this.direita;
					}
					else{
	
						Arvore aux = this.esquerda;
						while (aux.direita != null){ 
							aux = aux.direita;
						}
						this.elemento = aux.getElemento();                      
						aux.setElemento(elemento);       
						this.esquerda = esquerda.remover(elemento);
					}
				}
			}
			else if (elemento.getValor() < this.elemento.getValor()){
			
				this.esquerda = this.esquerda.remover(elemento);
			}
			else if (elemento.getValor() > this.elemento.getValor()){
				
				this.direita = this.direita.remover(elemento);
			}
			return this;
		}	
	
}
