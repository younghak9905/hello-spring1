package com.example.demo.repository;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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


    //titleContaining


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
    public List<Ask> findAll(Sort sort) {

        return null;
    }

    @Override
    public Page<Ask> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Ask> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {


    }

    @Override
    public void delete(Ask entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ask> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Ask> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Ask> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Ask> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Ask> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Ask> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Ask getOne(Long aLong) {
        return null;
    }

    @Override
    public Ask getById(Long aLong) {
        return null;
    }

    @Override
    public Ask getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Ask> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Ask> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Ask> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Ask> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ask> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Ask> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Ask, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public void deleteByNo(Long no) {
        em.createQuery("delete from Ask a where a.no = :no")
                .setParameter("no", no)
                .executeUpdate();
    }
}
