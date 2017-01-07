package stabla;

import org.svetovid.Svetovid;
import sun.misc.OSEnvironment;

import java.util.LinkedList;
import java.util.List;

// Konkretno stablo koje sadrzi Osobe
// Moze imati proizvoljno ime, ali ga treba promeniti u glavnom programu
// na adekatnim mestima
class BinaryTree {
	protected static class Node {
		Osoba info;
		Node left;
		Node right;
	}

	private Node root;

	public Osoba find(final Osoba o) {
		return root == null ? null : find(root, o);
	}

	protected Osoba find(final Node node, final Osoba o) {
		if(node == null)
			return null;

		if(node.info.equals(o))
			return node.info;

		final Osoba fndLeft = find(node.left, o);
		final Osoba fndRight = find(node.right, o);

		return fndLeft == null ? fndRight : fndLeft;
	}

	protected Node findNode(final Node node, final Osoba o) {
		if(node == null)
			return null;

		if(node.info.equals(o))
			return node;

		final Node fndLeft = findNode(node.left, o);
		final Node fndRight = findNode(node.right, o);

		return fndLeft == null ? fndRight : fndLeft;

	}

	// methods
	public int getDepth() {
		return root == null ? -1 : getDepth(root);
	}

	protected static int getDepth(final Node node) {
		int leftDepth = -1;
		final Node left = node.left;

		if(left != null)
			leftDepth = getDepth(left);

		int rightDepth = -1;
		final Node right = node.right;
		if(right != null)
			rightDepth = getDepth(right);

		if(leftDepth > rightDepth)
			return 1 + leftDepth;
		else
			return 1 + rightDepth;
	}

	private class OsobaInfo {
		public double plata;
		public int brPlata;
	}

	public double prosecnaPlata() {
		final OsobaInfo inf = new OsobaInfo();
		prosecnaPlata(root, inf);

		return root == null ? 0.0 : inf.plata / inf.brPlata;
	}

	protected static void prosecnaPlata(final Node node, final OsobaInfo inf) {
		if(node != null) {
			inf.plata += node.info.getPlata();
			inf.brPlata++;
			prosecnaPlata(node.left, inf);
			prosecnaPlata(node.right, inf);
		}
	}

	public Osoba osobaSaNajvecomPlatom() {
		if(root == null)
			return null;


		return osobaSaNajvecomPlatom(root, root.info);
	}

	protected static Osoba osobaSaNajvecomPlatom(final Node node, Osoba max) {
		if(node == null)
			return max;

		Osoba currMax = max;
		if(node.info.getPlata() > max.getPlata()) {
			currMax = node.info;
		}

		Osoba maxLeft = osobaSaNajvecomPlatom(node.left, currMax);
		Osoba maxRight = osobaSaNajvecomPlatom(node.right, currMax);

		return maxLeft.getPlata() > maxRight.getPlata() ? maxLeft : maxRight;
	}

	public List<Osoba> sviPodredjeni(final Osoba o) {
		final List<Osoba> result = new LinkedList<Osoba>();
		final Node found = findNode(root, o);
		sviPodredjeni(found, result);
		result.remove(0);

		return result;
	}

	protected static void sviPodredjeni(final Node node, final List<Osoba> list) {
		if(node != null) {
			list.add(node.info);
			sviPodredjeni(node.left, list);
			sviPodredjeni(node.right, list);
		}
	}

	public List<Osoba> sviNadredjeni(final Osoba o) {
		final List<Osoba> result = new LinkedList<Osoba>();
		sviNadredjeni(root, o, result);

		// dodaj direktora
		result.remove(0);
		result.add(root.info);

		return result;
	}

	protected static boolean sviNadredjeni(final Node node, final Osoba o, final List<Osoba> list) {
		if(node == null)
			return false;

		if(node.info.equals(o))
			return true;

		if(sviNadredjeni(node.left, o, list)) {
			list.add(node.left.info);
			return true;
		}

		if(sviNadredjeni(node.right, o, list)) {
			list.add(node.right.info);
			return true;
		}

		return false;
	}

}

// Glavna klasa
public class MojeStablo {

	// Glavni program
	public static void main(String[] args) {

		// Napravimo pomocni objekat za ucitavanje i ispisivanje
		TreeIO<BinaryTree> io = new TreeIO<>(BinaryTree.class);

		// Procitamo stablo iz fajla
		BinaryTree stablo = io.read(Svetovid.in("Osobe.txt"));

		// Ispisemo ucitano stablo
		io.print(Svetovid.out, stablo);

		System.out.println("Prosecna plata: " + stablo.prosecnaPlata());
		System.out.println("Osoba sa najvecom platom: " + stablo.osobaSaNajvecomPlatom());

		final List<Osoba> nadredjeni = stablo.sviNadredjeni(new Osoba("Strahinja", "Strahimirovic", 21976));
		for(final Osoba o : nadredjeni)
			System.out.print(o + " ");

		System.out.println();
		System.out.println("Nadjen: " + stablo.find(new Osoba("Strahinja", "Strahimirovic", 21976)));

		final List<Osoba> podredjeni = stablo.sviPodredjeni(new Osoba("Strahinja", "Strahimirovic", 21976));
		for(final Osoba o : podredjeni)
			System.out.print(o + " ");

	}
}
