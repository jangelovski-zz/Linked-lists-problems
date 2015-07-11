/*
You are given two linked lists A and B (SLL or DLL nevermind). The result list should be C = A - B. Here is an example:

A = abcd
B = ab
C = A - B = cd
*/

import java.util.Scanner;

class DLLNode<E> {
	protected E element;
	protected DLLNode<E> pred, succ;

	public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
		this.element = elem;
		this.pred = pred;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}
class DLL<E> {
	private DLLNode<E> first, last;

	public DLL() {
		// Construct an empty SLL
		this.first = null;
		this.last = null;
	}

	public void deleteList() {
		first = null;
		last = null;
	}
	
	public int length() {
		int ret;
		if (first != null) {
			DLLNode<E> tmp = first;
			ret = 1;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		} else
			return 0;
	}

	public DLLNode<E> find(E o) {
		if (first != null) {
			DLLNode<E> tmp = first;
			while (tmp.element != o && tmp.succ != null)
				tmp = tmp.succ;
			if (tmp.element == o) {
				return tmp;
			} else {
				System.out.println("Elementot ne postoi vo listata");
			}
		} else {
			System.out.println("Listata e prazna");
		}
		return first;
	}
	
	public void insertFirst(E o) {
		DLLNode<E> ins = new DLLNode<E>(o, null, first);
		if (first == null)
			last = ins;
		else
			first.pred = ins;
		first = ins;
	}

	public void insertLast(E o) {
		if (first == null)
			insertFirst(o);
		else {
			DLLNode<E> ins = new DLLNode<E>(o, last, null);
			last.succ = ins;
			last = ins;
		}
	}

	public String pecatiListaBezSpace() {
		String ret = new String();
		if (first != null) {
			DLLNode<E> tmp = first;
			ret += tmp;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret += tmp;
			}
		} else
			ret = "Prazna lista!!!";
		return ret;
	}
  	//funkcija koja gi minusira elementite od vtorata lista i vrakja rezultantna lista
	public DLL minus(DLL lista1, DLL lista2){
		
		char[] prva = new char[lista1.length()];
		char[] vtora = new char[lista2.length()];
		DLLNode temp = lista1.first;
		DLLNode temp2= lista2.first;
		int i = 0;
		while(temp != null){
			prva[i] = (char)temp.element;
			temp = temp.succ;
			i++;
		}
		i = 0;
		while(temp2!= null){
			vtora[i] = (char)temp2.element;
			temp2 = temp2.succ;
			i++;
		}
		
		String str1 = new String(prva);
		String str2 = new String(vtora);
		String str3;
		
		if(str1.contains(str2)){
			str3 = str1.replace(str2, "");
			
			char[] chArray = str3.toCharArray();
			lista1.deleteList();
			DLL pom = new DLL();
			for(i = 0; i < chArray.length; i++){
				pom.insertLast(chArray[i]);
			}
			return pom;
		} else return lista1;
	}
	public DLLNode<E> getFirst() {
		return first;
	}

public class IsSubstring {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL<Character> lista1 = new DLL<Character>();
		DLL<Character> lista2 = new DLL<Character>();
		
		Scanner in = new Scanner(System.in);
		String A = in.nextLine();
		String B = in.nextLine();
		
		char[] LA = A.toCharArray();
		char[] LB = B.toCharArray();
		
		for(int i = 0; i < LA.length; i++){
			lista1.insertLast(LA[i]);
		} 
		for(int i = 0; i < LB.length; i++){
			lista2.insertLast(LB[i]);
		} 
		//System.out.println(lista1.pecatiListaBezSpace());
		//System.out.println(lista2.pecatiListaBezSpace());
		lista1 = lista1.minus(lista1, lista2);
		System.out.println(lista1.pecatiListaBezSpace());
	}
}
