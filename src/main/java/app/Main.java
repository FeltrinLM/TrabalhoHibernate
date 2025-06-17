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

        // ----------- COLEÇÕES -----------
        Colecao colecao1 = new Colecao();
        colecao1.setId_colecao("c1");
        colecao1.setNome("Verão 2025");
        colecao1.setData_inicio(new Date());
        colecao1.setData_fim(new Date());

        Colecao colecao2 = new Colecao();
        colecao2.setId_colecao("c2");
        colecao2.setNome("Inverno 2025");
        colecao2.setData_inicio(new Date());
        colecao2.setData_fim(new Date());

        // ----------- PEÇAS -----------
        Peca peca1 = new Peca();
        peca1.setPeca_id("p1");
        peca1.setTipo("Camiseta");
        peca1.setTamanho("M");
        peca1.setCor("Azul");
        peca1.setQuantidade(100);

        Peca peca2 = new Peca();
        peca2.setPeca_id("p2");
        peca2.setTipo("Calça");
        peca2.setTamanho("G");
        peca2.setCor("Preto");
        peca2.setQuantidade(80);

        Peca peca3 = new Peca();
        peca3.setPeca_id("p3");
        peca3.setTipo("Jaqueta");
        peca3.setTamanho("P");
        peca3.setCor("Vermelho");
        peca3.setQuantidade(40);

        Peca peca4 = new Peca();
        peca4.setPeca_id("p4");
        peca4.setTipo("Vestido");
        peca4.setTamanho("M");
        peca4.setCor("Branco");
        peca4.setQuantidade(60);

        // ----------- ESTAMPAS -----------
        Estampa estampa1 = new Estampa();
        estampa1.setId_estampa("e1");
        estampa1.setNome("Floral");
        estampa1.setQuantidade(50);
        estampa1.setColecao(colecao1);
        estampa1.setPecas(Arrays.asList(peca1, peca2)); // Floral vai em camiseta e calça

        Estampa estampa2 = new Estampa();
        estampa2.setId_estampa("e2");
        estampa2.setNome("Geométrica");
        estampa2.setQuantidade(70);
        estampa2.setColecao(colecao1);
        estampa2.setPecas(Arrays.asList(peca2, peca3)); // Geométrica vai em calça e jaqueta

        Estampa estampa3 = new Estampa();
        estampa3.setId_estampa("e3");
        estampa3.setNome("Listrada");
        estampa3.setQuantidade(40);
        estampa3.setColecao(colecao2);
        estampa3.setPecas(Arrays.asList(peca1, peca4)); // Listrada vai em camiseta e vestido

        // Associar estampas nas peças (bidirecional)
        peca1.setEstampas(Arrays.asList(estampa1, estampa3));
        peca2.setEstampas(Arrays.asList(estampa1, estampa2));
        peca3.setEstampas(Arrays.asList(estampa2));
        peca4.setEstampas(Arrays.asList(estampa3));

        // Associar estampas nas coleções
        colecao1.setEstampas(Arrays.asList(estampa1, estampa2));
        colecao2.setEstampas(Arrays.asList(estampa3));

        // ----------- PERSISTIR TUDO -----------
        session.persist(peca1);
        session.persist(peca2);
        session.persist(peca3);
        session.persist(peca4);

        session.persist(estampa1);
        session.persist(estampa2);
        session.persist(estampa3);

        session.persist(colecao1);
        session.persist(colecao2);

        session.getTransaction().commit();
        session.close();
    }
}
