package com.secretescapes.favouriteservice.service;

import com.secretescapes.favouriteservice.model.Favourite;
import com.secretescapes.favouriteservice.repository.FavouriteServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class FavouriteService {

    private FavouriteServiceRepository favouriteRepository;

    @Autowired
    public FavouriteService(FavouriteServiceRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    public Optional<Favourite> getFavoritesByUserIdAndSaleId(String userId, String saleId) {
        try {
            Optional<Favourite> existingFavourite = favouriteRepository.findByUserIdAndSaleId(userId, saleId);
            if (existingFavourite.isPresent()) {
                return existingFavourite;
            } else {
                throw new NoSuchElementException("Favorite not found");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user or sale ID", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve favorite", e);
        }
    }

    public List<Favourite> getAllFavoritesByUserId(String userId) {
        try {
            List<Favourite> favourites = favouriteRepository.findByUserId(userId);
            if (favourites.isEmpty()) {
                throw new NoSuchElementException("Favorites not found");
            }
            return favourites;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user ID", e);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorites not found", e);
        }  catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve favorites", e);
        }
    }

    public ResponseEntity<String> addFavorite(String userId, String saleId) {
        try {
            return favouriteRepository.findByUserIdAndSaleId(userId, saleId)
                    .map(f -> ResponseEntity.ok("Favorite already exists"))
                    .orElseGet(() -> {
                        Favourite favourite = new Favourite(userId, saleId);
                        favouriteRepository.save(favourite);
                        return ResponseEntity.ok("Favorite added successfully");
                    });
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add favorite", e);
        }
    }

    public boolean removeFavorite(String userId, String saleId) {
        try {
            Optional<Favourite> existingFavourite = favouriteRepository.findByUserIdAndSaleId(userId, saleId);

            if (existingFavourite.isPresent()) {
                favouriteRepository.delete(existingFavourite.get());
                return true;
            } else {
                throw new NoSuchElementException("Favorite not found");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user or sale ID", e);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite not found", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to remove favorite", e);
        }
    }
}