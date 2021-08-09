import java.awt.Component;
import java.awt.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class Polinoame {

	ArrayList<Monom> polinom = new ArrayList<Monom>();
	ArrayList<MonomR> polinomR = new ArrayList<MonomR>();

	// functie pentru adaugare de monom la un polinom
	public void addMonom(Monom x) {
		polinom.add(x);
	}

	// functie pentru afisarea unui polinom
	String afisarePolinom() {
		String s = new String();

		for (int i = 0; i < this.polinom.size(); i++) {
			if (polinom.get(i).coeficient != 0 && polinom.get(i).coeficient != 1) {
				if (polinom.get(i).grad != 1) {
					if (polinom.get(i).coeficient >= 0 && polinom.get(i).grad == 0) {
						s = s.concat("+" + polinom.get(i).coeficient);
					} else if (polinom.get(i).coeficient >= 0 && polinom.get(i).grad != 0) {
						s = s.concat("+" + polinom.get(i).coeficient + "X^" + polinom.get(i).grad);
					} else if (polinom.get(i).coeficient < 0 && polinom.get(i).grad != 0) {
						s = s.concat(polinom.get(i).coeficient + "X^" + polinom.get(i).grad);
					} else {
						s = s.concat(polinom.get(i).coeficient + "");
					}
				} else {
					if (polinom.get(i).coeficient > 0) {
						s = s.concat("+" + polinom.get(i).coeficient + "X");
					} else {
						s = s.concat(polinom.get(i).coeficient + "X");
					}
				}
			} else if (polinom.get(i).coeficient != 0 && polinom.get(i).coeficient == 1) {
				if (polinom.get(i).grad != 1) {
					if (polinom.get(i).grad == 0) {
						s = s.concat("+" + polinom.get(i).coeficient);
					} else {
						s = s.concat("+" + "X^" + polinom.get(i).grad);
					}
				} else {
					s = s.concat("+X");
				}
			}
		}
		return s;
	}
	
	String afisarePolinomR() {
		String s = new String();

		for (int i = 0; i < this.polinomR.size(); i++) {
			if (polinomR.get(i).coeficientR != 0 && polinomR.get(i).coeficientR != 1) {
				if (polinomR.get(i).grad != 1) {
					if (polinomR.get(i).coeficientR >= 0 && polinomR.get(i).grad == 0) {
						s = s.concat("+" + polinomR.get(i).coeficientR);
					} else if (polinomR.get(i).coeficientR >= 0 && polinomR.get(i).grad != 0) {
						s = s.concat("+" + polinomR.get(i).coeficientR + "X^" + polinomR.get(i).grad);
					} else if (polinomR.get(i).coeficientR < 0 && polinomR.get(i).grad != 0) {
						s = s.concat(polinomR.get(i).coeficientR + "X^" + polinomR.get(i).grad);
					} else {
						s = s.concat(polinomR.get(i).coeficientR + "");
					}
				} else {
					if (polinomR.get(i).coeficientR > 0) {
						s = s.concat("+" + polinomR.get(i).coeficientR + "X");
					} else {
						s = s.concat(polinomR.get(i).coeficientR + "X");
					}
				}
			} else if (polinomR.get(i).coeficientR != 0 && polinomR.get(i).coeficientR == 1) {
				if (polinomR.get(i).grad != 1) {
					if (polinomR.get(i).grad == 0) {
						s = s.concat("+" + polinomR.get(i).coeficientR);
					} else {
						s = s.concat("+" + "X^" + polinomR.get(i).grad);
					}
				} else {
					s = s.concat("+X");
				}
			}
		}
		return s;
	}

	// functie pentru sortarea unui polinom
	public void sortarePolinom() {
		Monom m = new Monom();
		for (int i = 0; i < this.polinom.size() - 1; i++)
			for (int j = i + 1; j < this.polinom.size(); j++) {
				if (this.polinom.get(i).grad < this.polinom.get(j).grad) {
					m.grad = this.polinom.get(i).grad;
					m.coeficient = this.polinom.get(i).coeficient;
					this.polinom.get(i).coeficient = this.polinom.get(j).coeficient;
					this.polinom.get(i).grad = this.polinom.get(j).grad;
					this.polinom.get(j).grad = m.grad;
					this.polinom.get(j).coeficient = m.coeficient;
				}
			}
	}

	// functie pentru adunarea a 2 polinoame
	public void adunarePolinoame(Polinoame p1, Polinoame p2) {
		int i = 0;
		int j = 0;
		while (i < p1.polinom.size() && j < p2.polinom.size()) {
			if (p1.polinom.get(i).grad > p2.polinom.get(j).grad) {
				Monom m = new Monom();
				m.grad = p1.polinom.get(i).grad;
				m.coeficient = p1.polinom.get(i).coeficient;
				this.polinom.add(m);
				i++;
			} else if (p1.polinom.get(i).grad < p2.polinom.get(j).grad) {
				Monom m = new Monom();
				m.grad = p2.polinom.get(j).grad;
				m.coeficient = p2.polinom.get(j).coeficient;
				this.polinom.add(m);
				j++;
			} else {
				Monom m = new Monom();
				m.grad = p1.polinom.get(i).grad;
				m.coeficient = p2.polinom.get(j).coeficient + p1.polinom.get(i).coeficient;
				this.polinom.add(m);
				j++;
				i++;
			}
		}
		while (j < p2.polinom.size()) {
			Monom m = new Monom();
			m.grad = p2.polinom.get(j).grad;
			m.coeficient = p2.polinom.get(j).coeficient;
			this.polinom.add(m);
			j++;
		}
		while (i < p1.polinom.size()) {
			Monom m = new Monom();
			m.grad = p1.polinom.get(i).grad;
			m.coeficient = p1.polinom.get(i).coeficient;
			this.polinom.add(m);
			i++;
		}
	}

	// functie pentru scaderea a 2 polinoame
	public void scaderePolinoame(Polinoame p1, Polinoame p2) {
		int i = 0;
		int j = 0;
		while (i < p1.polinom.size() && j < p2.polinom.size()) {
			if (p1.polinom.get(i).grad > p2.polinom.get(j).grad) {
				Monom m = new Monom();
				m.grad = p1.polinom.get(i).grad;
				m.coeficient = p1.polinom.get(i).coeficient;
				this.polinom.add(m);
				i++;
			} else if (p1.polinom.get(i).grad < p2.polinom.get(j).grad) {
				Monom m = new Monom();
				m.grad = p2.polinom.get(j).grad;
				m.coeficient = -p2.polinom.get(j).coeficient;
				this.polinom.add(m);
				j++;
			} else {
				Monom m = new Monom();
				m.grad = p1.polinom.get(i).grad;
				m.coeficient = p1.polinom.get(i).coeficient - p2.polinom.get(j).coeficient;
				this.polinom.add(m);
				j++;
				i++;
			}
		}
		while (j < p2.polinom.size()) {
			Monom m = new Monom();
			m.grad = p2.polinom.get(j).grad;
			m.coeficient = -p2.polinom.get(j).coeficient;
			this.polinom.add(m);
			j++;
		}
		while (i < p1.polinom.size()) {
			Monom m = new Monom();
			m.grad = p1.polinom.get(i).grad;
			m.coeficient = p1.polinom.get(i).coeficient;
			this.polinom.add(m);
			i++;
		}
	}

	// functie pentru inmultirea a 2 polinoame
	public void inmultirePolinoame(Polinoame p1, Polinoame p2) {
		for (int i = 0; i < p1.polinom.size(); i++)
			for (int j = 0; j < p2.polinom.size(); j++) {
				Monom m = new Monom();
				int ok = 0;
				m.grad = p1.polinom.get(i).grad + p2.polinom.get(j).grad;
				m.coeficient = p1.polinom.get(i).coeficient * p2.polinom.get(j).coeficient;
				for (int k = 0; k < this.polinom.size(); k++) {
					if (this.polinom.get(k).grad == m.grad) {
						this.polinom.get(k).coeficient += m.coeficient;
						ok = 1;
					}
				}
				if (ok == 0) {
					this.polinom.add(m);
				}
			}

	}

	// functie pentru derivarea unui polinom
	public void derivarePolinom() {
		for (int i = 0; i < this.polinom.size(); i++) {
			if (this.polinom.get(i).grad > 0) {
				this.polinom.get(i).coeficient = (this.polinom.get(i).coeficient * this.polinom.get(i).grad);
				this.polinom.get(i).grad = this.polinom.get(i).grad - 1;
			} else {
				this.polinom.get(i).setCoeficient(0);
				this.polinom.get(i).setGrad(0);
			}
		}
	}

	// functie pentru integrarea unui polinom
	public void integrarePolinom(Polinoame p) {
		for (int i = 0; i < this.polinom.size(); i++) {
			MonomR m = new MonomR();
			m.coeficientR = this.polinom.get(i).coeficient;
			m.grad = this.polinom.get(i).grad;
			p.polinomR.add(m);
		}
		for (int j = 0; j < p.polinomR.size(); j++) {
			p.polinomR.get(j).coeficientR = (p.polinomR.get(j).coeficientR / (p.polinomR.get(j).grad + 1));
			p.polinomR.get(j).grad = p.polinomR.get(j).grad + 1;
		}
	}
}
