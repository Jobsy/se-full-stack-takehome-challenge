//package com.secretescapes.favouriteservice.service;
//
//import com.secretescapes.favouriteservice.model.Favourite;
//import com.secretescapes.favouriteservice.repository.FavouriteServiceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//
//@Service
//public class FavouriteService {
//
//    private FavouriteServiceRepository favouriteRepository;
//
//    @Autowired
//    public FavouriteService(FavouriteServiceRepository favouriteRepository) {
//        this.favouriteRepository = favouriteRepository;
//    }
//
//    public Optional<Favourite> getFavoritesByUserIdAndSaleId(String userId, String saleId) {
//        try {
//            Optional<Favourite> existingFavourite = favouriteRepository.findByUserIdAndSaleId(userId, saleId);
//            if (existingFavourite.isPresent()) {
//                return existingFavourite;
//            } else {
//                throw new NoSuchElementException("Favorite not found");
//            }
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user or sale ID", e);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve favorite", e);
//        }
//    }
//
//    public List<Favourite> getAllFavoritesByUserId(String userId) {
//        try {
//            List<Favourite> favourites = favouriteRepository.findByUserId(userId);
//            if (favourites.isEmpty()) {
//                throw new NoSuchElementException("Favorites not found");
//            }
//            return favourites;
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user ID", e);
//        } catch (NoSuchElementException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorites not found", e);
//        }  catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve favorites", e);
//        }
//    }
//
//    public ResponseEntity<String> addFavorite(String userId, String saleId) {
//        try {
//            return favouriteRepository.findByUserIdAndSaleId(userId, saleId)
//                    .map(f -> ResponseEntity.ok("Favorite already exists"))
//                    .orElseGet(() -> {
//                        Favourite favourite = new Favourite(userId, saleId);
//                        favouriteRepository.save(favourite);
//                        return ResponseEntity.ok("Favorite added successfully");
//                    });
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add favorite", e);
//        }
//    }
//
//    public boolean removeFavorite(String userId, String saleId) {
//        try {
//            Optional<Favourite> existingFavourite = favouriteRepository.findByUserIdAndSaleId(userId, saleId);
//
//            if (existingFavourite.isPresent()) {
//                favouriteRepository.delete(existingFavourite.get());
//                return true;
//            } else {
//                throw new NoSuchElementException("Favorite not found");
//            }
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user or sale ID", e);
//        } catch (NoSuchElementException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite not found", e);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to remove favorite", e);
//        }
//    }
//}

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

/**
 * Service class for managing favorites.
 */
@Service
public class FavouriteService {

    private final FavouriteServiceRepository favouriteRepository;

    /**
     * Constructs a new FavouriteService with the given repository.
     *
     * @param favouriteRepository The repository for favorites.
     */
    @Autowired
    public FavouriteService(FavouriteServiceRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    /**
     * Retrieves the favorite by user ID and sale ID.
     *
     * @param userId The user ID.
     * @param saleId The sale ID.
     * @return The optional favorite.
     * @throws ResponseStatusException If the favorite is not found or if there is an error retrieving it.
     */
    public Optional<Favourite> getFavoritesByUserIdAndSaleId(final String userId, final String saleId) {
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

    /**
     * Retrieves all the favorites by user ID.
     *
     * @param userId The user ID.
     * @return The list of favorites.
     * @throws ResponseStatusException If the favorites are not found or if there is an error retrieving them.
     */
    public List<Favourite> getAllFavoritesByUserId(final String userId) {
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
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve favorites", e);
        }
    }

    /**
     * Adds a favorite for the given user ID and sale ID.
     *
     * @param userId The user ID.
     * @param saleId The sale ID.
     * @return A response entity indicating the result of the operation.
     * @throws ResponseStatusException If there is an error adding the favorite.
     */
    public ResponseEntity<String> addFavorite(final String userId, final String saleId) {
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

    /**
     * Removes a favorite for the given user ID and sale ID.
     *
     * @param userId The user ID.
     * @param saleId The sale ID.
     * @return A response entity indicating the result of the operation.
     * @throws ResponseStatusException If there is an error removing the favorite.
     */
    public ResponseEntity<String> removeFavorite(final String userId, final String saleId) {
        try {
            Optional<Favourite> existingFavourite = favouriteRepository.findByUserIdAndSaleId(userId, saleId);
            if (existingFavourite.isPresent()) {
                favouriteRepository.delete(existingFavourite.get());
                return ResponseEntity.ok("Favorite removed successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to remove favorite", e);
        }
    }
}
