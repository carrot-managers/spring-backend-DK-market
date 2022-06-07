package com.opensource.backdk.service;

import com.opensource.backdk.domain.Comment;
import com.opensource.backdk.domain.Goods;
import com.opensource.backdk.domain.Users;
import com.opensource.backdk.repository.CommentRepository;
import com.opensource.backdk.repository.GoodsRepository;
import com.opensource.backdk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.opensource.backdk.dto.AddCommentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Comment add(AddCommentDto dto, String userId, Long goodsId){
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                ()-> new NullPointerException("상품이 존재하지 않습니다.")
        );
        Comment comment = new Comment(dto, userId, goods);
        goods.addComment(comment);

        return commentRepository.save(comment);
    }

    @Transactional
    public void remove(Long commentId, Long goodsId, String userId) throws IllegalAccessException {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                ()-> new NullPointerException("상품이 존재하지 않습니다.")
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 댓글입니다.")
        );
        if (goods.getAuthorId().equals(userId) || userId.equals(comment.getUserId())){
            commentRepository.delete(comment);
            goods.getComments().remove(comment);
        }else{
            throw new IllegalAccessException("권한이 없습니다.");
        }
    }
}
