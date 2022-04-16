package kz.dar.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailsModel {
    String postId;
    ClientModel client;
    ClientModel receiver;
    String postItem;
    String status;
}
