package main.java.com.miniproject2.bookcafe.dto;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Getter
@Setter
public class CommentsRequestDto {
    private Long commentId;
    private Long moinID;
    private String nickname;
    private String comment;
}
