package com.quarkus.util;

import com.quarkus.entity.CommentEntity;
import com.quarkus.entity.PostEntity;
import com.quarkus.entity.UserEntity;
import com.quarkus.model.Comment;
import com.quarkus.model.Post;
import com.quarkus.model.UserDetail;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelMapper {

    public static Post mapPostEntityToPost(PostEntity postEntity) {
        return Post.builder()
                .title(postEntity.getTitle())
                .text(postEntity.getText())
                .tags(postEntity.getTags())
                .date(createDate(postEntity.getDate()))
                .build();
    }

    public static List<Post> mapPostEntitiesToPost(List<PostEntity> postEntities) {
        return postEntities.stream()
                .map(ModelMapper::mapPostEntityToPost)
                .collect(Collectors.toList());
    }

    public static UserDetail mapUserEntityToUserDetail(UserEntity userEntity) {
        return UserDetail.builder()
                .username(userEntity.getCredentialEntity().getUsername())
                .firstName(userEntity.getName())
                .lastName(userEntity.getLastName())
                .build();
    }

    public static Comment mapCommentEntityToComment(CommentEntity commentEntity) {
        return Comment.builder()
                .commentText(commentEntity.getComment())
                .date(createDate(commentEntity.getDate()))
                .userDetail(mapUserEntityToUserDetail(commentEntity.getUserEntity()))
                .build();
    }

    public static String createDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(date);
    }

    public static List<Comment> mapCommentEntitiesToComment(List<CommentEntity> commentEntities) {
        return commentEntities.stream()
                .map(ModelMapper::mapCommentEntityToComment)
                .collect(Collectors.toList());
    }
}
