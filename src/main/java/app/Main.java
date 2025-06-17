package app;

import model.*;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Criar coleção
        Colecao col = new Colecao();
        col.setId_colecao("c1");
        col.setNome("Verão 2025");
        col.setData_inicio(new Date());
        col.setData_fim(new Date());

        // Criar estampa
        Estampa estampa = new Estampa();
        estampa.setId_estampa("e1");
        estampa.setNome("Estampa Floral");
        estampa.setQuantidade(100);
        estampa.setColecao(col);

        // Criar peça
        Peca peca = new Peca();
        peca.setPeca_id("p1");
        peca.setTipo("Camiseta");
        peca.setTamanho("M");
        peca.setCor("Azul");
        peca.setQuantidade(50);

        // Relacionar
        estampa.setPecas(Arrays.asList(peca));
        peca.setEstampas(Arrays.asList(estampa));
        col.setEstampas(Arrays.asList(estampa));

        // Persistir
        session.persist(peca);
        session.persist(estampa);
        session.persist(col);

        session.getTransaction().commit();
        session.close();
    }
}
