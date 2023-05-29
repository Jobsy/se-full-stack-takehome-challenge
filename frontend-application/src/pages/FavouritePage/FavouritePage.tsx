import * as React from "react";

import { FavouriteCard } from "../../components";
import { ISale } from "../../utils/Sale.interface";
import { Favourite } from '../../utils/Favourite.interface';
import { useFetchFavouriteSale } from '../../utils/UseFetchFavouriteSale';
import { SearchResultsContainer } from "../SearchResults/SearchResults.styles";

interface Props {
  userId: string;
}

export const FavouritePage: React.FC<Props> = ({ userId }) => {
  // eslint-disable-next-line 
  const [favourites, setFavourites] = React.useState<Partial<Favourite>[]>([]);
  const { sales, loading, error  } = useFetchFavouriteSale({ saleIds: favourites.map(favourite => favourite.saleId) });
  const storedFavourites = localStorage.getItem(`favourites_${userId}`);

  function filterSalesByFavourites(sales: ISale[], favouriteId: string | string[] | null) {
    try {
      // Filter sales by whether their id is in the favouriteId array
      const filteredSales = sales?.filter((sale: { id: string }) => favouriteId?.includes(sale.id));
      return filteredSales;
    } catch (error) {
      // Handle any errors that occur during filtering
      console.error("Error filtering sales by favourites:", error);
      return [];
    }
  }
  
  const favourite = filterSalesByFavourites(sales, storedFavourites)
  
  return (
    <SearchResultsContainer>
      {loading && <div>Loading...</div>}
      {error && <div>Error fetching sales...</div>}
      {favourite?.length === 0 && <div>No favourites added yet.</div>}
      {userId && favourite?.map((sale: Partial<Favourite>, idx: React.Key) => (
        <FavouriteCard key={idx} favourite={sale} />
      ))}
    </SearchResultsContainer>
  );
};
