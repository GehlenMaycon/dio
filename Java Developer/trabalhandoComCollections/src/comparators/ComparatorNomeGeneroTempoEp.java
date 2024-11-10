package comparators;

import classes.Serie;

import java.util.Comparator;

public class ComparatorNomeGeneroTempoEp implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        if(nome != 0)
            return nome;
        if(genero !=0)
            return genero;
        return s1.getTempoEp().compareTo(s2.getTempoEp());
    }
}
