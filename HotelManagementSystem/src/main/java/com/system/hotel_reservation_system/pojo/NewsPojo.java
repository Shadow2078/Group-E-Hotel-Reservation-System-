package com.system.hotel_reservation_system.pojo;

import com.system.hotel_reservation_system.entity.News;
import com.system.hotel_reservation_system.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsPojo {
    private Integer id;
    private String names;

    private String emails;

    private String descriptions;

    public NewsPojo(News news){
        this.id= news.getId();
        this.names= news.getNames();
        this.emails= news.getEmails();
        this.descriptions= news.getDescriptions();
    }
}
