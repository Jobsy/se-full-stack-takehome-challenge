import React, { createContext, useEffect, useState } from 'react';
import { addFavourite, deleteFavourite, getAllFavoritesByUserId } from '../api/favourite';

interface FavouriteContextType {
    favourites: string[];
    toggleFavourite: (id: string) => void;
    isFavourite: (id: string) => boolean;
    logout: () => void;
  }
  
  interface FavouriteProviderProps {
    children: React.ReactNode;
  }
  
  export const FavouriteContext = createContext<FavouriteContextType>({
    favourites: [],
    toggleFavourite: () => {},
    isFavourite: () => false,
    logout: () => {},
  });
  

export const FavouriteProvider: React.FC<FavouriteProviderProps> = ({ children }) => {
  const [favourites, setFavourites] = useState<string[]>([]);
  const [favouriteSaleIds, setFavouriteSaleIds] = useState<string[]>([]);
  const userId = localStorage.getItem("SE_USER_ID");

  const getSaleIdsFromFavourites = (favouritesPromiseResult: any[]) => {
    return favouritesPromiseResult.map((favourite: { saleId: string; }) => favourite.saleId);
  };
      
  const getSaleIds = async (userId: string | null) => {
    const favourites = await getAllFavoritesByUserId(userId || "");
    const saleIds = getSaleIdsFromFavourites(favourites);
    setFavouriteSaleIds(saleIds);
    setFavourites(saleIds);
  };

  useEffect(() => {
    // Reset favourites when a new user logs in
    setFavourites([]);

    const storedFavourites = localStorage.getItem(`favourites_${userId}`);
    if (storedFavourites) {
      setFavourites(JSON.parse(storedFavourites));
    } 
    else if (favouriteSaleIds) {
        getSaleIds(userId);
    }
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [userId]);
  
  useEffect(() => {
    if (favourites.length > 0 && userId) {
      localStorage.setItem(`favourites_${userId}`, JSON.stringify(favourites));
      setFavourites(favourites)
    }
  }, [favourites, userId]);

  const toggleFavourite = async (id: string) => {
    try {
        if (favourites.includes(id)) {
        await deleteFavourite(userId || "", id); // Call removeFavourite method on server
        setFavourites(prev => prev.filter(f => f !== id));
        } else {
        await addFavourite(userId || "", id); // Call addFavourite method on server
        setFavourites(prev => [...prev, id]);
        }
    } catch (error) {
        console.error("Error toggling favourite:", error);
    }
  };

  const isFavourite = (id: string) => favourites.includes(id);

  const logout = () => {
    localStorage.removeItem(`favourites_${userId}`);
    setFavourites([]);
  };

  return (
    <FavouriteContext.Provider value={{ favourites, toggleFavourite, isFavourite, logout }}>
      {children}
    </FavouriteContext.Provider>
  );
};
