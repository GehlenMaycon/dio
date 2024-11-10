import br.edu.dio.desafio.dominio.Bootcamp;
import br.edu.dio.desafio.dominio.Curso;
import br.edu.dio.desafio.dominio.Dev;
import br.edu.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("desc Curso Java");
        curso1.setCargaHoraria(76);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descricao Mentoria de Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("BootCamp Java");
        bootcamp.setDescricao("Descricao bootcamp Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria);

        Dev devMaycon = new Dev();
        devMaycon.setNome("Maycon");
        devMaycon.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos Maycon: "+devMaycon.getConteudosInscritos());
        devMaycon.progredir();
        System.out.println("---------------------------------");
        System.out.println("Conteudos inscritos Maycon: "+devMaycon.getConteudosInscritos());
        System.out.println("Conteudos concluídos Maycon: "+devMaycon.getConteudosConcluidos());
        System.out.println("XP:"+devMaycon.calcularTotalXp());
        devMaycon.progredir();
        System.out.println("XP:"+devMaycon.calcularTotalXp());


        System.out.println("---------------------------------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos João: "+devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("---------------------------------");
        System.out.println("Conteudos inscritos João: "+devJoao.getConteudosInscritos());
        System.out.println("Conteudos concluídos João: "+devJoao.getConteudosConcluidos());
        System.out.println("XP: "+devJoao.calcularTotalXp());



    }
}
