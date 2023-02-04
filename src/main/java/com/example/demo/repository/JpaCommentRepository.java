package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JpaCommentRepository implements CommentRepository {
    private final EntityManager em;

    public JpaCommentRepository(EntityManager em) {
this.em = em;
}
    @Override//save comment
    public Comment save(Comment comment) {
        em.persist(comment);
        return comment;

    }



    @Override
    public Optional<Comment> findByCommentNo(Long commentNo) {
        Comment comment = em.find(Comment.class, commentNo);
        return Optional.ofNullable(comment);
    }

    @Override
    public List<Comment> findByCommentGroup(Long commentGroup) {
        return em.createQuery("select c from Comment c where c.commentGroup = :commentGroup", Comment.class)
                .setParameter("commentGroup", commentGroup)
                .getResultList();
    }

   /* @Override
    public Comment update(Long commentNo, String reply) {
        Comment comment = em.find(Comment.class, commentNo);
        comment.setReply(reply);
        return comment;
    }*/

    @Override
    public Optional<Comment> findByReply(String reply) {
        return Optional.empty();
    }

    @Override
    public Optional<Comment> findByReplyDate(String replyDate) {
        return Optional.empty();
    }

    @Override
    public List<Comment> findByReplyContaining(String reply) {
        return null;
    }

    @Override
    public List<Comment> findByReplyDateContaining(String replyDate) {
        return null;
    }



    @Override//find comments List by askNo
    public Optional<Comment> findByAskNo(Long askNo) {
        Comment comment = em.find(Comment.class, askNo);
        return Optional.ofNullable(comment);
    }

    @Override
    public List<Comment> findAllByAskNo(Long askNo) {
        return em.createQuery("select c from Comment c, Ask a where c.ask.no = :askNo", Comment.class)
                .setParameter("askNo", askNo)
                .getResultList();
    }

    @Override
    public List<Comment> findAllByCommentGroup(Long commentGroup) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }




    @Override
    public Comment findBySelectedAndAskNo(String selected, Long askNo){
        return em.createQuery("select c from Comment c where c.ask.no=:askNo and c.selected=:selected" , Comment.class)
                .setParameter("askNo", askNo)
                .setParameter("selected", selected)
                .getSingleResult();
    }

    @Override
    public List<Comment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Comment> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override//delete comment
    public void delete(Comment entity) {
        em.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Comment> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Comment> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Comment> findById(Long aLong) {
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
    public <S extends Comment> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Comment> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Comment getOne(Long aLong) {
        return null;
    }

    @Override
    public Comment getById(Long aLong) {
        return null;
    }

    @Override
    public Comment getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Comment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Comment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Comment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Comment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Comment> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Comment, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

