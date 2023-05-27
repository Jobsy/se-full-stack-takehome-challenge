
package com.secretescapes.favouriteservice.controller;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.secretescapes.favouriteservice.model.Favourite;
import com.secretescapes.favouriteservice.service.FavouriteService;

@RestController
@RequestMapping("/favourites")
@CrossOrigin
public class FavouriteServiceController {

    private FavouriteService favouriteService;

    @Autowired
    public FavouriteServiceController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    /**
     * Retrieves the favorites by user ID and sale ID.
     *
     * @param userId the user ID
     * @param saleId the sale ID
     * @return the response entity containing the favorites
     */
    @GetMapping("getFavoritesByUserIdAndSaleId/{userId}/{saleId}")
    public ResponseEntity<?> getFavoritesByUserIdAndSaleId(
            @PathVariable String userId,
            @PathVariable String saleId) {
        try {
            Optional<Favourite> favourites = favouriteService.getFavoritesByUserIdAndSaleId(userId, saleId);
            return ResponseEntity.ok(favourites);
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve favorites for user and sale " + userId + " " + e;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    /**
     * Retrieves all favorites by user ID.
     *
     * @param userId the user ID
     * @return the response entity containing the favorites
     */
    @GetMapping("getAllFavoritesByUserId/{userId}")
    public ResponseEntity<?> getAllFavoritesByUserId(@PathVariable String userId) {
        try {
            List<Favourite> favourites = favouriteService.getAllFavoritesByUserId(userId);
            return ResponseEntity.ok(favourites);
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve favorites for user " + userId + " " + e;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    /**
     * Adds a favorite.
     *
     * @param body the request body containing the user ID and sale ID
     * @return the response entity indicating the status of the operation
     */
    @PostMapping("add")
    public ResponseEntity<?> addFavorite(@RequestBody Map<String, String> body) {
        String userId = body.get("userId");
        String saleId = body.get("saleId");

        try {
            ResponseEntity<String> favourites = favouriteService.addFavorite(userId, saleId);
            return ResponseEntity.ok(favourites);
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve favorites for user " + userId + " " + e;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    /**
     * Removes a favorite by user ID and sale ID.
     *
     * @param userId the user ID
     * @param saleId the sale ID
     * @return true if the favorite was successfully removed, false otherwise
     */
    @DeleteMapping("delete/{userId}/{saleId}")
    public boolean removeFavorite(
            @PathVariable String userId,
            @PathVariable String saleId) {
        return favouriteService.removeFavorite(userId, saleId);
    }

}
