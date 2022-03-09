package com.venuebooking.venuebookingwork.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


public interface CommentRepository extends JpaRepository<Comment, Long> {


    Comment findByReviewerAndPublishTime(String reviewer, String publishTime);


    @Modifying
    @Transactional
    void deleteByCommentID(Long commentID);

}
