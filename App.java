package arvore;

public class App {

	public static void main(String[] args) {
		Arvore arvore = new Arvore(new Elemento(10));
		arvore.inserir(new Elemento(5));
		arvore.inserir(new Elemento(1));
		arvore.inserir(new Elemento(3));
		arvore.inserir(new Elemento(15));
		arvore.inserir(new Elemento(12));
		arvore.inserir(new Elemento(18));
		
		
		System.out.println("Em Ordem ");
		arvore.emOrdem();
		
		
		
	}

}
