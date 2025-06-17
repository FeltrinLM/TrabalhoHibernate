package app;

import model.Estampa;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class Consulta {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Exibe explicação da consulta no console
        System.out.println(">> Consulta: retorna o nome da estampa e o nome da coleção à qual ela pertence");

        String hql = "SELECT e.nome, e.colecao.nome FROM Estampa e";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> resultados = query.getResultList();

        for (Object[] linha : resultados) {
            String nomeEstampa = (String) linha[0];
            String nomeColecao = (String) linha[1];
            System.out.println("Estampa: " + nomeEstampa + " | Coleção: " + nomeColecao);
        }

        session.close();
    }
}
