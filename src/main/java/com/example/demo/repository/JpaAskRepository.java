package com.example.demo.repository;

import com.example.demo.domain.Ask;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaAskRepository implements AskRepository {

    private final EntityManager em;

    public JpaAskRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Ask save(Ask ask) {
        em.persist(ask);
        return ask;
    }



    @Override
    public Optional<Ask> findByNo(Long no) {
        Ask ask = em.find(Ask.class, no);
        return Optional.ofNullable(ask);
    }

    @Override
    public Optional<Ask> findByTitle(String title) {
        List<Ask> result = em.createQuery("select a from Ask a where a.title = :title", Ask.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }
    @Override
    public Optional<Ask> findByContents(String contents) {
        List<Ask> result = em.createQuery("select a from Ask a where a.contents = :contents", Ask.class)
                .setParameter("contents", contents)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Ask> findByTitleContaining(String title) {
        return em.createQuery("select a from Ask a where a.title like :title", Ask.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }
    @Override
    public List<Ask> findByContentsContaining(String contents) {
        return em.createQuery("select a from Ask a where a.contents like :contents", Ask.class)
                .setParameter("contents", "%" + contents + "%")
                .getResultList();
    }

  /*  @Override
    public Optional<Ask> findByWriterNo(Long writerNo) {
        List<Ask> result = em.createQuery("select a from Ask a where a.writerNo = :writerNo", Ask.class)
                .setParameter("writerNo", writerNo)
                .getResultList();
        return result.stream().findAny();
    }*/

    @Override
    public Optional<Ask> findByTags(String tags) {
        List<Ask> result = em.createQuery("select a from Ask a where a.tags = :tags", Ask.class)
                .setParameter("tags", tags)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Ask> findByCreatedDate(String createdDate) {
        List<Ask> result = em.createQuery("select a from Ask a where a.createdDate = :createdDate", Ask.class)
                .setParameter("createdDate", createdDate)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Ask> findAll() {
        return em.createQuery("select a from Ask a", Ask.class)
                .getResultList();
    }

    @Override
    public void deleteByNo(Long no) {
        em.createQuery("delete from Ask a where a.no = :no")
                .setParameter("no", no)
                .executeUpdate();
    }
}
