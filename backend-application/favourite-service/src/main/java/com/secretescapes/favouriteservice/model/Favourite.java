package com.secretescapes.favouriteservice.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favourites")
@NoArgsConstructor
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "sale_id")
    private String saleId;

    public Favourite(String userId, String saleId) {
        this.userId = userId;
        this.saleId = saleId;
    }

    /**
     * Get the ID of the favorite.
     *
     * @return The ID of the favorite.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the ID of the favorite.
     *
     * @param id The ID of the favorite.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the user ID associated with the favorite.
     *
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set the user ID associated with the favorite.
     *
     * @param userId The user ID.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get the sale ID associated with the favorite.
     *
     * @return The sale ID.
     */
    public String getSaleId() {
        return saleId;
    }

    /**
     * Set the sale ID associated with the favorite.
     *
     * @param saleId The sale ID.
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }
}
