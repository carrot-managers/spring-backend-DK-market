package com.opensource.backdk.controller;

import com.opensource.backdk.domain.Comment;
import com.opensource.backdk.domain.Users;
import com.opensource.backdk.service.CommentService;
import com.opensource.backdk.service.GoodsService;
import lombok.RequiredArgsConstructor;
import com.opensource.backdk.dto.AddCommentDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final GoodsService goodsService;
    private final CommentService commentService;

    @PostMapping("/goods/{goodsId}/addComment")
    public Comment addComment(@PathVariable Long goodsId, @RequestBody AddCommentDto dto, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        return commentService.add(dto, user.getUserId(), goodsId);
    }

    @DeleteMapping("/goods/{goodsId}/{commentId}/removeComment")
    public void removeComment(@PathVariable Long goodsId, @PathVariable Long commentId,
                              HttpServletRequest request) throws IllegalAccessException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        commentService.remove(commentId, goodsId, user.getUserId());
    }
}
